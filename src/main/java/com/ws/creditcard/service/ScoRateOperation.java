package com.ws.creditcard.service;

import java.time.LocalDate;

import com.ws.creditcard.model.TasaJson;

public class ScoRateOperation  implements IrateOperation{

	@Override
	public TasaJson InterestRate(String monto) {
		
		TasaJson myjson = new TasaJson();
		 LocalDate fechaActual = LocalDate.now();
	        double rate = 0;
	        try {
	        	
	            int dia = fechaActual.getDayOfMonth();
	            rate = new Double(monto) * dia * 0.5;
	            
	            myjson.setMarca("SCO");	            
	            myjson.setTasa(rate);
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return myjson;
	}

}
