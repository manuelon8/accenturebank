package com.ws.creditcard.service;

import java.net.Socket;
import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;

import com.ws.creditcard.model.Creditcard;
import com.ws.creditcard.model.Transaccion;
import com.ws.creditcard.persistence.repository.CreditCardRepository;

public class CobrarImpl implements Icobrar{
	private static final Logger log = LoggerFactory.getLogger(CardServices.class);
	
	@Autowired
	private CreditCardRepository creditCardRepository;
	 @Autowired
	 private CardServices servicios;
	LocalDate fechaActual = LocalDate.now(); 

	@Override
	public Creditcard enviarInfoTC(Long id) {
		String dirWeb = "host";
		int puerto = 80;
		try {
			
			Socket s = new Socket(dirWeb, puerto);
			if(s.isConnected()){
			return	servicios.getCard(id);
			
			}
			
		} catch (Exception e) {
			
			log.error("Conexión no establecida con la dirección:"+  dirWeb + " a travéz del puerto: " + puerto, e);
		}

	return	null;		 

	}

	@Override
	public String informarPago() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean actualizarSaldo(String monto, Long id) {
		servicios.updatemonto(monto, id);
		return false;
	}
	
	public void ImprimirFactura(Long id, double monto) {
		
		Creditcard card = new Creditcard();
		PrintTest print = new PrintTest();
		Transaccion tran = new Transaccion();
		try {

			card = creditCardRepository.findById(id).orElse(null);

			if ((card != null)) {

				tran.setNumtarjeta(card.getNumero());
				tran.setMonto(monto);
				tran.setFechatran(fechaActual.toString());
				 print.imprimirfactura(tran);
				//response = "Transaccion Exitosa " + tran.getId();
				System.out.println("Transaccion Exitosa.. " + tran.getId());
			}

		} catch (Exception e) {
			System.out.println("Error: En impresion de factura.. " + tran.getId());
			e.printStackTrace();
		}
		 
	}	

}
