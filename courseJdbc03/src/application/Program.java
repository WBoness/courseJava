package application;
/*
 * 1. Conectar ao banco
 * 2. INSERIR UM VENDEDOR
 */


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
			st = conn.prepareStatement(
					"INSERT INTO seller " +
					"(Name, Email, BirthDate, BaseSalary, DepartmentId) " +
					"VALUES "+
					"(?, ?, ?, ?, ?)");
			// TROCAR A ? PELO VALOR CORRETO
			st.setString(1, "Wellington Boness");
			st.setString(2, "wboness@bol.com.br");
			//próximo é uma data: tem que instanciar um SimpleDateFormat antes
			st.setDate(3, new java.sql.Date(sdf.parse("27/10/1970").getTime()));
			st.setDouble(4, 3000.00);
			st.setInt(5, 4);
			
			// Para executar o comando (e saber quantas linhas foram afetadas no banco)
			
			int rowsAffected = st.executeUpdate();
			
			System.out.println("Feito! Linha(s) afetada(s): "+ rowsAffected);
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
