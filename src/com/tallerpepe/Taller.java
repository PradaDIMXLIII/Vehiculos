
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
	private static Map<Repuesto, Integer> almacenRepuestos;
	private List<HojaTrabajo> hojasTrabajo;
	public final static Comparator<Reparable> COMPARADOR_TURNO_REPARACION = new Comparator<Reparable>() {

		@Override
		public int compare(Reparable reparable1, Reparable reparable2) {
			int resultado = comprobarFaltantesRepuestos(reparable1) - comprobarFaltantesRepuestos(reparable2);
			if (resultado == 0) {
				resultado = reparable1.getFechaEntrada().compareTo(reparable2.getFechaEntrada());
			}
			if (resultado == 0) {
				resultado = (int) (calcularTiempoReparacion(reparable1) - calcularTiempoReparacion(reparable2));
			}
			return resultado;
		}
	};

	public List<Reparable> getListaReparables() {
		return listaReparables;
	}

	public static Map<Repuesto, Integer> getAlmacenRepuestos() {
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
		Taller.almacenRepuestos = almacenRepuestos;
		this.hojasTrabajo = hojasTrabajo;
	}

	@Override
	public String toString() {
		return "Lista de Vehiculos: " + getListaReparables() + ", Almacén de Repuestos: " + getAlmacenRepuestos()
				+ ", Hojas de Trabajo: " + getHojasTrabajo();
	}

	public List<Reparable> calcularTurnoReparacion(List<Reparable> reparables) {
		Collections.sort(reparables, COMPARADOR_TURNO_REPARACION);
		return reparables;
	}

	static double calcularTiempoReparacion(Reparable reparable) {
//		float tiempo = 0.0f;
//		for (Reparacion reparacion : reparable.getReparacionesPendientes()) {
//			tiempo += reparacion.getHorasManoObra();
//		}
//		return tiempo;
		return reparable.getReparacionesPendientes().stream().mapToDouble(Reparacion::getHorasManoObra).sum();
	}

	static int comprobarFaltantesRepuestos(Reparable reparable) {
		int contador = 0;
		for (Reparacion reparacion : reparable.getReparacionesPendientes()) {
			for (Map.Entry<Repuesto, Integer> entry : reparacion.getRepuestos().entrySet()) {
				if (comprobarRepuestosAlmacen(entry.getKey(), entry.getValue())) {
					contador++;
				}
			}
//			for (Repuesto repuesto : reparacion.getRepuestos()) {
//				if (!comprobarRepuestosAlmacen(repuesto)) {
//					contador++;
//				}
//			}
		}
		return contador;
	}

	static boolean comprobarRepuestosAlmacen(Repuesto repuesto, int valor) {
		return (getAlmacenRepuestos().get(repuesto) < valor);
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
				precioReparaciones += presupuesto.getPrecioTotal(10f);
			}
		}
		return precioReparaciones;
	}
}
