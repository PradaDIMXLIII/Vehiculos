package com.github.commerce;

public class Product implements Merchantable {

	private String description;
	private float price;

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public float getPrice() {
		return price;
	}

	public Product(String description, float price) {
		this.description = description;
		this.price = price;
	}

	@Override
	public String toString() {
		return getString();
	}
}
