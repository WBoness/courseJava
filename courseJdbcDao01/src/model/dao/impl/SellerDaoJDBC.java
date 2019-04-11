package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.DB;
import db.DbException;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

/*
 * Classe vai implementar a Interface SellerDao
 * 		-  O DAO tem uma depend~encia com a conex�o 
 */


public class SellerDaoJDBC implements SellerDao {

	//depend�ncia com a conex�o 
	private Connection conn; //objeto ficar� � disposi��o nos m�todos
	
	//para for�ar a inje��o de depend�ncia, cria-se um construtor
	public SellerDaoJDBC(Connection conn) {
		this.conn=conn;
	}
	
	@Override
	public void insert(Seller vendor) {

		PreparedStatement st=null;
		try {
			st=conn.prepareStatement("INSERT INTO Seller "
					+ "(Name, Email, BirthDate, BaseSalary, DepartmentId) "
					+ "VALUES "
					+ "(?, ?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			st.setString(1, vendor.getName());
			st.setString(2, vendor.getEmail());
			st.setDate(3, new java.sql.Date(vendor.getBirthDate().getTime()));
			st.setDouble(4, vendor.getBaseSalary());
			st.setInt(5, vendor.getDepartment().getId());
			int rowsAffectedrs= st.executeUpdate();
			
			if (rowsAffectedrs>0) {
				ResultSet rs= st.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					vendor.setId(id);// insere o id no objeto
				}
				DB.closeResultSet(rs);//O escopo � s� aqui!
			}else {
				throw new DbException("Erro inesperado! nenhuma inser��o foi verificada.");
			} 
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());			
		}
		finally{
			//fechar os recursos
			DB.closeStatement(st);
			// n�o fecha a conex�o. Fecha na aplica��o depois para poder 
			// aproveitar o mesmo DAO
		}		
	}

	@Override
	public void update(Seller vendor) {
				
	}

	@Override
	public void deleteById(Integer id) {
		
		
	}

	@Override
	public Seller findById(Integer id) {
		
		PreparedStatement st=null;
		ResultSet rs = null;
		try {
			st=conn.prepareStatement("SELECT seller.*,department.Name "
					+ "as DepName FROM seller "
					+ "INNER JOIN department "
					+ "ON seller.DepartmentId = department.Id "
					+ "WHERE seller.Id = ?");
			st.setInt(1, id);
			rs= st.executeQuery();
		/*
		 * O resultado disso � um resultset (tabela);
		 * Deseja-se em formato de objetos associados (vendor-Seller e Book -depto)
		 * O resultset aponta para a posi��o 0 (sem objeto)
		 * 		testa se h� registro
		 * 		se houver, navega-se para INSTANCIAR os elementos
		 */
		
		//testando se h� registro
			if (rs.next()) {
				Department depto = instantiateDepartment(rs);//chama m�todo auxiliar
				Seller vendor = instantiateSeller(rs, depto);
				return vendor;
			}
		return null; //se n�o entrar no if ->(n�o existir o objeto)
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());			
		}
		finally{
			//fechar os recursos
			DB.closeStatement(st);
			DB.closeResultSet(rs);
			// n�o fecha a conex�o. Fecha na aplica��o depois para poder 
			// aproveitar o mesmo DAO
		} 
		
	}
	
	// m�todo auxiliar para instancia��o do objeto seller (exce��o � tratada no principal
	private Seller instantiateSeller(ResultSet rs, Department depto) throws SQLException {
		Seller vendor = new Seller();
		vendor.setId(rs.getInt("Id"));
		vendor.setName(rs.getString("Name"));
		vendor.setEmail(rs.getString("Email"));
		vendor.setBaseSalary(rs.getDouble("BaseSalary"));
		vendor.setBirthDate(rs.getDate("BirthDate"));
		vendor.setDepartment(depto);//n�o � o ID, mas o objeto Departamento
		return vendor;
	}

	// m�todo auxiliar para instancia��o do objeto depto (exce��o � tratada no principal)
	private Department instantiateDepartment(ResultSet rs) throws SQLException {
		Department depto= new Department();
		depto.setId(rs.getInt("DepartmentId"));
		depto.setNome(rs.getString("DepName"));
		return depto;
	}
	
	

	@Override
	public List<Seller> findAll() {
		PreparedStatement st=null;
		ResultSet rs = null;
		try {
			st=conn.prepareStatement("SELECT seller.*,department.Name as DepName "+
					"FROM seller INNER JOIN department " +
					"ON seller.DepartmentId = department.Id "+
					"ORDER BY Name");
			rs= st.executeQuery();
		/*
		 * O resultado disso � um resultset (tabela);
		 * Deseja-se em formato de objetos associados (vendor-Seller e Book -depto)
		 * O resultset aponta para a posi��o 0 (sem objeto)
		 * 		testa se h� registro
		 * 		se houver, navega-se para INSTANCIAR os elementos
		 */
		
			List<Seller> lista = new ArrayList<>();// lista de vendedores
			Map<Integer, Department> map = new HashMap<>();//guarda a lista de departamentos
														//SEM REPETI��O, para fazer o relacionamento
														//correto (vendedor *---1 Departamento)
			
			
			//testando se h� registro (mas pode ser mais de um troc o if por while)
			while (rs.next()) {
				//testa se j� existe o departamento (dep) na lista (map)
				Department dep = map.get(rs.getInt("DepartmentId"));//se o depto j� existir, reaproveita e coloca em dep
				
				if (dep==null) {
					dep = instantiateDepartment(rs);//chama m�todo auxiliar
					map.put(rs.getInt("DepartmentId"), dep); //salva dep no map
				}
				Seller vendor = instantiateSeller(rs, dep);// usa o dep novo ou existente
				lista. add(vendor);
			}
		return lista; 
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());			
		}
		finally{
			//fechar os recursos
			DB.closeStatement(st);
			DB.closeResultSet(rs);
			// n�o fecha a conex�o. Fecha na aplica��o depois para poder 
			// aproveitar o mesmo DAO
		} 
	}

	@Override
	public List<Seller> findByDepartment(Department depto) {
		PreparedStatement st=null;
		ResultSet rs = null;
		try {
			st=conn.prepareStatement("SELECT seller.*,department.Name as DepName "+
					"FROM seller INNER JOIN department " +
					"ON seller.DepartmentId = department.Id "+
					"WHERE DepartmentId = ? "+
					"ORDER BY Name");
			st.setInt(1, depto.getId());
			rs= st.executeQuery();
		/*
		 * O resultado disso � um resultset (tabela);
		 * Deseja-se em formato de objetos associados (vendor-Seller e Book -depto)
		 * O resultset aponta para a posi��o 0 (sem objeto)
		 * 		testa se h� registro
		 * 		se houver, navega-se para INSTANCIAR os elementos
		 */
		
			List<Seller> lista = new ArrayList<>();// lista de vendedores
			Map<Integer, Department> map = new HashMap<>();//guarda a lista de departamentos
														//SEM REPETI��O, para fazer o relacionamento
														//correto (vendedor *---1 Departamento)
			
			
			//testando se h� registro (mas pode ser mais de um troc o if por while)
			while (rs.next()) {
				//testa se j� existe o departamento (dep) na lista (map)
				Department dep = map.get(rs.getInt("DepartmentId"));//se o depto j� existir, reaproveita e coloca em dep
				
				if (dep==null) {
					dep = instantiateDepartment(rs);//chama m�todo auxiliar
					map.put(rs.getInt("DepartmentId"), dep); //salva dep no map
				}
				Seller vendor = instantiateSeller(rs, dep);// usa o dep novo ou existente
				lista. add(vendor);
			}
		return lista; 
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());			
		}
		finally{
			//fechar os recursos
			DB.closeStatement(st);
			DB.closeResultSet(rs);
			// n�o fecha a conex�o. Fecha na aplica��o depois para poder 
			// aproveitar o mesmo DAO
		} 
		
	}

}
