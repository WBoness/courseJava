package application;

import java.util.Scanner;

/*
 *   
 */

public class Program {

	public static void main(String[] args) {
		
		int n=5;	
		Scanner sc = new Scanner(System.in);
		char[] vogais = new char[n];
		System.out.println("digite as vogais: ");
		for (int i = 0; i < vogais.length; i++) {
			vogais[i]= sc.next().charAt(0);
		}
		
		for (int i = 0; i < vogais.length; i++) {
			System.out.print(vogais[i]+", ");
		}
		sc.close();
	}
	
}
