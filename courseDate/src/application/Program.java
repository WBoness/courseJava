package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.TimeZone;

/*
 *  Date
 */

public class Program {

	public static void main(String[] args) throws ParseException {

		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		SimpleDateFormat sdf3 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		sdf3.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		Date y1 = sdf1.parse("07/03/2019");
		Date y2 = sdf2.parse("07/03/2019 13:08:33");
		Date x1 = new Date(); // Instante atual
		Date x2 = new Date(System.currentTimeMillis());
		Date x3 = new Date(0L);
		Date y3 = Date.from(Instant.parse("2019-03-07T13:08:33Z"));// formato ISO 8601
				
		System.out.println(y1);
		System.out.println(y2);
		System.out.println(sdf1.format(y1));
		System.out.println(sdf2.format(y2));
		System.out.println();
		System.out.println(x1); //imprime hora atual
		System.out.println(sdf1.format(x1));// imprime hora atual no formato dd/MM/yyyy
		System.out.println(sdf2.format(x1));//formato dd/MM/yyyy HH:mm:ss
		System.out.println();
		System.out.println(x2); //imprime hora atual através do System.currentTimeMillis()
		System.out.println(sdf1.format(x2));// imprime hora atual no formato dd/MM/yyyy
		System.out.println(sdf2.format(x2));//formato dd/MM/yyyy HH:mm:ss
		System.out.println();
		System.out.println(x3); //Passado 0L
		System.out.println(sdf1.format(x3));
		System.out.println(sdf2.format(x3));
		System.out.println();
		System.out.println(y3);
		System.out.println(sdf1.format(y3));
		System.out.println(sdf2.format(y3));
		System.out.println();
		System.out.println(sdf3.format(y3));
		System.out.println();
		System.out.println("Agora aqui: "+ sdf2.format(x1));
		System.out.println("Agora em Londres: "+ sdf3.format(x1));
		
		
		}
}
