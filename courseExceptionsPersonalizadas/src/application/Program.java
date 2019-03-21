package application;

/*
 * Fazer um programa para ler os dados de uma reserva de hotel 
 * (número do quarto, data de entrada e data de saída) 
 * e mostrar os dados da reserva, inclusive sua duração em dias. 
 * Em seguida, ler novas datas de entrada e saída, 
 * atualizar a reserva, e mostrar novamente a reserva com os dados atualizados. 
 * O programa não deve aceitar dados inválidos para a reserva, 
 * conforme as seguintes regras:
		- Alterações de reserva só podem ocorrer para datas futuras
		- A data de saída deve ser maior que a data de entrada
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reserva;

/*
 *   Exceções personalizadas
 */

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("Entre com as datas de Entrada e Saída: ");
		System.out.print("Check-in (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Check-out (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next());
		if (!checkOut.after(checkIn)) {
			System.out.println("Data inválida! A data de check-out deve "
					+ "ser posterior à de check-in!");
		}
		else {
			System.out.println("Reserva realizada com sucesso!");
			Reserva reserva = new Reserva(1001,checkIn ,checkOut);
			System.out.println(reserva);
			System.out.println();
			System.out.println("Entre com as novas datas de Entrada e Saída: ");
			System.out.print("Check-in (dd/MM/yyyy): ");
			Date novoCheckIn = sdf.parse(sc.next());
			System.out.print("Check-out (dd/MM/yyyy): ");
			Date novoCheckOut = sdf.parse(sc.next());
			System.out.println(reserva.atualizarDatas(novoCheckIn, novoCheckOut));
			System.out.println(reserva);			
		}		
		sc.close();
	}
}
