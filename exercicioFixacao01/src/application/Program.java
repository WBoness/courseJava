package application;

import java.util.Scanner;

import entity.ContaBancaria;

/*
 * Em um banco, para se cadastrar uma conta bancária, 
 * é necessário informar o número da conta, o nome do
 * titular da conta, e o valor de depósito inicial que 
 * o titular depositou ao abrir a conta. Este valor de 
 * depósito inicial, entretanto, é opcional, ou seja: 
 * se o titular não tiver dinheiro a depositar no momento 
 * de abrir sua conta, o depósito inicial não será feito 
 * e o saldo inicial da conta será, naturalmente, zero.
 * Importante: uma vez que uma conta bancária foi aberta, 
 * o número da conta nunca poderá ser alterado. Já o nome 
 * do titular pode ser alterado (pois uma pessoa pode mudar 
 * de nome por ocasião de casamento, por exemplo).
 * Por fim, o saldo da conta não pode ser alterado livremente. 
 * É preciso haver um mecanismo para proteger isso. O saldo só 
 * aumenta por meio de depósitos, e só diminui por meio de saques. 
 * Para cada saque realizado, o banco cobra uma taxa de $ 5.00. 
 * Nota: a conta pode ficar com saldo negativo se o saldo não for
 * suficiente para realizar o saque e/ou pagar a taxa.
 * Você deve fazer um programa que realize o cadastro de uma conta, 
 * dando opção para que seja ou não informado o valor de depósito inicial. 
 * Em seguida, realizar um depósito e depois um saque, sempre mostrando os 
 * dados da conta após cada operação
 */


public class Program {

	public static void main(String[] args) {
		
		
		Scanner sc1 = new Scanner(System.in);
		System.out.println("Fará depósito na abertura? (s -sim )");
		char op = sc1.next().charAt(0);
		sc1.close();
		Scanner sc = new Scanner(System.in);
		char opcao = op;
		if (opcao == 'S') {
			System.out.println("Digite o Nome: ");
			String nome = sc.nextLine();
			
			System.out.println("Digite o número da conta");
			String contaNumero = "1234584";
			System.out.println("Qual o valor a ser depositado? ");
			double valor = 2000.00;
			ContaBancaria conta = new ContaBancaria(nome,contaNumero, valor);
			System.out.println(conta.getNomeTitular());
			System.out.println(conta.getNumeroConta());
			System.out.println(conta.getSaldo());
			
		}else { 
			String nome = "joao de deus";
			String contaNumero = "1234584";
			ContaBancaria conta = new ContaBancaria(nome, contaNumero );
			System.out.println(conta.getNomeTitular());
			System.out.println(conta.getNumeroConta());
			System.out.println(conta.getSaldo());
		}
		
		
		
		sc.close();
	}
	
}
