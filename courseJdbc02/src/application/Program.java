package application;
/*
 * 1. conectar ao banco
 * 2. fazer consulta SQL para buscar todos os departamentos na base de dados
 * 3. Armazenar no ResultSet o resultado
 * 
 */


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;

public class Program {

	public static void main(String[] args) {

		Connection conn = null;
		Statement st = null;// permite entrar comandos SQL
		ResultSet rs = null;// Armazena o resultado SQL em formato tabela
		try {
			conn = DB.getConnection(); //conecta ao bamco de dados
			st = conn.createStatement(); //instanciou o statement
			rs = st.executeQuery("SELECT * FROM DEPARTMENT"); // executa a consulta
															 // e armazena no ResultSet
			// Resultset na posição 0 da tabela: verificar a posição 1 e posterior(percorrer)
			while (rs.next()) {
				System.out.println(rs.getInt("Id")+ ", "+ rs.getString("Name"));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
		DB.closeStatement(st);
		DB.closeResultSet(rs);
		DB.closeConnection();		
		}

	}

}
