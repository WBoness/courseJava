package application;

import java.util.Scanner;

import entity.Employee;

/*
 *  Programa para demonstar entrada de dados com nomes compostos
 */


public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Employee funcionario = new Employee();
		System.out.println("Entre com o nome, salário e Imposto do Funcionário");
		funcionario.name = sc.nextLine(); // permite nomes compostos
		funcionario.grossSalary = sc.nextDouble();
		funcionario.tax = sc.nextDouble();
		System.out.println();
		System.out.println(funcionario);
		System.out.println();
		System.out.println("Entre com a porcentagem de aumento: ");
		funcionario.increaseSalary(sc.nextDouble());
		System.out.println();
		System.out.println(funcionario);
		
				
		sc.close();
	}
	
}
