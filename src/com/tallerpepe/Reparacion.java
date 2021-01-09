package com.tallerpepe;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Reparacion {

	public enum Tipo {
		MOTOR, CHAPA
	};

	Tipo tipo;
	private Map<Repuesto, Integer> repuestos;
	private Collection<Repuesto> repuestos2;
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

	public Map<Repuesto, Integer> getRepuestos() {
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
		this.repuestos2 = Arrays.asList(repuestos);
		this.horasManoObra = horasManoObra;
	}

	public Reparacion(float horasManoObra) {
		super();
		this.repuestos = new HashMap<>();
		this.horasManoObra = horasManoObra;
		this.garantia = false;
	}
	
	@Override
	public String toString() {
		return "Repuestos=" + getRepuestos() + " (" + getHorasManoObra() + "hs)";
	}

	

}
