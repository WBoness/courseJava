package application;

import java.util.Scanner;

import util.CurrencyConverter;

/*
 *  Faça um programa para ler a cotação do dólar, e depois um valor em dólares
 *   a ser comprado por uma pessoa em reais. 
 *   Informar quantos reais a pessoa vai pagar pelos dólares, considerando ainda
 *   que a pessoa terá que pagar 6% de IOF sobre o valor em dólar.
 *   Criar uma classe CurrencyConverter para ser responsável pelos cálculos.
 */


public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Qual o valor do Dolar Hoje?");
		double dollar = sc.nextDouble();
		System.out.println("Quantos dólares deseja comprar? ");
		int dollarParaComprar = sc.nextInt();
		
		System.out.printf("Valor sem IOF em Reais R$ %.2f%n", 
				CurrencyConverter.reaisSemIOF(dollar, dollarParaComprar));
		System.out.println();
		System.out.printf("Valor em Reais R$ %.2f%n", 
				CurrencyConverter.reaisComIOF(CurrencyConverter.reaisSemIOF(dollar, dollarParaComprar)));
		
		sc.close();
		
	}
	
}
