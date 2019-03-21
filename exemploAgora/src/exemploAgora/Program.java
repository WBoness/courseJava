

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/*
 *   
 */

public class Program {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf1 = new SimpleDateFormat ("dd/MM/yyyy");
		SimpleDateFormat sdf2 = new SimpleDateFormat ("dd/MM/yyyy HH:mm:ss");
		
		Date data1 = new Date();
		System.out.println(data1); //Imprime a hora atual;
		System.out.println(sdf1.format(data1));
		System.out.println(sdf2.format(data1));
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Entre com uma data no formato dd/MM/yyyy");
		String stringData = sc.next();
		Date data2 = sdf1.parse(stringData);
		System.out.println(data2);
		System.out.println(sdf1.format(data2));
		sc.close();

	}

}