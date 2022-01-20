package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.vo.Product;

@RestController
@RequestMapping("/products")
public class ProductController {

	@GetMapping("/")
	public ResponseEntity<List<Product>> getProducts() {
		List<Product> products = new ArrayList<Product>();
		Product product1 = new Product(1, "Flowers", true);
		Product product2 = new Product(2, "Vegitables", true);
		Product product3 = new Product(3, "Beverages", true);
		products.add(product1);
		products.add(product2);
		products.add(product3);
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}
}
