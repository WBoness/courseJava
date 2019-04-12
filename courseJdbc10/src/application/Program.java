package application;
/*
 * 1. TRANSAÇÃO USANDO JDBC
 * 		- setAutoCommit(false)
 * 		- commit()
 * 		- rollback()
 * 
 * **************  O ERRO PROPOSITAL CONTINUA   ************************
 * 
 * 		IMPLEMENTANDO A TRANSAÇÃO (no try)
 * 		caso aconteça algum erro, deve ser dado um rollback (no catch)
 * 			o rollback também pode gerar exceção
 * 
 * ************ TEM QUE EFETUAR O ROLLBACK ***********************
 * 
 */

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;
import db.DbException;

public class Program {

	public static void main(String[] args) {
		Connection conn = null;
		
		Statement st= null;

		try {
			conn = DB.getConnection(); 
			conn.setAutoCommit(false);//commit depende de confirmação explícita
			st = conn.createStatement();
			
			int rows1 = st.executeUpdate("UPDATE seller SET BaseSalary = 2900 WHERE departmentId = 1");
							
			int rows2 = st.executeUpdate("UPDATE seller SET BaseSalary = 3900 WHERE departmentId = 2");
			
			conn.commit(); //confirma as alterações, caso tenham dado TUDO certo!
			System.out.println("Linhas afetadas no Departamento "+ rows1+": "+rows1);
			System.out.println("Linhas afetadas no Departamento "+ rows2+": "+rows2);
		}		
		catch (SQLException e) { // trata as exceções de forma personalizada
			try {
				conn.rollback();
				throw new DbException("Rollback realizado! Causado por:" + e.getMessage());
			} catch (SQLException e1) {
				//erro no rollback
				throw new DbException("Erro no rollback! Causado por" + e.getMessage());
			}
		}
		finally {
		DB.closeStatement(st);
		DB.closeConnection();		
		}

	}

}
