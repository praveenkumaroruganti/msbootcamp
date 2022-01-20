package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.vo.Order;

@RestController
@RequestMapping("/orders")
public class OrderController {

	@GetMapping("/")
	public ResponseEntity<List<Order>> getProducts() {
		List<Order> orders = new ArrayList<Order>();
		Order product1 = new Order(1, "Provisions");
		orders.add(product1);
		product1 = new Order(2, "Fruits");
		orders.add(product1);
		return new ResponseEntity<List<Order>>(orders, HttpStatus.OK);
	}
	
}
