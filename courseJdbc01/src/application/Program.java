package application;
/*
 * 1. CRIA ARQUIVO DE CONFIGURA��O (db.properties) na raiz do projeto
 * 2. CRIA A CONEX�O COM O BANCO DE DADOS
 * 3. CRIA A EXCE��O PERSONALIZADA
 * 
 */
import java.sql.Connection;

import db.DB;

public class Program {

	public static void main(String[] args) {

			Connection conn = DB.getConnection();
			DB.closeConnection();
			System.out.println("deu tudo certo!");
	
		

	}

}
