package com.github.commerce;

public interface Merchantable {

	String DEFAULT_CURRENCY = "€";

	static Double priceToDouble(Merchantable merchantable) {
		return new Double(merchantable.getPrice());
	}

	String getDescription();

	float getPrice();

	default String getString() {
		return getDescription() + " (" + getPrice() + DEFAULT_CURRENCY + ")";
	}
}
