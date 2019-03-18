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
		Date agora = new Date();//obtém instante atual
				
		Calendar cal = Calendar.getInstance(); // Instanciando Calendar
		cal.setTime(agora);
		int minutos = cal.get(Calendar.MINUTE);
		int horas = cal.get(Calendar.HOUR);
		int horaDoDia = cal.get(Calendar.HOUR_OF_DAY);
		int mes = 1+ cal.get(Calendar.MONTH);
		System.out.println("Agora: "+ sdf1.format(agora));
		System.out.println("Horas: "+horas+" Minutos: "+minutos);
		System.out.println("Hora do dia: "+horaDoDia);
		System.out.println("Mês: "+mes);
	}
}
