package com.stowe.orderservice.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stowe.orderservice.domain.exception.NegocioException;
import com.stowe.orderservice.domain.model.Client;
import com.stowe.orderservice.domain.repository.ClientRepository;

@Service
public class ClientRegisterService {
	
	@Autowired
	private ClientRepository clientRepository;
	
	public Client  save(Client client) {
		Client clientBd = clientRepository.findByEmail(client.getEmail());
		
		if(clientBd != null && !clientBd.equals(client)) {
			throw new NegocioException("Já existe um cliente cadastrado com esse email. \nthere is already a client registered with this email");
		}
		
		
		return clientRepository.save(client);
	}
	
	public void deleteById(Long clientId) {
		clientRepository.deleteById(clientId);
	}
}
