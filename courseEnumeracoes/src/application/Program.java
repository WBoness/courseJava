package application;

import java.util.Date;
import java.util.Scanner;

import entities.Pedido;
import entities.enums.PedidoStatus;

/*
 *   Enumerações
 */

public class Program {

	public static void main(String[] args) {
		Pedido pedido = new Pedido(1080,new Date(), PedidoStatus.AGUARDANDO_PGTO);
		System.out.println(pedido);
		
		PedidoStatus ped1 = PedidoStatus.ENTREGUE;
		
		System.out.print("Entre com o valor de ped2: ");
		Scanner sc = new Scanner(System.in);
		
		PedidoStatus ped2 = PedidoStatus.valueOf(sc.next());
		
		System.out.println("ped1= "+ped1);
		System.out.println("ped2= "+ped2);
		if (ped1==ped2) {
			System.out.println("IGUAIS!");
		}else
			System.out.println("DIFERENTES!");
		sc.close();
	}

}
