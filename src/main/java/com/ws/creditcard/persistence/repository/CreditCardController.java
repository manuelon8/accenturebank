package com.ws.creditcard.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.RequestBody;

import com.ws.creditcard.model.Cliente;
import com.ws.creditcard.model.Creditcard;

public interface CreditCardController  {
	
	void saveCard(Creditcard creditcard);
	List<Creditcard> listAllCard();
	Creditcard getCard(Long id);
	Cliente updatemonto(String monto, Long id); 
	

}
