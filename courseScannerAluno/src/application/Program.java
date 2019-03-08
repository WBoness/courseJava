package application;

import java.util.Scanner;

import entity.Aluno;

/*
 *  Fazer um programa para ler o nome de um aluno 
 *  e as tr�s notas que ele obteve nos tr�s trimestres do ano (primeiro 
 *  trimestre vale 30 e o segundo e terceiro valem 35 cada). 
 *  Ao final, mostrar qual a nota final do aluno no ano. 
 *  Dizer tamb�m se o aluno est� aprovado (PASS) ou n�o (FAILED) e, 
 *  em caso negativo, quantos pontos faltam para o aluno obter o 
 *  m�nimo para ser aprovado (que � 60% da nota). 
 *  Voc� deve criar uma classe Student para resolver este problema.
 */


public class Program {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		Aluno aluno = new Aluno();
		System.out.println("Entre com o nome do aluno e as tres notas");
		aluno.nome = sc.nextLine();
		aluno.nota1 = sc.nextDouble();
		aluno.nota2 = sc.nextDouble();
		aluno.nota3 = sc.nextDouble();
		System.out.println();
		System.out.println(aluno);
		aluno.verificaAprovacao(aluno.media());
		sc.close();
		
	}
	
}
