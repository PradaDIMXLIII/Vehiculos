
package com.tallerpepe;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Taller {

	private List<Reparable> listaReparables;
	private Map<Repuesto, Integer> almacenRepuestos;
	private List<HojaTrabajo> hojasTrabajo;

	public List<Reparable> getListaReparables() {
		return listaReparables;
	}

	public Map<Repuesto, Integer> getAlmacenRepuestos() {
		return almacenRepuestos;
	}

	public List<HojaTrabajo> getHojasTrabajo() {
		return hojasTrabajo;
	}

	public Taller() {
		this(new ArrayList<>(), new HashMap<>(), new ArrayList<>());
//		listaReparables = new ArrayList<>();
//		almacenRepuestos = new HashMap<>();
//		hojasTrabajo = new ArrayList<>();
	}

	public Taller(Reparable... reparables) {
		this.listaReparables = Arrays.asList(reparables);
		almacenRepuestos = new HashMap<>();
		hojasTrabajo = new ArrayList<>();

	}

	public Taller(List<Reparable> listaReparables, Map<Repuesto, Integer> almacenRepuestos,
			List<HojaTrabajo> hojasTrabajo) {
		super();
		this.listaReparables = listaReparables;
		this.almacenRepuestos = almacenRepuestos;
		this.hojasTrabajo = hojasTrabajo;
	}

	@Override
	public String toString() {
		return "Lista de Vehiculos: " + getListaReparables() + ", Almacén de Repuestos: " + getAlmacenRepuestos()
				+ ", Hojas de Trabajo: " + getHojasTrabajo();
	}

	public List<Reparable> calcularTurnoReparacion(List<Reparable> reparables) {
		Collections.sort(reparables, new Comparator<Reparable>() {

			@Override
			public int compare(Reparable reparable1, Reparable reparable2) {
				int resultado = comprobarFaltantesRepuestos(reparable1) - comprobarFaltantesRepuestos(reparable2);
				if (resultado == 0) {
					resultado = reparable1.getFechaEntrada().compareTo(reparable2.getFechaEntrada());
				}
				if (resultado == 0) {
					resultado = calcularTiempoReparacion(reparable1) - calcularTiempoReparacion(reparable2);
				}
				return resultado;
			}
		});
		return reparables;
	}

	public int calcularTiempoReparacion(Reparable reparable) {
		int tiempo = 0;
		for (Reparacion reparacion : reparable.getReparacionesPendientes()) {
			tiempo += reparacion.getHorasManoObra();
		}
		return tiempo;
	}

	public int comprobarFaltantesRepuestos(Reparable reparable) {
		int contador = 0;
		for (Reparacion reparacion : reparable.getReparacionesPendientes()) {
			for (Repuesto repuesto : reparacion.getRepuestos()) {
				if (!comprobarRepuestosAlmacen(repuesto)) {
					contador++;
				}
			}
		}
		return contador;
	}

	public boolean comprobarRepuestosAlmacen(Repuesto repuesto) {
		return (getAlmacenRepuestos().get(repuesto) > 0);
	}
	
	public boolean comprobarMalUso(Reparacion reparacion) {
		boolean resultado = false;
			if (reparacion.isMalUso()) {
				resultado = true;
		}
		return resultado;
	}
	
	public boolean comprobarGarantiaReparacion(Reparacion reparacion) {
		boolean resultado = false;
		if (reparacion.getFechaFinGarantiaReparacion().isAfter(LocalDate.now())) {
			resultado = true;
		}
		return resultado;
	}
	
	public float calcularPrecioReparaciones(Reparable reparable) {
		float precioReparaciones = 0;
		Presupuesto presupuesto = new Presupuesto(reparable);
		for (Reparacion reparacion : reparable.getReparacionesPendientes()) {
			if (!comprobarGarantiaReparacion(reparacion) || comprobarMalUso(reparacion)) {
				precioReparaciones+= presupuesto.getPrecioTotal(10.50f);
			}
		}
		return precioReparaciones;
	}

}
