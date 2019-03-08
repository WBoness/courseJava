package application;

import java.util.Scanner;

import entity.Aluno;
import entity.Quarto;

/*
 *   
 */

public class Program {

	public static void main(String[] args) {
		
		Quarto quartoTemp = new Quarto();
		Scanner sc = new Scanner(System.in);
		Quarto[] quarto = new Quarto[10];
		for (int i=0;i<quarto.length; i++) {
			quarto[i]= new Quarto();
			System.out.println(quarto[i]);
		}
		System.out.println();
		quarto[1]= quartoTemp.alugarQuarto();
		listarQuartos(quarto);
		quarto[1].alugarQuarto(quartoTemp);
		sc.close();
	}
	
	/*public static void alugarQuarto(Quarto quarto) {
		
		if (quarto.verificaOcupacao()==false) {
			quarto.setOcupado(true);
			System.out.print("nome do Aluno:");
			Scanner sc = new Scanner(System.in);
			String nome =sc.next();
			System.out.print("Digite o email: ");
			String email = sc.next();
			Aluno aluno = new Aluno(nome, email);
			quarto.setAluno(aluno);
			sc.close();
		}else
			System.out.println("Quarto OCUPADO!");
	}*/
	
	public static void listarQuartos(Quarto[] quarto) {
		for (int i=0;i<quarto.length; i++) {
			System.out.println("QUARTO "+ i +": " + quarto[i]);
		}
	}
}
