package application;
/*
 * 1. INSERIR DOIS DEPARTAMENTOS E RETORNAR OS ID
 */


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;

public class Program {

	public static void main(String[] args) {
		
		Connection conn = null;
		PreparedStatement st= null;//Deixa para armazenar o comando depois (ver)

		try {
			conn = DB.getConnection(); //conecta ao bamco de dados
			// Insere já os valores e retorna o id 
			st = conn.prepareStatement(
					"INSERT INTO Department " +
					"(Name) " +
					"VALUES ('Sports'), ('Party')",
					Statement.RETURN_GENERATED_KEYS);
						
			// Para executar o comando (e saber quantas linhas foram afetadas no banco)
			
			int rowsAffected = st.executeUpdate();
			
			// tratamento do valor a ser retornado: só mostra se for MAIOR que ZERO
			
			if (rowsAffected>0) {
				System.out.println("Feito! Linha(s) afetada(s): "+ rowsAffected);
				ResultSet rs = st.getGeneratedKeys(); //pode ser mais de um valor (várias inserções)
				while (rs.next()) {
					int id = rs.getInt(1); //obtém a primeira coluna: a do Id
					System.out.println("Id = "+id);
				}
			} else
				System.out.println("Nenhua linha afetada!");
			
			
		}
		catch (SQLException e) { // trata as exceções do SQL
			e.printStackTrace();
		}
		finally {
		DB.closeStatement(st);
		DB.closeConnection();		
		}

	}

}
