package entities;

import util.Calculator;

public class Conta {

	private int numeroConta;
	private String nome;
	private double saldo;
	
	public Conta() {
		
	}
	public Conta(int numeroConta, String nome, double depositoInicial) {
		super();
		this.numeroConta = numeroConta;
		this.nome = nome;
		deposito(depositoInicial);
	}

	public Conta(int numeroConta, String nome) {
		super();
		this.numeroConta = numeroConta;
		this.nome = nome;
	}

	public int getNumeroConta() {
		return numeroConta;
	}

	public String getNome() {
		return nome;
	}

	public void setNome (String nome) {
		this.nome=nome;
	}
	public double getSaldo() {
		return saldo;
	}
	
	public void saque (double valor) {
		this.saldo -= (valor + Calculator.TAXA); 
	}
	
	public void deposito (double valor) {
		this.saldo += valor;
	}

	@Override
	public String toString() {
		return "Conta [numeroConta=" + numeroConta + ", nome=" + nome + ", saldo=" + saldo + "]";
	}
	
	
}
