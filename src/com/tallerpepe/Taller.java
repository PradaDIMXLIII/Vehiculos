
package com.tallerpepe;

import java.util.Collection;

public class Taller {

	private Collection<Reparable> listaReparables;
	private Collection<Repuesto> repuestos;
	private Collection<HojaTrabajo> hojasTrabajo;

	public Collection<Reparable> getListaReparables() {
		return listaReparables;
	}

	public Collection<Repuesto> getRepuestos() {
		return repuestos;
	}

	public Collection<HojaTrabajo> getHojasTrabajo() {
		return hojasTrabajo;
	}

	public Taller(Collection<Reparable> listaReparables, Collection<Repuesto> repuestos,
			Collection<HojaTrabajo> hojasTrabajo) {
		super();
		this.listaReparables = listaReparables;
		this.repuestos = repuestos;
		this.hojasTrabajo = hojasTrabajo;
	}

	@Override
	public String toString() {
		return "Lista de Vehiculos: " + getListaReparables() + ", Repuestos: " + getRepuestos()
				+ ", Hojas de Trabajo: " + getHojasTrabajo();
	}
	
	

}
