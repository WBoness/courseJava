package entity;

import util.Calculator;

public class ContaBancaria {

	
	private String nomeTitular;
	private String numeroConta;
	private double saldo;
	
	public ContaBancaria() {
		
	}
	
	public ContaBancaria(String nomeTitular, String numeroConta) {
		this.nomeTitular = nomeTitular;
		this.numeroConta = numeroConta;
	}
	
	public ContaBancaria(String nomeTitular, String numeroConta, double saldo) {
		this.nomeTitular = nomeTitular;
		this.numeroConta = numeroConta;
		this.saldo = saldo;
	}

	public String getNomeTitular() {
		return nomeTitular;
	}

	public void setNomeTitular(String nomeTitular) {
		this.nomeTitular = nomeTitular;
	}

	public String getNumeroConta() {
		return numeroConta;
	}

	
	public double getSaldo() {
		return saldo;
	}

	public void deposito (double valor) {
		this.saldo += valor;
	}
	
	public void saque (double valor) {
		this.saldo =-(valor + Calculator.TAXA);
	}
	
	
	public String toString(){
		return this.nomeTitular = ", " +this.numeroConta ;
		
	}
}

