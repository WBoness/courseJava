package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

/*
 * Classe vai implementar a Interface SellerDao
 * 		-  O DAO tem uma depend~encia com a conexão 
 */


public class SellerDaoJDBC implements SellerDao {

	//dependência com a conexão 
	private Connection conn; //objeto ficará à disposição nos métodos
	
	//para forçar a injeção de dependência, cria-se um construtor
	public SellerDaoJDBC(Connection conn) {
		this.conn=conn;
	}
	
	@Override
	public void insert(Seller vendor) {
				
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
		 * O resultado disso é um resultset (tabela);
		 * Deseja-se em formato de objetos associados (vendor-Seller e Book -depto)
		 * O resultset aponta para a posição 0 (sem objeto)
		 * 		testa se há registro
		 * 		se houver, navega-se para INSTANCIAR os elementos
		 */
		
		//testando se há registro
			if (rs.next()) {
				Department depto = new Department();
				depto.setId(rs.getInt("DepartmentId"));
				depto.setNome(rs.getString("DepName"));
				Seller vendor = new Seller();
				vendor.setId(rs.getInt("Id"));
				vendor.setName(rs.getString("Name"));
				vendor.setEmail(rs.getString("Email"));
				vendor.setBaseSalary(rs.getDouble("BaseSalary"));
				vendor.setBirthDate(rs.getDate("BirthDate"));
				vendor.setDepartment(depto);//não é o ID, mas o objeto Departamento
				return vendor;
			}
		return null; //se não entrar no if ->(não existir o objeto)
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());			
		}
		finally{
			//fechar os recursos
			DB.closeStatement(st);
			DB.closeResultSet(rs);
			// não fecha a conexão. Fecha na aplicação depois para poder 
			// aproveitar o mesmo DAO
		} 
		
	}

	@Override
	public List<Seller> findAll() {
		
		return null;
	}

}
