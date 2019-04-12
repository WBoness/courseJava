package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.DepartmentDao;
import model.entities.Department;

public class DepartmentDaoJDBC implements DepartmentDao{
	private Connection conn;
	
	public DepartmentDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public void insert(Department depto) {
		
	}

	@Override
	public void update(Department depto) {
		
	}

	@Override
	public void deleteById(Integer id) {
		
		
	}

	@Override
	public Department findById(Integer id) {
		PreparedStatement st =null;
		ResultSet rs=null;
		try {
			st=conn.prepareStatement("SELECT * FROM Department WHERE Id = ?");
			st.setInt(1,id);
			rs=st.executeQuery();
			if (rs.next()) {
				Department depto = instantiateDepartment(rs);
				return depto;
			}
		return null;
			
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
		}
	}

	@Override
	public List<Department> findAll() {
		PreparedStatement st =null;
		ResultSet rs=null;
		try {
			st=conn.prepareStatement("SELECT * FROM Department "
					+"ORDER BY Name");
			rs=st.executeQuery();
			List <Department> lista = new ArrayList<>();
			while (rs.next()) {
				Department depto = instantiateDepartment(rs);
				lista.add(depto);
			}
			if (lista.size()>0) {
				return lista;
			}
			else {
				return null;
			}
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
		}
	}
		
	private Department instantiateDepartment(ResultSet rs) throws SQLException{
		Department depto = new Department();
		depto.setId(rs.getInt("Id"));
		depto.setNome(rs.getString("Name"));
		return depto;
	}

}
