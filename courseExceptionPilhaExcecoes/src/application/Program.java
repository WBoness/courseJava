package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;


import entities.Reserva;

/*
 *   Exceções personalizadas
 */

public class Program {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Reserva reserva = new Reserva(1001, sdf.parse("21/03/2019"),sdf.parse("23/03/2019"));
		System.out.println(reserva);
	}
}
