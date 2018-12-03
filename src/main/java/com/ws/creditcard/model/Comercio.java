package com.ws.creditcard.model;

public class Comercio {
	
	private Long id;
	private String nombre;
	private String detalles;
	
	
	
	

	public Comercio() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Comercio(Long id, String nombre, String detalles) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.detalles = detalles;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDetalles() {
		return detalles;
	}
	public void setDetalles(String detalles) {
		this.detalles = detalles;
	}
	
	

}
