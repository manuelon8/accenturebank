package com.ws.creditcard.controller;

import java.time.LocalDate;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ws.creditcard.exception.CardNoFoundException;
import com.ws.creditcard.model.Cliente;
import com.ws.creditcard.model.Creditcard;
import com.ws.creditcard.model.TasaJson;
import com.ws.creditcard.model.Transaccion;
import com.ws.creditcard.persistence.repository.CreditCardController;
import com.ws.creditcard.persistence.repository.CreditCardRepository;
 

import com.ws.creditcard.service.PrintTest;



import com.ws.creditcard.service.*;
@RestController
@RequestMapping("/creditcard")
public class AppControllerCard implements CreditCardController  {
	

	 
	 @Autowired
	 private CardServices servicios;
	 
	 LocalDate fechaActual = LocalDate.now();
	 
	@RequestMapping(value="", method = RequestMethod.POST) 
	@Override
	public void saveCard(@RequestBody Creditcard creditcard) {

		servicios.saveCard(creditcard);
		  		
	}
	
	 
	@RequestMapping(value="", method = RequestMethod.GET)
	@Override
	public List<Creditcard> listAllCard() {
		
		return   servicios.listAllCard();
		
	}
	
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	@Override
	public Creditcard getCard(@PathVariable Long id) {
		 
		 return servicios.getCard(id);
		 
	}	
	

	@RequestMapping(value="/actualizarSaldo/{id}", method = RequestMethod.PUT)
	@Override
	public Cliente updatemonto(@PathVariable String monto, @PathVariable Long id) {

		return servicios.updatemonto(monto, id);
		
	}
	
	@RequestMapping(value="/tasa/{numero}/{monto}", method = RequestMethod.GET)	 
	public   TasaJson getTasa(@PathVariable String numero, @PathVariable String monto) {
		 
		 return servicios.getTasa(numero, monto);
		 
	}
 
	
}
