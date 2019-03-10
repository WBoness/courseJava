package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.TrabalhadorNivel;

public class Trabalhador {
	private String nome;
	private Double salarioBase;
	private TrabalhadorNivel nivel;
	private List <HorasContrato> contrato = new ArrayList<>();// deve ser instanciada na declaração
	private Departamento departamento;
		
	public Trabalhador() {
		
	}
	public Trabalhador(String nome, Double salarioBase, TrabalhadorNivel nivel, Departamento depto) {
		this.nome = nome;
		this.salarioBase = salarioBase;
		this.nivel = nivel;
		this.departamento = depto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(Double salarioBase) {
		this.salarioBase = salarioBase;
	}

	public TrabalhadorNivel getNivel() {
		return nivel;
	}

	public void setNivel(TrabalhadorNivel nivel) {
		this.nivel = nivel;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public List<HorasContrato> getContrato() {
		return contrato;
	}
	
	public void adicionaContrato (HorasContrato contrato) {
		this.contrato.add(contrato);
	}
	public void removeContrato(HorasContrato contrato) {
		//int indice = this.contrato.indexOf(contrato);
		//this.contrato.remove(indice);
		this.contrato.remove(contrato);
	}
	public Double renda (Integer ano, Integer mes) {
		Double renda = this.salarioBase;
		Calendar cal = Calendar.getInstance();// cria uma instancia de calendar
		for (HorasContrato horasContrato : contrato) {
			cal.setTime(horasContrato.getData());// atribuiu a data do registro ao calendario
			int horasContrato_ano = cal.get(Calendar.YEAR);
			int horasContrato_mes = 1+ cal.get(Calendar.MONTH);
			if (ano == horasContrato_ano && mes == horasContrato_mes) {
				renda += horasContrato.valorTotal();
			}
		}
		return renda;
	}

	@Override
	public String toString() {
		return "Trabalhador [nome=" + nome + ", salarioBase=" + salarioBase + ", nivel=" + nivel + ", contrato="
				+ contrato + ", departamento=" + departamento + "]";
	}
	public void imprimeLista (List<HorasContrato> contrato) {
		for (HorasContrato lista: contrato) {
			System.out.println(lista);
			

		}
	}
	
}
