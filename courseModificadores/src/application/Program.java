package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Product;

public class Program {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in); //
		System.out.println("Enter product data: ");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Price: ");
		double price = sc.nextDouble();

		Product product = new Product(name, price); //novo construtor
		
		System.out.println("Product data: " + product);
		System.out.println();
		
		System.out.printf("produto: %s%n", product.getName());
		System.out.printf("produto: %.2f%n", product.getPrice());
		product.setName("IFONE");
		product.setPrive(4000);
		System.out.println();
		
		System.out.printf("Novo Produto: %s%n", product.getName());
		System.out.printf("produto: %.2f%n", product.getPrice());
		product.addProducts(100);
		System.out.printf("Quantidade: %d%n", product.getQuantity());
		
		
		
		
		/*System.out.print("Enter the number of products to be added in stock: ");
		int quantity = sc.nextInt(); //declarar a variável 
		product.addProducts(quantity);
		System.out.println();
		System.out.println("Updated data: " + product);
		System.out.println();
		System.out.print("Enter the number of products to be removed from stock: ");
		quantity = sc.nextInt();
		product.removeProducts(quantity);
		System.out.println();
		System.out.println("Updated data: " + product);*/
 
		sc.close();
	}
}