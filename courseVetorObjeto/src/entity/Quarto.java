package entity;

import java.util.Scanner;

public class Quarto {
	private boolean ocupado=false;
	private Aluno aluno;

	public Quarto() {
		this.ocupado=false;
		this.aluno = new Aluno(null, null);
	}
	public Quarto(boolean ocupado, Aluno aluno) {
		this.ocupado = ocupado;
		this.aluno = aluno;
	}

	public boolean isOcupado() {
		return ocupado;
	}
	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}
	public Aluno getAluno() {
		return aluno;
	}
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	public Quarto alugarQuarto () {
		Quarto quarto = new Quarto();
		if (quarto.verificaOcupacao()==false) {
			quarto.setOcupado(true);
			System.out.print("nome do Aluno:");
			Scanner sc = new Scanner(System.in);
			String nome =sc.next();
			System.out.print("Digite o email: ");
			String email = sc.next();
			Aluno aluno = new Aluno(nome, email);
			quarto.setAluno(aluno);
			sc.close();
			
		}else
			System.out.println("Quarto OCUPADO!");
		return quarto;
	}
	
	public void descocuparQuarto () {
		this.ocupado=false;
	}
	
	public boolean verificaOcupacao() {
		return ocupado;
	}
	@Override
	public String toString() {
		return "Quarto [ocupado=" + ocupado + ", aluno=" + aluno + "]";
	}
	
	
}
