package com.ws.creditcard.persistence.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ws.creditcard.model.Cliente;
 

public interface IClientController {
	

	void saveClient(Cliente cliente);
	List<Cliente> listAllClient();
	Cliente getClient(Long id);
	void updatesaldo( Long id, String monto); 

}
