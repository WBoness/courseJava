package application;

import java.util.Date;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {


		Department depto = new Department(1,"Books");// testando classe Departamento
		System.out.println(depto);
		
		Seller vendor = new Seller(1, "Wellington Boness", "wboness@bol.com.br", new Date(), 3000.0, depto);
		System.out.println(vendor);

		//Instanciar um SellerDao (interface) sem expor a implementa��o (SellerDaoJDBC) atrav�s da f�brica
		SellerDao sellerDao = DaoFactory.createSellerDao();
	}

}
