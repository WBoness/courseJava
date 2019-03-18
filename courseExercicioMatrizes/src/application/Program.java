package application;

import java.util.Scanner;

/*
 *   Fazer um programa para ler dois números inteiros M e N, 
 *   e depois ler uma matriz de M linhas por N colunas contendo 
 *   números inteiros, podendo haver repetições. Em seguida, ler 
 *   um número inteiro X que pertence à matriz. Para cada ocorrência 
 *   de X, mostrar os valores à esquerda, acima, à direita e abaixo de X,
 *   quando houver, conforme exemplo.
 */

public class Program {

	public static void main(String[] args) {
		

		Scanner sc = new Scanner(System.in);
		System.out.println("Entre com as dimensoes da matriz:");
		System.out.print("n: ");
		int n = sc.nextInt();
		System.out.print("m: ");
		int m = sc.nextInt();
		int [][] matriz = new int[n][m];
		lerMatriz(sc, matriz);
		imprimirMatriz(matriz);
		System.out.print("Entre com um número da matriz: ");
		int num = sc.nextInt();
		verificaPosicao(num, matriz);
		sc.close();
	}

	public static void lerMatriz(Scanner sc, int[][] matriz) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				System.out.print("Entre com o elemento ["+i+"]["+j+"] da matriz: ");
				matriz[i][j] = sc.nextInt();
			}
		}
	}
	
	public static void imprimirMatriz (int[][] matriz) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				System.out.print(matriz[i][j]);
			}System.out.println();
		}
	}
	
	public static void verificaPosicao(int elemento, int[][] matriz) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				if (matriz[i][j]==elemento) {
					System.out.println("Achado "+elemento+ " na posicao ["+i+"]["+j+"]");
					if (i>0) {
						System.out.println("Acima= "+ matriz[i-1][j]);
					}
					if (j>0) {
						System.out.println("Esquerda= "+ matriz[i][j-1]);
					}
					if (i < (matriz.length-1)) {
						System.out.println("Abaixo= "+matriz[i+1][j]);
					}
					if (j < (matriz[i].length-1)) {
						System.out.println("Direita= "+matriz[i][j+1]);
					}
				}
			}
		}
	}
}
