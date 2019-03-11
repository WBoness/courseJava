package application;

import java.util.Scanner;

import entities.ContaCorrente;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Conta nº: ");
		int num = sc.nextInt();
		sc.nextLine();
		System.out.print("Titular: ");
		String titular = sc.nextLine();
		System.out.print("Deposito Inicial: ");
		Double saldo = sc.nextDouble();
		ContaCorrente cc = new ContaCorrente(num, titular, saldo);
		System.out.println(cc);
		System.out.print("Valor a depositar: ");
		Double deposito = sc.nextDouble();
		cc.deposito(deposito);
		System.out.println(cc);
		System.out.print("Valor a sacar: ");
		Double saque = sc.nextDouble();
		cc.saque(saque);
		System.out.println(cc);
		sc.close();
	}

}
