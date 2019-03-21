package application;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
 *   Tratamento de exceções
 */

public class Program {

	public static void main(String[] args) {
		

		Scanner sc = new Scanner(System.in);
		
			try {	
				String[] vect =sc.nextLine().split(" ");// lê vários dados na mesma 
													// linha, separados por espaço em branco
													// cada um dos espaçoe será um elemento do vetor
				int position = sc.nextInt();
				System.out.println(vect[position]); // mostra na tela o vetor na posição informada
			} 
			catch (InputMismatchException e) {
				System.out.println("Valor inválido");
			}
			catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("Índice inválido");
			}
			
			System.out.println("Programa encerrado!"); // mostra que o programa não foi interrompido
			
		
		sc.close();

	}

}
