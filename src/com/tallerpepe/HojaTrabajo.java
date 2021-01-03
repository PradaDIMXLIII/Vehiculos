package com.tallerpepe;

import java.time.LocalDate;
import java.util.Collection;

public class HojaTrabajo {

	private Reparable reparable;
	private LocalDate fechaFin;
	private Collection<Reparacion> trabajosTerminados;

	public Reparable getReparable() {
		return reparable;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public Collection<Reparacion> getTrabajosTerminados() {
		return trabajosTerminados;
	}

	public HojaTrabajo(Reparable reparable, LocalDate fechaFin, Collection<Reparacion> trabajosTerminados) {
		super();
		this.reparable = reparable;
		this.fechaFin = fechaFin;
		this.trabajosTerminados = trabajosTerminados;
	}

	@Override
	public String toString() {
		return "\nHojaTrabajo:\n" + getReparable() + ", Fecha de Finalización: " + getFechaFin()
				+ ", Trabajos Terminados: " + getTrabajosTerminados() + "]";
	}

}
