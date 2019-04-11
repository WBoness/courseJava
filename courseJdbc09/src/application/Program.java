package application;
/*
 * 1. TRANSAÇÃO USANDO JDBC
 * 		- setAutoCommit(false)
 * 		- commit()
 * 		- rollback()
 * 
 * 		ESTE PROGRAMA CRIA UM ERRO PROPOSITA
 */

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;

public class Program {

	public static void main(String[] args) {
		Connection conn = null;
		Statement st= null;

		try {
			conn = DB.getConnection(); //conecta ao banco de dados
			st = conn.createStatement();
			
			int rows1 = st.executeUpdate("UPDATE seller SET BaseSalary = 2900 WHERE departmentId = 1");
			int i=1;
			if (i<2) {
				throw new SQLException("Erro proposital");	// cria um erro e atualizou apenas o Depto 1		
			}
					
			int rows2 = st.executeUpdate("UPDADE seller SET BaseSalary = 3000 WHERE departmentId = 2");
			System.out.println("Linhas afetadas no Departamento "+ rows1+": "+rows1);
			System.out.println("Linhas afetadas no Departamento "+ rows2+": "+rows2);
		}		
		catch (SQLException e) { // trata as exceções de fora personalizada
			e.printStackTrace();
		}
		finally {
		DB.closeStatement(st);
		DB.closeConnection();		
		}

	}

}
