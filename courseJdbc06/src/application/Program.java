package application;
/*
 * 1. ATUALIZAR SAL�RIO DE UM VENDEDOR
 */


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DB;

public class Program {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement st= null;

		try {
			conn = DB.getConnection(); //conecta ao banco de dados
			// 
			st = conn.prepareStatement(
					"UPDATE Seller " +
					"SET BaseSalary = BaseSalary + ? " +
					"WHERE "+
					"(DepartmentId = ?)");
			
			st.setDouble(1, 200.0); // acrescer 200.0 no sal�rio anterior
			st.setInt(2, 2);// no Departamento de Id=2
						
			// Para executar o comando (e saber quantas linhas foram afetadas no banco)
			
			int rowsAffected = st.executeUpdate();
			
			// tratamento do valor a ser retornado: s� mostra se for MAIOR que ZERO
			
			System.out.println("Feito! Linha(s) afetada(s): "+ rowsAffected);
		}		
		catch (SQLException e) { // trata as exce��es do SQL
			e.printStackTrace();
		}
		finally {
		DB.closeStatement(st);
		DB.closeConnection();		
		}

	}

}
