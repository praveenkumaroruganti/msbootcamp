package com.example.demo.vo;

public class Product {

	private int id;
	private String name;
	private boolean isActive;

	public Product(int id, String name, boolean isActive) {
		this.id = id;
		this.name = name;
		this.isActive = isActive;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

}
