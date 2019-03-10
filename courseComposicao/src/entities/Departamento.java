package entities;

public class Departamento {
	String nome;

	public Departamento() {

	}

	public Departamento(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Departamento [nome=" + nome + "]";
	}
	
}
