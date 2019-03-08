package application;

import java.util.Locale;
import java.util.Scanner;

/*
 *  Programa para demonstrar uso de fun��es, operacoes matem�ticas e sa�da de dados
 */


public class Program {
	
	public static final double PI =3.14159; // declara��o de um membro est�tico (CONSTANTE)

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc= new Scanner(System.in);
		
		System.out.print("Entre com o Raio: ");
		double raio= sc.nextDouble();
		
		
		double circunferencia = circunference(raio); //fun��o calcula circunferencia
		System.out.printf("Circunfer�ncia: %.2f%n", circunferencia);
		
		double volumeEsfera = volumeEsfera (raio);// Uma fun��o que calcula volume
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
