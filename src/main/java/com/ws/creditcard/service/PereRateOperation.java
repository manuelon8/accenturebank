package com.ws.creditcard.service;

import java.time.LocalDate;

import com.ws.creditcard.model.TasaJson;

public class PereRateOperation implements IrateOperation {

	@Override
	public TasaJson InterestRate(String monto) {
		TasaJson myjson = new TasaJson();
		 double rate = 0;
	        LocalDate fechaActual = LocalDate.now();

	        try {
	            int mes = fechaActual.getMonthValue(); 
	            myjson.setMarca("PERE");
	            rate = new Double(monto) *( mes * 0.1);
	            myjson.setTasa(rate);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return myjson;
	}

}
