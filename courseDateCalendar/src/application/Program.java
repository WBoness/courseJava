package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/*
 *  Manipulando Datas com Calendar
 */

public class Program {

	public static void main(String[] args) throws ParseException {

		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyy HH:mm:ss");
		Date agora = new Date();//obt�m instante atual
		Date daquiAPouco, diasApos = agora;
		
		System.out.println(agora);// formato java
		System.out.println(sdf1.format(agora));//formato desejado
		
		//Acrescentando 4 horas...				
		Calendar cal = Calendar.getInstance(); // instancia a vari�vel cal Tipo Calendar
		cal.setTime(agora);
		cal.add(Calendar.HOUR_OF_DAY, 4);// acrescenta horas
		daquiAPouco = cal.getTime();
		
		//Acrescentando 7 dias...
		cal.add(Calendar.DAY_OF_YEAR, 7);// acrescenta dias
		diasApos=cal.getTime();
		
		System.out.println("Agora: "+ agora);
		System.out.println("Em 4 horas: "+ sdf1.format(daquiAPouco));
		System.out.println("Em 7 dias..."+ sdf1.format(diasApos));
		}
}
