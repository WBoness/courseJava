package application;

import java.util.Date;
import java.util.List;

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

		//Instanciar um SellerDao (interface) sem expor a implementação (SellerDaoJDBC) através da fábrica
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		// teste da implementação do FindById(Integer id)
		// Aproveita a instanciação do SellerDao
		System.out.println("\n===== SELLER FindById ====-");
		Seller vendor2 = sellerDao.findById(3);
		System.out.println(vendor2);
		

		// Teste da implementação do FindByDepartment
		System.out.println("\n===== SELLER FindByDepartment ====-");
		Department dep = new Department(1, null);
		
		List<Seller> lista = sellerDao.findByDepartment(dep);		//imprimir lista forEach
		for (Seller obj: lista) {
			System.out.println(obj);
		}
		
		// Teste da implementação do FindALL
				System.out.println("\n===== SELLER FindAll ====-");
				List<Seller> lista2 = sellerDao.findAll();		//imprimir lista forEach
				for (Seller obj: lista2) {
					System.out.println(obj);
				}
				
				
		// Teste da implementação do FindALL
		System.out.println("\n===== SELLER INSERT ====-");
		
		Seller vendorNovo = new Seller(null, "Sarah Boness", "sboness@gmail.com", new Date(), 3000.0, dep);
		sellerDao.insert(vendorNovo);
		System.out.println("Novo vendedor possui Id= "+ vendorNovo.getId());
		
	}

}
