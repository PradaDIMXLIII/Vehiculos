package com.tallerpepe;

import java.util.ArrayList;
import java.util.Collection;

public class Presupuesto {

	private Reparable reparable;
	private Collection<Reparacion> reparaciones;
	
	private Reparable getReparable() {
		return reparable;
	}
	
	public Collection<Reparacion> getReparaciones() {
		return reparaciones;
	}
	
	public Presupuesto(Reparable reparable) {
		this.reparable = reparable;
		reparaciones = new ArrayList<>(reparable.getReparacionesPendientes());
	}
	
	public float getHorasManoObra() {
		float horasTotales = 0;
		for (Reparacion reparacion : getReparaciones()) {
			if(!reparacion.isGarantia()) {
				horasTotales += reparacion.getHorasManoObra();
			}
		}
		
		return horasTotales;
	}
	
	public float getPrecioRepuestos() {
		Collection<Repuesto> repuestos = new ArrayList<>();
		for (Reparacion reparacion : getReparaciones()) {
			if(!reparacion.isGarantia()) {
				repuestos.addAll(reparacion.getRepuestos());
			}
		}
		return getPrecioPara(repuestos);
	}
	
	public float getPrecioTotal(float precioManoObra) {
		return getPrecioRepuestos() + getHorasManoObra() * precioManoObra;
	}
	
	private static float getPrecioPara(Collection<Repuesto> repuestos) {
		float total = 0;
		for (Repuesto repuesto : repuestos) {
			total += repuesto.getPrecio();
		}
		
		return total;
	}

	public String calcularTextoPresupuesto(float precioManoObra) {
		String texto = "Presupuesto para:\n";
		texto += getReparable();
		// Ahora pongo cara reparacion en una linea
		for (Reparacion reparacion : getReparaciones()) {
			texto += "\n" + reparacion; // "\n" para dalto de linea
		}
		texto += "\nPrecio Total: " + getPrecioTotal(precioManoObra);
		
		return texto;
	}
}
