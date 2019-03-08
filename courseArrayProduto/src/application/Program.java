package application;

import java.util.Scanner;

import entity.Produto;

/*
 *  ARRAYS
 *  Fazer um programa para ler um número inteiro N e os dados (nome e preço)
 *   de N Produtos. Armazene os N produtos em um vetor. Em seguida, mostrar 
 *   o preço médio dos produtos.
 */

public class Program {

	public static void main(String[] args) {
		int n;
		String nome;
		double preco;
		double precoTotal = 0;
		Scanner sc = new Scanner(System.in); 
		System.out.print("Quantos Produtos? ");	
		n = sc.nextInt();
		Produto [] produto = new Produto[n]; //vetor de objetos
		
		for (int i=0;i<n; i++) {
			System.out.printf("Entre com o Nome do produto %d",i+1);
			nome = sc.next();
			System.out.printf("Entre com o Preço do produto %d",i+1);
			preco = sc.nextDouble();
			produto[i] = new Produto(nome, precoTotal);// cria uma instãncia na referência 0
			produto[i].setNome(nome);
			produto[i].setPreco(preco);
			precoTotal += produto[i].getPreco();
			System.out.println(precoTotal);
		}
		for (int i=0;i<n;i++) {
			System.out.println(produto[i]);
		}
		System.out.printf("Preco Médio= %.2f", precoTotal/n);
		sc.close();
	}
	
}
