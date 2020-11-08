package com.stowe.orderservice.api.controller;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.stowe.orderservice.domain.model.Client;
import com.stowe.orderservice.domain.repository.ClientRepository;
import com.stowe.orderservice.domain.service.ClientRegisterService;

@RestController
@RequestMapping("/clients")
public class ClientController {

	@PersistenceContext
	private EntityManager manager;

	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private ClientRegisterService clientRegisterService;

	@GetMapping
	public List<Client> list() {
		return clientRepository.findAll();
	}

	@GetMapping("/{clientId}")
	public ResponseEntity<Client> find(@PathVariable Long clientId) {
		Optional<Client> client = clientRepository.findById(clientId);

		if (client.isPresent()) {
			return ResponseEntity.ok(client.get());
		}

		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public  Client add(@Valid @RequestBody Client client) {
		return clientRegisterService.save(client);
	}
	
	@PutMapping("/{clientId}")
	public ResponseEntity<Client> update(@Valid @PathVariable Long clientId, @RequestBody Client client){
		
		if(!clientRepository.existsById(clientId)) {
			return ResponseEntity.notFound().build();
		}
		
		client.setId(clientId);
		client = clientRegisterService.save(client);
		
		return ResponseEntity.ok(client);
	}
	
	@DeleteMapping("/{clientId}")
	public ResponseEntity<Void> delete(@PathVariable Long clientId){
		if(!clientRepository.existsById(clientId)) {
			return ResponseEntity.notFound().build();
		}
		
		clientRegisterService.deleteById(clientId);
		
		return ResponseEntity.noContent().build(); 
	}
	
}
