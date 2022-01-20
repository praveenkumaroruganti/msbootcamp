package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.OrderServiceFeignClient;
import com.example.demo.vo.Order;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	private OrderServiceFeignClient orderServiceFeignClient;

	@GetMapping("/")
	public String health() {
		return "I am Ok";
	}

	@GetMapping("/{id}/orders/")
	public ResponseEntity<List<Order>> getCustomerOrders(@PathVariable("id") int id) {
		List<Order> orders = orderServiceFeignClient.getOrders();
		return new ResponseEntity<List<Order>>(orders, HttpStatus.OK);
	}
}
