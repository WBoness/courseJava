package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

import entities.enums.PedidoStatus;

public class Pedido {
	private Integer id;
	private Date momento;
	private PedidoStatus status;
	
	public Pedido() {
		
	}

	public Pedido(Integer id, Date momento, PedidoStatus status) {
		this.id = id;
		this.momento = momento;
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getMomento() {
		return momento;
	}

	public void setMomento(Date momento) {
		this.momento = momento;
	}

	public PedidoStatus getStatus() {
		return status;
	}

	public void setStatus(PedidoStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		return "Pedido [id=" + id + ", momento=" + sdf1.format(momento) + ", status=" + status + "]";
	}
	
	
}
