package application;

/*
 *  La�o for each
 */

public class Program {

	public static void main(String[] args) {

		String[] vect = new String[] {"Jo�o", "Maria", "alex"};
		
		System.out.println("Utilizando o m�todo convencional");		
		for (int i = 0; i < vect.length; i++) {
			System.out.print(vect[i]+"| ");
		}
		System.out.println();
		System.out.println("Utilizando o la�o 'for each'");
		for(String nomes:vect) {
			System.out.print(nomes +"| ");
		}
	}

}
