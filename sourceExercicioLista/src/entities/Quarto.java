package entities;

public class Quarto {
	private boolean alugado;
	private Estudante estudante;
	
	public Quarto() {
		this.alugado = false;
		this.estudante = new Estudante (null,null);
	}

	public Estudante getEstudante() {
		return estudante;
	}

	public void setEstudante(Estudante estudante) {
		this.estudante = estudante;
	}

	public boolean isAlugado() {
		return alugado;
	}
	
	public void desAlugar () {
		this.alugado = false;
		this.estudante.setNome(null);
		this.estudante.setEmail(null);
	}
	
	public void alugarQuarto(Estudante estudante) {
		this.alugado = true;
		this.estudante = estudante;
	}

	@Override
	public String toString() {
		return "Quarto [alugado=" + alugado + ", estudante=" + estudante + "]";
	}
	
	
}

