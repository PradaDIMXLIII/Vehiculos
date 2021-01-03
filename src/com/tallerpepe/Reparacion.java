package com.tallerpepe;

import java.util.Arrays;
import java.util.Collection;

public class Reparacion {

	public enum Tipo { MOTOR, CHAPA };
	
	Tipo tipo;
	private Collection<Repuesto> repuestos;
	private float horasManoObra;
	private boolean garantia;
	
	public Collection<Repuesto> getRepuestos() {
		return repuestos;
	}
	
	public float getHorasManoObra() {
		return horasManoObra;
	}

	public boolean isGarantia() {
		return garantia;
	}
	
	public void setGarantia(boolean garantia) {
		this.garantia = garantia;
	}
	
	public Reparacion(float horasManoObra, Repuesto... repuestos) {
		super();
		this.repuestos = Arrays.asList(repuestos);
		this.horasManoObra = horasManoObra;
	}

	@Override
	public String toString() {
		return "Repuestos=" + getRepuestos() + " (" + getHorasManoObra() + "hs)";
	}
	
	
}
