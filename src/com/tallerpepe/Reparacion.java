package com.tallerpepe;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;

public class Reparacion {

	public enum Tipo {
		MOTOR, CHAPA
	};

	Tipo tipo;
	private Collection<Repuesto> repuestos;
	private float horasManoObra;
	private boolean garantia;
	private LocalDate fechaEntregaReparable;
	private LocalDate fechaFinGarantiaReparacion;
	private boolean malUso = false;

	public boolean isMalUso() {
		return malUso;
	}

	public void setMalUso(boolean malUso) {
		this.malUso = malUso;
	}

	public LocalDate getFechaEntregaReparable() {
		return fechaEntregaReparable;
	}

	public void setFechaEntregaReparable(LocalDate fechaEntregaReparable) {
		this.fechaEntregaReparable = fechaEntregaReparable;
	}

	public LocalDate getFechaFinGarantiaReparacion() {
		return fechaFinGarantiaReparacion;
	}

	public void setFechaFinGarantiaReparacion() {
		if (getFechaEntregaReparable() == null) {
			System.err.println("La reparación no tiene fecha de entrega");
		} else {
			this.fechaFinGarantiaReparacion = getFechaEntregaReparable().plusYears(1);
		}
	}

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
