package model.services;

import java.util.ArrayList;
import java.util.List;

import model.entities.Departamento;

public class DepartamentoService {

	public List<Departamento> findAll(){
		//Mock dos dados - simula consulta à base de dados
		List<Departamento> lista = new ArrayList<>();
		lista.add(new Departamento(1, "Computadores"));
		lista.add(new Departamento(2, "Livros"));
		lista.add(new Departamento(3, "Eletronicos"));
		lista.add(new Departamento(4, "Nautica"));
	return lista;
	}
	
	
}
