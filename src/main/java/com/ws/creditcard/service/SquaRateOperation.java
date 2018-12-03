package com.ws.creditcard.service;

import java.time.LocalDate;

import com.ws.creditcard.model.TasaJson;

public class SquaRateOperation implements IrateOperation {

	@Override
	public TasaJson InterestRate(String monto) {
		
		TasaJson myjson = new TasaJson();
		
		double rate = 0;
        try {
            LocalDate fechaActual = LocalDate.now();
            int mes = fechaActual.getMonthValue();
            int año = fechaActual.getYear() - 2000;

         rate = new Double(monto) * año / mes;
         myjson.setMarca("SQUA");       
         myjson.setTasa(rate);
         
        } catch (Exception e) {
            e.printStackTrace();
        }

        return myjson;
		 
	}

}
