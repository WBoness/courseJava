package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Funcionario;

/*
 *   
 */

public class Program {

	public static void main(String[] args) {
		String id="";
		String nome="";
		Double salario=0.0;
		List <Funcionario> funcionarios = new ArrayList<>();
		//Funcionario funcionario = new Funcionario();
		Scanner sc = new Scanner(System.in);
		System.out.print("Digite o número de Funcionários: ");
		int n  = sc.nextInt();
		for (int i=0;i<n;i++) {
			sc.nextLine();
			System.out.print("Entre com o ID do funcionário "+ (i+1));
			id = sc.next();
			sc.nextLine();
			System.out.print("Entre com o NOME do funcionário "+ (i+1));
			nome = sc.nextLine();
			System.out.print("Entre com o SALÁRIO do funcionário "+ (i+1));
			salario = sc.nextDouble();
			Funcionario funcionario = new Funcionario(id, nome, salario);
			funcionarios.add(funcionario);
		}
		imprimirLista(funcionarios);
		System.out.print("Digite o ID do funcionario cujo salário será aumentado");
		id = sc.next();
		//Funcionario func = funcionarios.stream().filter(x -> x.getId(id) ==id ).findFirst().orElse(null);
		// não opera com string
		sc.nextLine();
		
		System.out.print("Entre com o percentual de aumento");
		Double Taxa = sc.nextDouble();
		
		sc.close();
	}
	
	public static void imprimirLista (List<Funcionario> funcionarios) {
		for(Funcionario lista:funcionarios) {
			System.out.println(lista);
		}
	}

}
