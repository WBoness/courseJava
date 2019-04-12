package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
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
				
		/*		
		// Teste da implementação do INSERT
		System.out.println("\n===== SELLER INSERT ====-");
		
		Seller vendorNovo = new Seller(null, "Sarah Boness", "sboness@gmail.com", new Date(), 3000.0, dep);
		sellerDao.insert(vendorNovo);
		System.out.println("Novo vendedor possui Id= "+ vendorNovo.getId());
		System.out.println(sellerDao.findById(vendorNovo.getId()));
		*/
		
		// Teste da implementação do UPDATE
		System.out.println("\n===== SELLER UPDATE ====-");
		vendor = sellerDao.findById(10);// localiza
		vendor.setName("Sarah Aires");
		vendor.setEmail("saires@gmail.com");//altera o objeto
		sellerDao.update(vendor);//grava no disco
		System.out.println(vendor);
		/*
		vendor = sellerDao.findById(11);// localiza no disco
		vendor.setName("Sarah A Boness");
		vendor.setEmail("sab@gmail.com");//altera o objeto DAO
		vendor.setBaseSalary(5000.0);
		sellerDao.update(vendor);//grava no disco
		System.out.println(vendor);
		
		
		// Teste da implementação do DELETE
		System.out.println("\n===== SELLER DELETE ====-");
		//vendor=sellerDao.findById(11);
		sellerDao.deleteById(vendor.getId());
		System.out.println("Feito! Deletado o Vendedor de Id "+ vendor.getId());
		*/
		
		System.out.println("\n\n=============== IMPLEMENTAÇÃO DepartmentDaoJDBC ===============");
		//Teste da implementação do DELETE
		System.out.println("\n===== DEPARTMENT FindById ====-");
		
		DepartmentDao deptoDao = DaoFactory.createDepartmentDao();
		depto = deptoDao.findById(1);
		System.out.println(depto);
		
		System.out.println("\n===== DEPARTMENT FindAll ====-");
		
		List <Department> listaDepto = deptoDao.findAll();
		for (Department dp :listaDepto) {
			System.out.println(dp);
		}
		/*
		System.out.println("\n===== DEPARTMENT INSERT ====-");
		Department deptoNovo = new Department(null,"Food");
		deptoDao.insert(deptoNovo);
		listaDepto=deptoDao.findAll();
		for (Department dp :listaDepto) {
			System.out.println(dp);
		}
		*/

		System.out.println("\n===== DEPARTMENT UPDATE ====-");
		dep = deptoDao.findById(7);
		dep.setNome("Nautica");
		deptoDao.update(dep);
		listaDepto = deptoDao.findAll();
		for (Department dp :listaDepto) {
			System.out.println(dp);
		}
	}

}
