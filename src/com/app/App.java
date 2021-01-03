package com.app;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import com.tallerpepe.Presupuesto;
import com.tallerpepe.Reparable;
import com.tallerpepe.Reparacion;
import com.tallerpepe.Repuesto;


public class App {

	public static void main(String[] args) {

		// ingreso de un vehiculo al taller, estimación de horas de la reparación y presupuesto
		Repuesto filtroAceite = new Repuesto("Filtro aceite motor", 10.50f);
		Repuesto aceiteMotor = new Repuesto("Aceite motor diesel 5L", 20.60f);
		Repuesto filtroAire = new Repuesto("Filtro aire", 8.50f);
		Repuesto pastillaFreno = new Repuesto("Pastilla freno", 9.70f);
		Repuesto limpiaParabrisas = new Repuesto("Limpiaparabrisas 2L", 3.50f);
		Reparacion revision = new Reparacion(2f, filtroAceite, aceiteMotor, filtroAceite, filtroAire, pastillaFreno,
				pastillaFreno, limpiaParabrisas);
		revision.setGarantia(false);
		Collection<Reparacion> reparaciones = new ArrayList<>();
		reparaciones.add(revision);
		Reparable cocheRenault = new Reparable() {
			
			@Override
			public Collection<Reparacion> getReparacionesPendientes() {
				return reparaciones;
			}
			
			@Override
			public LocalDate getFechaEntrada() {
				return LocalDate.of(2021, 01, 04);
			}
		};
		
		Presupuesto presupuestoRenault = new Presupuesto(cocheRenault);
		System.out.println(presupuestoRenault.calcularTextoPresupuesto(8.90f));
		
		

	}

}
