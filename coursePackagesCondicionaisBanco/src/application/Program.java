package application;
/*
 * Em um banco, para se cadastrar uma conta banc�ria, � necess�rio informar o n�mero da conta, o nome do
titular da conta, e o valor de dep�sito inicial que o titular depositou ao abrir a conta. Este valor de dep�sito
inicial, entretanto, � opcional, ou seja: se o titular n�o tiver dinheiro a depositar no momento de abrir sua
conta, o dep�sito inicial n�o ser� feito e o saldo inicial da conta ser�, naturalmente, zero.

Importante: uma vez que uma conta banc�ria foi aberta, o n�mero da conta nunca poder� ser alterado. J�
o nome do titular pode ser alterado (pois uma pessoa pode mudar de nome por ocasi�o de casamento, por
exemplo).
Por fim, o saldo da conta n�o pode ser alterado livremente. � preciso haver um mecanismo para proteger
isso. O saldo s� aumenta por meio de dep�sitos, e s� diminui por meio de saques. Para cada saque
realizado, o banco cobra uma taxa de $ 5.00. Nota: a conta pode ficar com saldo negativo se o saldo n�o for
suficiente para realizar o saque e/ou pagar a taxa.

Voc� deve fazer um programa que realize o cadastro de uma conta, dando op��o para que seja ou n�o
informado o valor de dep�sito inicial. Em seguida, realizar um dep�sito e depois um saque, sempre
mostrando os dados da conta ap�s cada opera��o.
 */
import java.util.Scanner;

import entities.Conta;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Conta conta = new Conta(); // necess�rio instanciar para usar no if (publica)
		double valor;
		char opcao;
		System.out.print("Entre com o n�mero da conta: ");
		int numero = sc.nextInt();
		
		System.out.print("Entre com o Nome do correntista: ");
		String nome = sc.next();
		
		System.out.println("Deseja fazer dep�sito? ");
		opcao = sc.next().charAt(0);
		if (opcao != 's') {
			
			conta = new Conta(numero, nome);
		}
			
		else {
			System.out.print("Entre com o valor a depositar: ");
			valor = sc.nextDouble();
			conta = new Conta(numero, nome, valor);	
		}
		System.out.println(conta);
		System.out.print("Valor a depositar: ");
		conta.deposito(valor = sc.nextDouble());
		
		System.out.println(conta);
		System.out.print("Valor a sacar: ");
		conta.saque(valor = sc.nextDouble());
		System.out.println(conta);
		
		sc.close();
	}
}
