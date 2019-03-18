package util;



public class CurrencyConverter {
	
	public static final double IOF = 0.06; //constante com o percentual IOF

	public static double reaisSemIOF (double valorDollar, int quantidade) {
		return (valorDollar * (double) quantidade); //calcula o valor sem IOF
	}
	
	public static double reaisComIOF (double valorDollar) {
		return (valorDollar= valorDollar + (valorDollar*IOF));
	} // calcula o valor com IOF
}
