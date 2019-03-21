package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 *   Bloco finally
 */

public class Program {

	public static void main(String[] args) {

		File file = new File("C:\\Desenvolvimento\\Java\\Workspace\\courseJava\\courseExceptionFinnaly\\arquivos\\in.txt");
		Scanner sc = null;
		try {
			sc = new Scanner(file);
			while (sc.hasNextLine()) {
				System.out.println(sc.nextLine());
			}
		} 
		catch (FileNotFoundException e) {
			System.out.println("Erro abrindo arquivo: " + e.getMessage());
		} 
		finally {
			if (sc != null) {
				sc.close();
			}
			System.out.println("bloco finaly executado!");
		}
	}
}
