package application;

/*
 *  Laço for each
 */

public class Program {

	public static void main(String[] args) {

		String[] vect = new String[] {"João", "Maria", "alex"};
		
		System.out.println("Utilizando o método convencional");		
		for (int i = 0; i < vect.length; i++) {
			System.out.print(vect[i]+"| ");
		}
		System.out.println();
		System.out.println("Utilizando o laço 'for each'");
		for(String nomes:vect) {
			System.out.print(nomes +"| ");
		}
	}

}
