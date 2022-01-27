package com.example.demo.repository;

import java.util.Set;
import java.util.stream.Stream;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.example.demo.domain.User;

@Component
public class UserRepository {
	
	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	
	private User[] users = {new User("john", "John Mathew",encoder.encode("Test123"),Set.of("User")), 
			new User("ramesh", "Ramesh Kumar",encoder.encode("Test123"),Set.of("User"))};
	
	
	public User findByUserName(String name) {
		return Stream.of(users).filter(user -> user.getUserName().equalsIgnoreCase(name)).findAny().orElse(null);
	}
	

}
