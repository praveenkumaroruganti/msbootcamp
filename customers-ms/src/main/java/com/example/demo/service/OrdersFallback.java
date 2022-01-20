package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.vo.Order;

@Component
public class OrdersFallback implements OrderServiceFeignClient {

	@Override
	public List<Order> getOrders() {
		return new ArrayList<Order>();
	}
}
