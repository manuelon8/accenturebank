package com.ws.creditcard.model;

public class TasaJson {
	
	private String marca;
	private double tasa;
	
	
	public TasaJson() {
		super();
		// TODO Auto-generated constructor stub
	}


	public TasaJson(String marca, double tasa) {
		super();
		this.marca = marca;
		this.tasa = tasa;
	}


	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	public double getTasa() {
		return tasa;
	}


	public void setTasa(double tasa) {
		this.tasa = tasa;
	}
	
	

}
