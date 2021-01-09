package com.tallerpepe;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

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
			if (!reparacion.isGarantia()) {
				horasTotales += reparacion.getHorasManoObra();
			}
		}

		return horasTotales;
	}

	public float getPrecioRepuestos() {
		Map<Repuesto, Integer> repuestos = new HashMap<>();
		for (Reparacion reparacion : getReparaciones()) {
			if (!reparacion.isGarantia()) {
				for (Map.Entry<Repuesto, Integer> entry : reparacion.getRepuestos().entrySet()) {
					repuestos.put(entry.getKey(), entry.getValue());
				}
			}
		}
		return getPrecioPara(repuestos);
	}

	public float getPrecioTotal(float precioManoObra) {
		return getPrecioRepuestos() + getHorasManoObra() * precioManoObra;
	}

	private static float getPrecioPara(Map<Repuesto, Integer> repuestos) {
		float total = 0;
		for (Map.Entry<Repuesto, Integer> entry : repuestos.entrySet()) {
			total += entry.getKey().getPrecio() * entry.getValue();
		}

		return total;
	}

	public String calcularTextoPresupuesto(float precioManoObra) {
		String texto = "\nPresupuesto para:\n";
		texto += getReparable();
		// Ahora pongo cara reparacion en una linea
		for (Reparacion reparacion : getReparaciones()) {
			texto += "\n" + reparacion; // "\n" para salto de linea
		}
		texto += "\nPrecio Total: " + String.format("%.2f €", getPrecioTotal(precioManoObra));

		return texto;
	}
}
