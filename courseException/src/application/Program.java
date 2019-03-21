package application;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
 *   Tratamento de exce��es
 */

public class Program {

	public static void main(String[] args) {
		

		Scanner sc = new Scanner(System.in);
		
			try {	
				String[] vect =sc.nextLine().split(" ");// l� v�rios dados na mesma 
													// linha, separados por espa�o em branco
													// cada um dos espa�oe ser� um elemento do vetor
				int position = sc.nextInt();
				System.out.println(vect[position]); // mostra na tela o vetor na posi��o informada
			} 
			catch (InputMismatchException e) {
				System.out.println("Valor inv�lido");
			}
			catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("�ndice inv�lido");
			}
			
			System.out.println("Programa encerrado!"); // mostra que o programa n�o foi interrompido
			
		
		sc.close();

	}

}
