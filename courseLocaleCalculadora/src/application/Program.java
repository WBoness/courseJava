package application;

import java.util.Locale;
import java.util.Scanner;

import util.Calculator;

/*
 *  Pro
 */


public class Program {
	
	
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc= new Scanner(System.in);
		
		System.out.print("Entre com o Raio: ");
		double raio= sc.nextDouble();
		
		Calculator calc = new Calculator(); // Inst�ncia de Calculator
		double circunferencia = calc.circunference(raio); // m�todo n�o est�tico
		System.out.printf("Circunfer�ncia: %.2f%n", circunferencia);
		System.out.printf("Circunfer�ncia: %.2f%n", calc.circunference(raio));
		
		double volumeEsfera = Calculator.volumeEsfera(raio); //M�todo est�tico
		System.out.printf("Volume: %.2f%n", volumeEsfera);
		
		System.out.printf("Volume: %.2f%n", Calculator.volumeEsfera(raio));

		System.out.printf("Valor de PI: %.2f%n", Calculator.PI);
		sc.close();
		
	}		
}
