package model.dao;

import db.DB;
import model.dao.impl.SellerDaoJDBC;

/*
 * Classe Respons�vel por instanciar os DAO
 * 	- Ter� opera��es est�ticas para a instancia��o
 * 		-createSellerDao -> retorna um SellerDao
 */

public class DaoFactory {

	public static SellerDao createSellerDao() {
		
		return new SellerDaoJDBC(DB.getConnection());// � obrigado passar uma conex�o de argumento
	}
}
