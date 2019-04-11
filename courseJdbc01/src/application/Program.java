package application;
/*
 * 1. CRIA ARQUIVO DE CONFIGURAÇÃO (db.properties) na raiz do projeto
 * 2. CRIA A CONEXÃO COM O BANCO DE DADOS
 * 3. CRIA A EXCEÇÃO PERSONALIZADA
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
