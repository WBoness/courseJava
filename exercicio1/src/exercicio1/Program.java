package exercicio1;


public class Program {

	public static void main(String[] args) {
		
		// Opreadores de atribuição
		
		double n1 = 10;
		double n2 = 30;
		String s = "ABC";
		System.out.printf("O valor de n1 é: %.2f%n", n1);
		System.out.printf("O valor de n2 é: %.2f%n", n2);
		System.out.printf("O valor de s é: %s%n", s);
		System.out.println("-------------");
		n1 *= 2; // valor existente * 2 = 20
		n2 += n1; //valor existente (30) + n1 (20) = 50
		s += "DEF"; // operador '+' é de concatenação
		System.out.printf("O valor de n1 é: %.2f%n", n1);
		System.out.printf("O valor de n2 é: %.2f%n", n2);
		System.out.printf("O valor de s é: %s%n", s);
			
	
	}

}
