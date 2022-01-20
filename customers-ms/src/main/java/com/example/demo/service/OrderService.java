package com.example.demo.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.vo.Order;

public interface OrderService {
	@RequestMapping(value = "/orders/", method = RequestMethod.GET, produces = "application/json")
	List<Order> getOrders();
}
