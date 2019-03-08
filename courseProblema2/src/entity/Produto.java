package entity;

public class Produto {
	
	public String nome;
	public double preco;
	public int estoque;
	

	public void addQuantidade (int quantidade) {
		this.estoque += quantidade; 
		return;
	} 
	
	public void valorTotalEmEstoque () {
		System.out.printf("O VALOR total em estoque �: R$%.2f", (estoque*preco));
	}
	
	public void removeQuantidade (int quantidade) {
		if (quantidade > estoque)
			System.out.println("Estoque insuficiente!");			
		else 
			this.estoque = estoque -quantidade;		// estoque -= quantidade;
	}	
	
	// Implementa��o do m�todo toString - sobrecarga de m�todo da superclasse
	
	public String toString() {
		return this.nome 
				+ ", R$ "
				+ String.format("%.2f", this.preco)
				+", "
				+estoque 
				+" Und";
	}
}
