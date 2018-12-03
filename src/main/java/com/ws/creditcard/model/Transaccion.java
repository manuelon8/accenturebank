package com.ws.creditcard.model;

public class Transaccion {
	
	private long id;
	private String fechatran;
	private String numtarjeta;
	private double monto;
	
	
	public Transaccion() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Transaccion(long id, String fechatran, String numtarjeta, double monto) {
		super();
		this.id = id;
		this.fechatran = fechatran;
		this.numtarjeta = numtarjeta;
		this.monto = monto;
	}
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFechatran() {
		return fechatran;
	}
	public void setFechatran(String fechatran) {
		this.fechatran = fechatran;
	}
	public String getNumtarjeta() {
		return numtarjeta;
	}
	public void setNumtarjeta(String numtarjeta) {
		this.numtarjeta = numtarjeta;
	}
	public double getMonto() {
		return monto;
	}
	public void setMonto(double monto) {
		this.monto = monto;
	}

	@Override
	public String toString() {
		return "Transaccion [id=" + id + ", fechatran=" + fechatran + ", numtarjeta=" + numtarjeta + ", monto=" + monto
				+ "]";
	}
	
	
	

}
