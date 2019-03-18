package entities;

public class Product {
	private String name;
	double price;  //nenhum modificador
	protected int quantity; 
	
	//construtores	
	public Product () {  // construtor padrão
		
	}	
	public Product (String name, double price) {
		this.name = name;
		this.price = price;
		this.quantity =0; //quantidade iniciada com valor ZERO;
	}
	public Product(String name, double price, int quantity) {  
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	// Getters e Setters
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return this.price;
	}
	public void setPrive(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return this.quantity;
	}
		
	// Métodos da Negócio
	public double totalValueInStock() {
		return price * quantity;
	}
	public void addProducts(int quantity) {
		this.quantity += quantity;
	}
	public void removeProducts(int quantity) {
		this.quantity -= quantity;
	}
	public String toString() {
		return name + ", $ " + String.format("%.2f", price) + ", " + quantity + " units, Total: $ "
				+ String.format("%.2f", totalValueInStock());
	}
}