package com.tallerpepe;

import java.time.LocalDate;
import java.util.Arrays;
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

	public HojaTrabajo(Reparable reparable, LocalDate fechaFin, Reparacion... trabajosTerminados) {
		super();
		this.reparable = reparable;
		this.fechaFin = fechaFin;
		this.trabajosTerminados = Arrays.asList(trabajosTerminados);
	}

	@Override
	public String toString() {
		return "\nHojaTrabajo:\n" + getReparable() + "\nFecha de Finalización: " + getFechaFin()
				+ "\nTrabajos Terminados: " + getTrabajosTerminados() + "]";
	}

}
