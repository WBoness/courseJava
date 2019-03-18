package entity;

public class Aluno {

	public String nome;
	public double nota1;
	public double nota2;
	public double nota3;
	
	public double media () {
		/*double medTrim1 = (this.nota1/30*100); // VALE 30%
		double medTrim2 = (this.nota1/35*100); //VALE 35%
		double medTrim3 = (this.nota1/35*100); //VALE 35%
		double media = (medTrim1 + medTrim2 + medTrim3)/3;
		return media;*/
		return ((this.nota1/30*100)+
				(this.nota2/35*100)+
				(this.nota3/35*100))/3;
	}
	public void verificaAprovacao(double media) {
		if (media>=60)
			System.out.println("APROVADO");
		else {
			System.out.println("REPROVADO");
			System.out.printf("POR %.2f pontos", (60.0-media));
		}
	}
	
	public String toString() {
		
		return
				nome +
				String.format("%n%.2f%n", this.nota1)+
				String.format("%.2f%n", this.nota2)+
				String.format("%.2f%n", this.nota3) +
				String.format("Media Final: %.2f%n", media());
				
	}
	
}
