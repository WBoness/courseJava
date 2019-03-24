package Application;

import java.util.Scanner;

import entities.Estudante;
import entities.Quarto;

/*
 * Listas
 */
public class Program {
 
	
	public static void main(String[] args) {
		int tamanhoVetor = 2;
		Estudante[] estudante= new Estudante[tamanhoVetor];
		Quarto[] quarto = new Quarto[tamanhoVetor];
		boolean alugado = false;
		int numeroQuarto=quarto.length+1;
		for (int i = 0; i < quarto.length; i++) {
			quarto[i]= new Quarto();
			estudante[i] = new Estudante(null,null);
		}
		Scanner sc=new Scanner(System.in);
		System.out.println("Quantos quartos para alugar? "); int n = sc.nextInt();
		
		for (int i=0; i<n; i++) {
			numeroQuarto=buscaQuarto(quarto);
			if (numeroQuarto==(quarto.length+1)) {
				System.out.println("Não há vagas!");
			}else {
				sc.nextLine();
				System.out.print("Entre com o nome do Estudante: ");
				String nome=sc.nextLine();
				System.out.print("Entre com o e-mail do Estudante: ");
				String email=sc.next();
				estudante[i].setNome(nome);
				estudante[i].setEmail(email);
				quarto[numeroQuarto].alugarQuarto(estudante[i]);
			}
		}
		imprimir(quarto);
		sc.close();
	}
	public static void imprimir(Quarto[] quarto) {
		for (int i=0;i<quarto.length;i++) {
			System.out.printf("quarto[%d]%s%n",i+1,quarto[i]);
		}
		System.out.println();
	}
	public static int buscaQuarto(Quarto[] quarto) {
		for (int i=0;i<quarto.length;i++) {
			if (quarto[i].isAlugado()== false) {
				return i;
			}
		
		}
		return quarto.length+1;
	}
}
