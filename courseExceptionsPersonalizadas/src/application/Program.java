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


import entities.Reserva;

/*
 *   Exceções personalizadas
 */

public class Program {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Reserva reserva = new Reserva(1001, sdf.parse("21/03/2019"),sdf.parse("23/03/2019"));
		System.out.println(reserva);
		System.out.println("Entre com as novas datas de Entrada e Saída: ");
		System.out.print("Entrada: ");
		System.out.println("Saída: ");
	}
}
