package com.ws.creditcard.model;

 
import java.util.Comparator;

import javax.persistence.*;

import org.springframework.boot.autoconfigure.domain.EntityScan;
 

@Entity
@Table(name = "Creditcard")
public class Creditcard {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String marca;
	private String numero;
	private String fecha;
	private double saldo;
	private double limite;
	
	
	public Creditcard() {
		super();
	}


	public Creditcard(long id, String marca, String numero, String fecha,double saldo,double limite) {
		super();
		this.id = id;
		this.marca = marca;
		this.numero = numero;
		this.fecha = fecha;
		this.saldo= saldo;
		this.limite = limite;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}


	public String getFecha() {
		return fecha;
	}


	public void setFecha(String fecha) {
		this.fecha = fecha;
	}


	public double getSaldo() {
		return saldo;
	}


	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}


	public double getLimite() {
		return limite;
	}


	public void setLimite(double limite) {
		this.limite = limite;
	}


	@Override
	public String toString() {
		return "Creditcard [id=" + id + ", marca=" + marca + ", numero=" + numero + ", fecha=" + fecha + "]";
	}
	

	public int comparer(Creditcard creditcard) {
	return 	Comparator.comparing(Creditcard::getNumero).thenComparing(Creditcard::getId).thenComparing(Creditcard::getMarca).compare(this, creditcard);
		 
	}
	
	
	

}
