package application;
/*
 *  Pro
 */

import java.util.Scanner;

import entity.Retangulo;

public class Program {

	public static void main(String[] args) {
		
		Retangulo retangulo = new Retangulo();
		Scanner sc = new Scanner(System.in);
		System.out.print("Input Height: ");
		retangulo.height = sc.nextDouble();
		System.out.print("Input Width: ");
		retangulo.width = sc.nextDouble();
		System.out.println();
		System.out.println();
		System.out.println(retangulo);
		System.out.printf("AREA= %.2f%n", retangulo.area());
		System.out.printf("PERIMETER= %.2f%n", retangulo.perimeter());
		System.out.printf("DIAGONAL= %.2f%n", retangulo.diagonal());
		
		sc.close();
	}
	
}
