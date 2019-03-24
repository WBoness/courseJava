package entities;

public class Estudante {
	private String nome;
	private String email;
	
	
	public String getNome() {
		return nome;
	}
	public Estudante(String nome, String email) {
		super();
		this.nome = nome;
		this.email = email;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Estudante [nome=" + nome + ", email=" + email + "]";
	}
	
	
}
