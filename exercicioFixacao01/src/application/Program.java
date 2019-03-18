package application;

import java.util.Scanner;

import entity.ContaBancaria;

/*
 * Em um banco, para se cadastrar uma conta banc�ria, 
 * � necess�rio informar o n�mero da conta, o nome do
 * titular da conta, e o valor de dep�sito inicial que 
 * o titular depositou ao abrir a conta. Este valor de 
 * dep�sito inicial, entretanto, � opcional, ou seja: 
 * se o titular n�o tiver dinheiro a depositar no momento 
 * de abrir sua conta, o dep�sito inicial n�o ser� feito 
 * e o saldo inicial da conta ser�, naturalmente, zero.
 * Importante: uma vez que uma conta banc�ria foi aberta, 
 * o n�mero da conta nunca poder� ser alterado. J� o nome 
 * do titular pode ser alterado (pois uma pessoa pode mudar 
 * de nome por ocasi�o de casamento, por exemplo).
 * Por fim, o saldo da conta n�o pode ser alterado livremente. 
 * � preciso haver um mecanismo para proteger isso. O saldo s� 
 * aumenta por meio de dep�sitos, e s� diminui por meio de saques. 
 * Para cada saque realizado, o banco cobra uma taxa de $ 5.00. 
 * Nota: a conta pode ficar com saldo negativo se o saldo n�o for
 * suficiente para realizar o saque e/ou pagar a taxa.
 * Voc� deve fazer um programa que realize o cadastro de uma conta, 
 * dando op��o para que seja ou n�o informado o valor de dep�sito inicial. 
 * Em seguida, realizar um dep�sito e depois um saque, sempre mostrando os 
 * dados da conta ap�s cada opera��o
 */


public class Program {

	public static void main(String[] args) {
		
		
		Scanner sc1 = new Scanner(System.in);
		System.out.println("Far� dep�sito na abertura? (s -sim )");
		char op = sc1.next().charAt(0);
		sc1.close();
		Scanner sc = new Scanner(System.in);
		char opcao = op;
		if (opcao == 'S') {
			System.out.println("Digite o Nome: ");
			String nome = sc.nextLine();
			
			System.out.println("Digite o n�mero da conta");
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
