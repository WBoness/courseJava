package entities;

import java.util.Scanner;

public class Quarto {
	private boolean ocupado = false;
	private Aluno aluno;
	
	public Quarto() {
		this.ocupado=false;
		this.aluno = new Aluno(null, null);
	}
	
	public Quarto(boolean estaOcupado, Aluno aluno) {
		this.ocupado = estaOcupado;
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
	public void alugarQuarto() {
		if (isOcupado()==false) {
			Scanner sc1=new Scanner(System.in);
			//sc1.nextLine();
			System.out.print("Digite o Nome do Aluno: ");
			String name = sc1.nextLine();
			System.out.print("Digite o e-mail do Aluno: ");
			String email = sc1.nextLine();
			Aluno aluno = new Aluno(name, email);	//cria o aluno na memoria
			setAluno(aluno);// armzena o objeto aluno no objeto quarto (atributo)
			setOcupado(true);
			sc1.close();
		}else
			System.out.println("Quarto OCUPADO!");
		
	}
	
	@Override
	public String toString() {
		return "Quarto [ocupado=" + ocupado + ", aluno=" + aluno + "]";
	}	
}
