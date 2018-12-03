package com.ws.creditcard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ws.creditcard.exception.CardNoFoundException;
import com.ws.creditcard.model.Cliente;
import com.ws.creditcard.model.Creditcard;
import com.ws.creditcard.persistence.repository.IClientController;
import com.ws.creditcard.persistence.repository.IClientRepository;
@Service
public class ClientService implements IClientController{
	
	@Autowired
	private IClientRepository clientrepository;
	

	@Override
	public void saveClient(Cliente cliente) {
		
		try {
			
			clientrepository.save(cliente);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}		
	 

	@Override
	public List<Cliente> listAllClient() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cliente getClient(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updatesaldo(Long id, String monto) {
		try {
			Cliente client = clientrepository.findById(id).orElse(null);
			client.setSaldo(monto);
			clientrepository.save(client);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

 
	

}
