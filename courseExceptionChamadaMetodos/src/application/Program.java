package application;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
 *   Pilha de chamadas de exceções
 */

public class Program {

	public static void main(String[] args) {
		
		metodo1();
		System.out.println("Programa encerrado!"); 
		
	}
	
	public static void metodo1() {
		System.out.println("início método 1");
		
		metodo2();
		
		System.out.println("Fim método 1");
	}
	public static void metodo2() {
		System.out.println("início do metodo 2");
		
		Scanner sc = new Scanner(System.in);
		try {	
			
			String[] vect =sc.nextLine().split(" ");
			int position = sc.nextInt();
			System.out.println(vect[position]); 
		} 
		catch (InputMismatchException e) {
			System.out.println("Valor inválido");
		}
		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Índice inválido");
			e.printStackTrace();
			sc.next();
		}
		sc.close();
		System.out.println("Fim metodo 2");
	}
}
