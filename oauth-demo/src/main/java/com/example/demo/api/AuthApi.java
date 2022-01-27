package com.example.demo.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.User;
import com.example.demo.security.JwtTokenUtil;

@RestController
public class AuthApi {
	
	@Autowired
    private  AuthenticationManager authenticationManager;
	
	@Autowired 
	JwtTokenUtil jwtTokenUtil;

	
	@PostMapping("public/login")
	public ResponseEntity<?> login(@RequestBody AuthRequest request) {
		
		try {
		
		
			Authentication authentication = authenticationManager.authenticate(
	                    new UsernamePasswordAuthenticationToken(
	                        request.getUsername(), request.getPassword()
	                    )
	                );
			
			User user = (User) authentication.getPrincipal();
			
			return ResponseEntity.ok()
	                .header(
	                    HttpHeaders.AUTHORIZATION,
	                    jwtTokenUtil.generateAccessToken(user)
	                )
	                .body(jwtTokenUtil.generateAccessToken(user));
		} catch (AuthenticationException ae) {
			
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Authentication failed");
			
		}
		
		
	}
	
	static class AuthRequest {
		private String username;
		private String password;
		
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
	}

}
