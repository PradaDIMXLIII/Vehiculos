package com.tallerpepe;

public class Repuesto {

	String nombre;
	float precio;

	public String getNombre() {
		return nombre;
	}

	public float getPrecio() {
		return precio;
	}

	public Repuesto(String nombre, float precio) {
		super();
		this.nombre = nombre;
		this.precio = precio;
	}

	@Override
	public String toString() {
		return getNombre() + " " + getPrecio() + "€";
	}

}
