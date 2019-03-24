package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Funcionario;


/*
 * Listas
 */
public class Program {

	public static void main(String[] args) {
		
		List<Funcionario> funcionarios = new ArrayList<>();
		
		System.out.print("Quantos Fubncionarios");
		Scanner sc=new Scanner(System.in);
			int n = sc.nextInt();
			for (int i = 0; i < n; i++) {
				sc.nextLine();
				System.out.print("Digite o Id");
				String id = sc.next();
				if (buscarId(id, funcionarios)==false) {
					sc.nextLine();
					System.out.print("Entre com o nome: ");
					String nome=sc.nextLine();
					System.out.print("Digite o salário: ");
					Double salario= sc.nextDouble();
					Funcionario funcionario = new Funcionario(id, nome, salario);
					funcionarios.add(funcionario);
				}
			}
			imprimir(funcionarios);
		sc.close();
	}
	public static void imprimir(List <Funcionario> lista) {
		for (Funcionario list: lista) {
			System.out.println(list +"| ");
		}
		System.out.println();
	}
	public static boolean buscarId (String id, List<Funcionario> funcionarios) {
		if(funcionarios.indexOf(id)!= -1) {
			return true;
		} else
			return false;
	}
}
