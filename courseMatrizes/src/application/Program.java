package application;
import java.util.Scanner;

/*
 *   Fazer um programa para ler um número inteiro N 
 *   e uma matriz de ordem N contendo números inteiros. 
 *   Em seguida, mostrar a diagonal principal e a quantidade 
 *   de valores negativos da matriz.
 */

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
			System.out.print("Digite a ordem da Matriz ");
			int n = sc.nextInt();
			int [][] matriz = new int[n][n];//cria  e inicia uma matriz (com zero) 
			
			lerMatriz(sc, matriz);
			imprimirMatriz(matriz);
			diagonalMatriz(matriz);
			diagonal2(matriz);
			negativosMatriz(matriz);
			 
		sc.close();
	}
		
	public static void lerMatriz(Scanner sc, int[][] matriz){
			for (int i = 0; i < matriz.length; i++) {
				for (int j = 0; j < matriz[i].length; j++) {
					System.out.printf("entre com o elemento[%d][%d] da matriz", i,j);
					matriz [i][j] = sc.nextInt();
				}
			}
		}
			
	public static void imprimirMatriz (int[][] matriz) {
		for (int i = 0; i < matriz.length; i++) {
			System.out.print("|");
			for (int j= 0;  j< matriz[i].length; j++) {
				System.out.printf("%d ",matriz[i][j]);
			}System.out.print("|");
			System.out.println();
		}
	}
	
	public static void diagonalMatriz (int[][] matriz) {
		System.out.print("Diagonal: |");
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				if (i==j) {
					System.out.print(matriz[i][j]+" ");
				}
			}
		}System.out.print("|");
		 System.out.println();
	}
	
	public static void diagonal2 (int[][] matriz) {
		System.out.print("Diagonal 2: |");
		for (int i = 0; i < matriz.length; i++) {
			System.out.print(matriz[i][i]+ " ");
			
		}
		System.out.print("|");
		System.out.println();
	}
public static void negativosMatriz(int[][] matriz) {
		System.out.print("Negativos: |");
		for (int i = 0; i < matriz.length; i++) {			
			for (int j= 0;  j< matriz.length; j++) {
				if (matriz[i][j]<0) {
					System.out.printf("%d ",matriz[i][j]);
				}
			}
		}System.out.print("|");
		System.out.println();
	}
}
