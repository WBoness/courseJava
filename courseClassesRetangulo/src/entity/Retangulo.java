package entity;

public class Retangulo {

	public double width;
	public double height;
	
	public double area() {
		
		return this.height*this.width;
	}
	
	public double perimeter () {
		return 2.0*(this.height+this.width);
	}
	
	public double diagonal() {
		return Math.sqrt((this.width*this.width)+(this.height*this.height));
	}
	
	public String toString() {
		return "height: " + String.format("%.2f%n", this.height)
			 + "width: " + String.format("%.2f%n", this.width);
	}
}

