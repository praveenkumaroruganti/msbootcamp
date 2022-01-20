package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.example.demo.service.OrderServiceFeignClient;

@SpringBootApplication
@EnableFeignClients(basePackageClasses = OrderServiceFeignClient.class)
public class CustomersMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomersMsApplication.class, args);
	}

}
