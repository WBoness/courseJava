package util;

public class Calculator {

	public static final double PI=3.14159;
	
	public double circunference(double raio) {
		return 2.0 * PI * raio;
	}
	
	public static double volumeEsfera (double raio) {
		return (4.0 * PI * raio*raio*raio)/3.0;
	}
}
