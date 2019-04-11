package application;
/*
 * 1. DELETAR DADOS
 * 		- Criar uma exceção personalizada DbIntegrityException
 * 		  porque é muito comum acontecer o problema de integridade
 *  	  referencial (há relacionamento dependente desse dado)
 */


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DB;
import db.DbIntegrityException;

public class Program {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement st= null;

		try {
			conn = DB.getConnection(); //conecta ao banco de dados
			// 
			st = conn.prepareStatement(
					"DELETE FROM Department " +
					"WHERE "+
					"(Id = ?)");
			st.setInt(1, 1);// no Departamento de Id =6 (Party)
			
			int rowsAffected = st.executeUpdate();
						
			System.out.println("Feito! Linha(s) afetada(s): "+ rowsAffected);
		}		
		catch (SQLException e) {
			throw new DbIntegrityException(e.getMessage());// usa tratamento personalizado
		}
		finally {
		DB.closeStatement(st);
		DB.closeConnection();		
		}

	}

}
