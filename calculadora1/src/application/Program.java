package application;

import java.util.Locale;
import java.util.Scanner;

/*
 *  Programa para demonstrar uso de funções, operacoes matemáticas e saída de dados
 */


public class Program {
	
	public static final double PI =3.14159; // declaração de um membro estático (CONSTANTE)

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc= new Scanner(System.in);
		
		System.out.print("Entre com o Raio: ");
		double raio= sc.nextDouble();
		
		
		double circunferencia = circunference(raio); //função calcula circunferencia
		System.out.printf("Circunferência: %.2f%n", circunferencia);
		
		double volumeEsfera = volumeEsfera (raio);// Uma função que calcula volume
		System.out.printf("Volume: %.2f%n", volumeEsfera);

		System.out.printf("Valor de PI: %.2f%n", PI);
		sc.close();
		
	}
	
	public static double circunference(double raio) {
		return 2.0 * PI * raio;
	}
	
	public static double volumeEsfera (double raio) {
		return (4.0 * PI * raio*raio*raio)/3.0;
	}
	
}
