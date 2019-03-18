package application;

import java.util.Scanner;

import entities.Quarto;

public class Program {

	public static void main(String[] args) {
		
		Quarto quartinho = new Quarto();
		System.out.println(quartinho);
		
		System.out.println();
		Quarto[] quarto = new Quarto[10];
		Scanner sc=new Scanner(System.in);
		//Iniciar os dez quartos vazios
		for (int i=0; i<10; i++) {
			quarto[i]=new Quarto();//instanciar os quartos na Heap
			System.out.println("Q ["+(i+1)+"] = " + quarto[i]);
		}
		System.out.println("Quantos estudantes? ");
		int n= sc.nextInt();
		
		for (int i = 0; i < n; i++) {
			quarto[i].alugarQuarto();
		}
		sc.close();
		
	}
	public static void listarQuartos (Quarto[] quarto) {
		for (int i = 0; i < quarto.length; i++) {
			System.out.println(quarto[i]);
		}
	}

}
