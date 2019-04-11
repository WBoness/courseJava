package application;
/*
 * 1. INSERIR UM VENDEDOR E RETORNAR O ID
 * 2. TRATAR A EXIBIÇÃO DA RESPOSTA
 */


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import db.DB;

public class Program {

	public static void main(String[] args) {
		SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
		Connection conn = null;
		PreparedStatement st= null;//Deixa para armazenar o comando depois (ver)

		try {
			conn = DB.getConnection(); //conecta ao bamco de dados
			// Insere e retorna o id 
			st = conn.prepareStatement(
					"INSERT INTO seller " +
					"(Name, Email, BirthDate, BaseSalary, DepartmentId) " +
					"VALUES "+
					"(?, ?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			
			// TROCAR A ? PELO VALOR CORRETO
			st.setString(1, "Johann Boness");
			st.setString(2, "jaboness@bol.com.br");
			//próximo é uma data: tem que instanciar um SimpleDateFormat antes
			st.setDate(3, new java.sql.Date(sdf.parse("17/03/1992").getTime()));
			st.setDouble(4, 5000.00);
			st.setInt(5, 1);
			
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
		catch(ParseException e) {// trata a exceção da tada inválida
			e.printStackTrace();
		}
		finally {
		DB.closeStatement(st);
		DB.closeConnection();		
		}

	}

}
