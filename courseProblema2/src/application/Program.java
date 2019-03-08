package application;
/*
 *  Pro
 */

import java.util.Scanner;

import entity.Produto;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		Produto produto = new Produto();
		// Lê dados do produto
		System.out.print("Produto Nome: ");
		produto.nome = sc.next();
		System.out.print("Produto Preço: R$");
		produto.preco = sc.nextDouble();
		System.out.print("Produto Quantidade: ");
		produto.estoque = sc.nextInt();
					
		System.out.println("Dados do produto: " + produto); // mostra produto
		System.out.println();
		System.out.println("Entre com o número de produtos a serem inseridos no estoque:");
		int quantidade= sc.nextInt();
		produto.addQuantidade(quantidade); // adiciona ao estoque
		System.out.println();
		System.out.println("Dados do produto: " + produto); //mostra dados novamente
		System.out.println();
		System.out.println("Entre com o número de produtos a serem removidos no estoque:");
		quantidade= sc.nextInt();
		produto.removeQuantidade(quantidade);
		System.out.println();
		System.out.println("Dados do produto: " + produto); //mostra dados novamente
		System.out.println();
		produto.valorTotalEmEstoque();
		
		sc.close();
		
		
		
		
		
		/*
		mostraProduto(produto);
		menu();
		int opcao = sc.nextInt();
		while (opcao != 0) {
			if (opcao==1){
				System.out.println("Digite a quantidade de ENTRADA: ");
				produto.addQuantidade(sc.nextInt());				
				mostraProduto(produto);
				
			}else if (opcao==2){
				System.out.print("Digite a quantidade de SAÍDA: ");
				produto.removeQuantidade(sc.nextInt());
				mostraProduto(produto);				
				}else if (opcao==3){
					
					mostraProduto(produto);
					produto.valorTotalEmEstoque();
					}else {
						}
			menu();
			opcao = sc.nextInt();
			}*/
		//sc.close();
		System.out.println();
		System.out.println();
		//System.out.println("Volte sempre!");

	}
	public static void menu() {
		//int opcao;
		//Scanner sc1= new Scanner(System.in);
		System.out.println();
		System.out.println();
		System.out.println("--------------------------");
		System.out.println("Entre com a sua opção:");
		System.out.println("1 - Incluir no estoque");
		System.out.println("2 - Excluir do estoque");
		System.out.println("3 - Mostrar dados");
		System.out.println("0 - sair");
		System.out.println("-------------------------");
		System.out.println();
		//opcao = sc1.nextInt();
		//sc1.close();
		//return opcao;
	}
	
	public static void mostraProduto (Produto produto) {
		Produto p = produto;
		System.out.println();
		System.out.printf("Nome do Produto: %s%n", p.nome);
		System.out.printf("Preco do Produto: R$%.2f%n", p.preco);
		System.out.printf("Quantidade em estoque: %d%n", p.estoque);
	}
}
