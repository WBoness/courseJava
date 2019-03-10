package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Departamento;
import entities.HorasContrato;
import entities.Trabalhador;
import entities.enums.TrabalhadorNivel;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc=new Scanner(System.in);
		System.out.print("Entre com o departamento: ");
		String deptoNome = sc.next();
		Departamento depto = new Departamento(deptoNome);
		sc.nextLine();
		System.out.print("Digite o Nome: ");
		String nome = sc.nextLine();
		
		System.out.print("Níbel: (JUNIOR, NIVEL_MEDIO, SENIOR) ");
		TrabalhadorNivel nivel = TrabalhadorNivel.valueOf(sc.next());  //converte String->enum
		System.out.print("Salário-Base: ");
		Double salarioBase = sc.nextDouble();
		Trabalhador fulano = new Trabalhador(nome, salarioBase, nivel, depto);
		System.out.println(fulano);
		System.out.print("Quantos contratos para este Trabalhador: ");
		int n= sc.nextInt();
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
		for (int i = 0; i < n; i++) {
			System.out.println("Entre com a data: (dd/MM/yyyy) ");
			Date data = sdf1.parse(sc.next());
			System.out.print("Valor po hora: ");
			Double valorPorHora = sc.nextDouble();
			System.out.print("Horas trabalhadas: ");
			Integer horas = sc.nextInt();
			HorasContrato horasContrato = new HorasContrato(data, valorPorHora, horas);
			fulano.adicionaContrato(horasContrato);
		}
		
		
		sc.close();

	}

}
