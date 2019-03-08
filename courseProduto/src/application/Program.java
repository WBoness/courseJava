package application;

import java.util.Scanner;

import entities.Produto;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner (System.in);
		System.out.println("entre com o nome e o preço do produto");
		Produto produto = new Produto(sc.nextLine(),sc.nextDouble());
		
		System.out.println(produto);
		
		
		
		sc.close();
		
	}

}
