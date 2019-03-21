package application;

/*
 * Fazer um programa para ler os dados de uma reserva de hotel 
 * (n�mero do quarto, data de entrada e data de sa�da) 
 * e mostrar os dados da reserva, inclusive sua dura��o em dias. 
 * Em seguida, ler novas datas de entrada e sa�da, 
 * atualizar a reserva, e mostrar novamente a reserva com os dados atualizados. 
 * O programa n�o deve aceitar dados inv�lidos para a reserva, 
 * conforme as seguintes regras:
		- Altera��es de reserva s� podem ocorrer para datas futuras
		- A data de sa�da deve ser maior que a data de entrada
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;


import entities.Reserva;

/*
 *   Exce��es personalizadas
 */

public class Program {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Reserva reserva = new Reserva(1001, sdf.parse("21/03/2019"),sdf.parse("23/03/2019"));
		System.out.println(reserva);
		System.out.println("Entre com as novas datas de Entrada e Sa�da: ");
		System.out.print("Entrada: ");
		System.out.println("Sa�da: ");
	}
}
