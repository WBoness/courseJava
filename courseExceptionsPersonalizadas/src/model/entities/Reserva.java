package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {
	private Integer numeroQuarto;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reserva() {
	}
	
	public Reserva(Integer numeroQuarto, Date checkIn, Date checkOut) {
		this.numeroQuarto = numeroQuarto;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	public Integer getNumeroQuarto() {
		return numeroQuarto;
	}
	public void setNumeroQuarto(Integer numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}
	public Date getCheckIn() {
		return checkIn;
	}
	public Date getChackOut() {
		return checkOut;
	}
	public void atualizarDatas(Date checkIn, Date chackOut) {
		this.checkIn = checkIn;
		this.checkOut = chackOut;
	}
	public Long duracao() {
		/*Calendar in = Calendar.getInstance();
		in.setTime(checkIn);
		Calendar out = Calendar.getInstance();
		out.setTime(checkOut);
		Integer duracao = in.compareTo(out);
		return duracao;*/
		long duracao= checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(duracao, TimeUnit.MILLISECONDS);
	}
	
	@Override
	public String toString () {
		return 	  "Reserva: Quarto "
				+ this.numeroQuarto
				+ ", check-in: "
				+ sdf.format(checkIn)
				+ ", check-out: "
				+ sdf.format(checkOut)
				+ ", "
				+ duracao()
				+ " noites";
	}
}
