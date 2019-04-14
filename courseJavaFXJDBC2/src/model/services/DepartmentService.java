package model.services;

import java.util.ArrayList;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;



public class DepartmentService {

	private DepartmentDao dao = DaoFactory.createDepartmentDao();
	public List<Department> findAll(){
		/*
		//Mock dos dados - simula consulta à base de dados
		List<Department> lista = new ArrayList<>();
		lista.add(new Department(1, "Computadores"));
		lista.add(new Department(2, "Livros"));
		lista.add(new Department(3, "Eletronicos"));
		lista.add(new Department(4, "Nautica"));
		return lista;
		*/
	return dao.findAll();
	}
	
	
	public void saveOrUpdate(Department obj) {
	
		// Tem que verificar se vai inserir ou atualizar no banco
		// testa se o id do obl é nulo (inserir)
		
		if (obj.getId() == null) {
			dao.insert(obj);
		}
		else {
			dao.update(obj);
		}
	}
}
