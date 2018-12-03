package com.ws.creditcard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ws.creditcard.model.Cliente;
import com.ws.creditcard.persistence.repository.IClientController;
import com.ws.creditcard.service.ClientService;

@RestController
@RequestMapping("/client")
public class AppControllerClient implements IClientController{

	@Autowired
	private ClientService clientService;  
	
	@RequestMapping(value="", method = RequestMethod.POST)
	@Override	
	public void saveClient(@RequestBody Cliente cliente) {

		clientService.saveClient(cliente); 
		
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

	@RequestMapping(value="/updatemonto/{id}/{monto}", method = RequestMethod.PUT)
	@Override
	public void updatesaldo(@PathVariable Long id, @PathVariable  String monto) {
		clientService.updatesaldo(id, monto);
		 
	}
	
	

}
