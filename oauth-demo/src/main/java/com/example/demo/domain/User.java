package com.example.demo.domain;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.security.config.core.GrantedAuthorityDefaults;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


public class User implements UserDetails{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public User(String userName, String fullName, String password, Set<String> roles) {
		super();
		this.userName = userName;
		this.fullName = fullName;
		this.password = password;
		this.roles = roles;
	}
	
	private String userName;
	private String fullName;
	private String password;
	private Set<String> roles;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	@Override
	public String getUsername() {
		return getUserName();
	}
	@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}
	
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return roles.stream().map(role-> new GrantedAuthority() {
			
			/**
			 * 
			 */
			private static final long serialVersionUID = 3899989678353357524L;

			@Override
			public String getAuthority() {
				// TODO Auto-generated method stub
				return role;
			}
		}).collect(Collectors.toList());
	} 
	

}
