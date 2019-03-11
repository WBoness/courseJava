package entities;

public class ContaCorrente {
	private Integer numero;
	private String titular;
	private Double saldo;
	
	public ContaCorrente() {
	}
	public ContaCorrente(Integer numero, String titular, Double saldo) {
		this.numero = numero;
		this.titular = titular;
		this.saldo = saldo;
	}
	
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public String getTitular() {
		return titular;
	}
	public void setTitular(String titular) {
		this.titular = titular;
	}
	public Double getSaldo() {
		return saldo;
	}
	public void saque(double valor) {
		this.saldo -=valor;
	}
	public void deposito (Double valor) {
		this.saldo +=valor;
	}
	@Override
	public String toString() {
		return "ContaCorrente [numero=" + numero + ", titular=" + titular + ", saldo=" + saldo + "]";
	}
	
}
