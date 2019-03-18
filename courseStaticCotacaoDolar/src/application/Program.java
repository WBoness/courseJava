package application;

import java.util.Scanner;

import util.CurrencyConverter;

/*
 *  Fa�a um programa para ler a cota��o do d�lar, e depois um valor em d�lares
 *   a ser comprado por uma pessoa em reais. 
 *   Informar quantos reais a pessoa vai pagar pelos d�lares, considerando ainda
 *   que a pessoa ter� que pagar 6% de IOF sobre o valor em d�lar.
 *   Criar uma classe CurrencyConverter para ser respons�vel pelos c�lculos.
 */


public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Qual o valor do Dolar Hoje?");
		double dollar = sc.nextDouble();
		System.out.println("Quantos d�lares deseja comprar? ");
		int dollarParaComprar = sc.nextInt();
		
		System.out.printf("Valor sem IOF em Reais R$ %.2f%n", 
				CurrencyConverter.reaisSemIOF(dollar, dollarParaComprar));
		System.out.println();
		System.out.printf("Valor em Reais R$ %.2f%n", 
				CurrencyConverter.reaisComIOF(CurrencyConverter.reaisSemIOF(dollar, dollarParaComprar)));
		
		sc.close();
		
	}
	
}
