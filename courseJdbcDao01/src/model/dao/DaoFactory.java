package model.dao;

import db.DB;
import model.dao.impl.SellerDaoJDBC;

/*
 * Classe Responsável por instanciar os DAO
 * 	- Terá operações estáticas para a instanciação
 * 		-createSellerDao -> retorna um SellerDao
 */

public class DaoFactory {

	public static SellerDao createSellerDao() {
		
		return new SellerDaoJDBC(DB.getConnection());// é obrigado passar uma conexão de argumento
	}
}
