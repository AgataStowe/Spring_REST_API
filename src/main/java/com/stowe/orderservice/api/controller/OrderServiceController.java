package com.stowe.orderservice.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.stowe.orderservice.domain.model.OrderService;
import com.stowe.orderservice.domain.service.OrderServiceService;

@RestController
@RequestMapping("/orders-service")
public class OrderServiceController {
	
	@Autowired
	private OrderServiceService orderServiceService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public OrderService create(@Valid @RequestBody OrderService orderService) {
		return orderServiceService.create(orderService);
	}
}
