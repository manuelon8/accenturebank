package com.ws.creditcard.service;

import com.ws.creditcard.model.Creditcard;
import com.ws.creditcard.model.Transaccion;

public interface Icobrar {
	
		   
		
		  Creditcard enviarInfoTC(Long id);
	      String informarPago();
	      boolean actualizarSaldo(String monto, Long id);

}
