package course;

import java.util.Locale;

public class Program {

	public static void main(String[] args) {
		
		char genero = 'F';
		int idade = 32;
		double saldo = 10.35784;
		String name = "Maria"; 
		
		System.out.print("Good morning!"); // imprime e NÃO MUDA de linha
		System.out.println("Good afternoon!"); // Imprime e MUDA de linha
		System.out.println("Good night!");// muda de linha
		System.out.println("---------------------------");
		System.out.println(saldo);
		System.out.printf("%.2f%n", saldo); // duas casas decimais (arredondamento)
		System.out.printf("%.4f%n", saldo); // quebra de linha. Pode ser \n
		Locale.setDefault(Locale.US); // localização Estados Unidos
		System.out.printf("%.4f%n", saldo); // muda o separador para ponto
		System.out.println("---------------------------");
		System.out.printf("%s tem %d anos, sexo %c, e tem saldo = %.2f bitcoins%n", name, idade,
		genero, saldo);

	}

}
