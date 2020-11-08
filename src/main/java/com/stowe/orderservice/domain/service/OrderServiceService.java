package com.stowe.orderservice.domain.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stowe.orderservice.domain.exception.NegocioException;
import com.stowe.orderservice.domain.model.Client;
import com.stowe.orderservice.domain.model.OrderService;
import com.stowe.orderservice.domain.model.StatusOrderService;
import com.stowe.orderservice.domain.repository.ClientRepository;
import com.stowe.orderservice.domain.repository.OrderServiceRepository;

@Service
public class OrderServiceService {
	
	@Autowired
	private OrderServiceRepository orderServiceRepository;
	
	@Autowired
	private ClientRepository clientRepository;
	
	public OrderService create(OrderService orderService) {
		Client client = clientRepository.findById(orderService.getClient().getId())
				.orElseThrow(() -> new NegocioException("Cliente não encontrado. (Client not found)"));
		
		
		orderService.setClient(client);
		orderService.setStatus(StatusOrderService.OPEN);
		orderService.setOpeningDate(LocalDateTime.now());
		
		return orderServiceRepository.save(orderService);
	}
}
