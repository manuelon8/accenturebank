package com.ws.creditcard.service;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.ws.creditcard.exception.CardNoFoundException;
import com.ws.creditcard.model.Cliente;
import com.ws.creditcard.model.Creditcard;
import com.ws.creditcard.model.TasaJson;
import com.ws.creditcard.model.Transaccion;
import com.ws.creditcard.persistence.repository.CreditCardController;
import com.ws.creditcard.persistence.repository.CreditCardRepository;

@Service
@Transactional
public class CardServices implements CreditCardController {
	LocalDate fechaActual = LocalDate.now();

	@Autowired
	private CreditCardRepository creditCardRepository;
	 
	private static final Logger log = LoggerFactory.getLogger(CardServices.class);

	@Override
	public void saveCard(Creditcard creditcard) {
		try {
			if (creditcard.getNumero() == null)	throw new CardNoFoundException();
			
			creditCardRepository.save(creditcard);

		} catch (Exception e) {
			log.error("error: al guardar tarjeta", e);
			e.printStackTrace();
		}

	}

	@Override
	public List<Creditcard> listAllCard() {
		try {

			return creditCardRepository.findAll();

		} catch (Exception e) {
			log.error("error: al listar tarjetas", e);
			 
		}

		return null;
	}

	@Override
	public Creditcard getCard(Long id) {
		try {
			return creditCardRepository.findById(id).orElse(null);
		} catch (Exception e) {
			log.error("error: al guardar tarjeta", e);
			 
		}
		return null;
	}

	public String imprimirfactura(@PathVariable Long id, @PathVariable double monto) {
		String response = "";
		Creditcard card = new Creditcard();
		PrintTest print = new PrintTest();
		Transaccion tran = new Transaccion();
		try {

			card = creditCardRepository.findById(id).orElse(null);

			if ((card != null)) {

				tran.setNumtarjeta(card.getNumero());
				tran.setMonto(monto);
				tran.setFechatran(fechaActual.toString());
				// print.imprimirfactura(tran);
				response = "Transaccion Exitosa " + tran.getId();
				System.out.println("Transaccion Exitosa.. " + tran.getId());
			}

		} catch (Exception e) {
			System.out.println("Error: En impresion de factura.. " + tran.getId());
			log.error("Error: En impresion de factura..", e);
		}
		return response;
	}

	@Override
	public Cliente updatemonto(String monto, Long id) {
		double value = Double.parseDouble(monto);
		Cliente client = new Cliente();
		client.setNombres("Manuel");
		client.setApellidos("Martinez");
		double newbalance = UpBalance(1000, value);
		client.setSaldo(String.valueOf(newbalance));

		return client;

	}

	public double UpBalance(double saldo, double monto) {

		if (saldo > monto) {
			return saldo - monto;
		}
		return saldo;

	}
	
	double monto =0;
	
	public boolean validateOperation(double mount) {
		boolean validation = false;
		 
		if(mount<1000 && mount>0)
		{
			return true;
		}
		return validation;
	}
	
	 /*  
	  VALIDA SI UNA TARJETA ES VALIDA PARA OPERAR
	  */
	  
	  public boolean  validateDate(String carddate){
	    boolean valid = false;
	    LocalDate fechaActual = LocalDate.now();
	    
	    if(carddate.equals(fechaActual.toString()))
	    {
	     valid = true;
	    }
	    return valid;	    
	    }
	  
	  /*  
	  DEFINE LA MARCA DE UNA TARJETA ES VALIDA PARA OPERAR
	  */
	  
	    public TasaJson  getTasa(String cardnumber, String monto) {
	    	TasaJson myjson = new TasaJson();
	        String rate = "";

	        int a = Character.getNumericValue(cardnumber.charAt(0));
	        try {
	            if (esDecimal(monto) && validateOperation(new Double(monto))) {

	                switch (a) {
	                    case 1:
	                        PereRateOperation tasa = new PereRateOperation();
	                        myjson = tasa.InterestRate(monto);
	                        break;

	                    case 2:
	                        SquaRateOperation tas = new SquaRateOperation();
	                        myjson = tas.InterestRate(monto);
	                        break;
	                    case 3:
	                        ScoRateOperation tasas = new ScoRateOperation();
	                        myjson = tasas.InterestRate(monto);
	                        break;

	                }
	            }
	            else{
	            rate = "Monto de la Operacion Invalido";
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	            System.out.println("No Ejecuto el rate" + e.getMessage());
	        }

	        return myjson;

	    }
	 
	    public boolean esDecimal(String cad) {
	        try {
	            Double.parseDouble(cad);
	            return true;
	        } catch (NumberFormatException nfe) {
	            return false;
	        }
	    }
	 
	  
	
	

}
