package com.app;

import java.time.LocalDate;
import com.tallerpepe.Presupuesto;
import com.tallerpepe.Reparacion;
import com.tallerpepe.Repuesto;
import com.tallerpepe.Taller;
import vehiculos.Coche;
import vehiculos.Moto;

public class App {

	public static void main(String[] args) {

		/*
		 * ingreso de un vehiculo al taller, estimación de horas de la reparación y
		 * presupuesto
		 */
		Repuesto filtroAceite = new Repuesto("Filtro aceite motor", 10.50f);
		Repuesto ruedaCoche = new Repuesto("Rueda Michelin", 65.20f);
		Repuesto ruedaHarley = new Repuesto("Rueda halery", 50.60f);
		Repuesto aceiteMotor = new Repuesto("Aceite motor diesel 5L", 20.60f);
		Repuesto filtroAire = new Repuesto("Filtro aire", 8.50f);
		Repuesto pastillaFreno = new Repuesto("Pastilla freno", 9.70f);
		Repuesto limpiaParabrisas = new Repuesto("Limpiaparabrisas 2L", 3.50f);
		Reparacion revision1 = new Reparacion(2f);
		revision1.getRepuestos().put(aceiteMotor, 2);
		revision1.getRepuestos().put(filtroAceite, 1);
		Reparacion revision2 = new Reparacion(1.30f);
		revision2.getRepuestos().put(pastillaFreno, 2);
		Reparacion cambioRuedasCoche = new Reparacion(2.30f);
		cambioRuedasCoche.getRepuestos().put(ruedaCoche, 4);
		Reparacion cambioRuedasHarley = new Reparacion(1.45f);
		cambioRuedasHarley.getRepuestos().put(ruedaHarley, 2);

		Coche cocheRenault = new Coche("Renault 21", "verde");
		cocheRenault.setMatricula("2153BNR");
		cocheRenault.getReparacionesPendientes().add(revision1);
//		cocheRenault.getReparacionesPendientes().get(0).setGarantia(true);
		cocheRenault.getReparacionesPendientes().add(cambioRuedasCoche);
//		cocheRenault.getReparacionesPendientes().get(1).setGarantia(true);
		cocheRenault.setFechaEntrada(LocalDate.of(2021, 01, 05));

		Moto harley1 = new Moto("HARLEY DAVIDSON", "negro");
		harley1.getReparacionesPendientes().add(revision2);
//		harley1.getReparacionesPendientes().get(0).setGarantia(true);
		harley1.getReparacionesPendientes().add(cambioRuedasHarley);
		harley1.setFechaEntrada(LocalDate.of(2021, 01, 05));

		Taller taller1 = new Taller(cocheRenault, harley1);
//		taller1.getListaReparables().add(cocheRenault);
//		taller1.getListaReparables().add(harley1);

		Presupuesto presupuestoRenault = new Presupuesto(cocheRenault);
		System.out.println(presupuestoRenault.calcularTextoPresupuesto(10f));
		Presupuesto presupuestoHarley = new Presupuesto(harley1);
		System.out.println(presupuestoHarley.calcularTextoPresupuesto(10f));

		/*
		 * El turno para reparar los vehículos los dará en primer lugar la existencia de
		 * piezas de repuesto para reparar todas las averías, después la fecha de
		 * entrada del vehículo al taller y finalmente el menor tiempo de reparación
		 * estimado.
		 */

		Taller.getAlmacenRepuestos().put(limpiaParabrisas, 2);
		Taller.getAlmacenRepuestos().put(pastillaFreno, 1);
		Taller.getAlmacenRepuestos().put(filtroAire, 3);
		Taller.getAlmacenRepuestos().put(aceiteMotor, 1);
		Taller.getAlmacenRepuestos().put(filtroAceite, 2);
		Taller.getAlmacenRepuestos().put(ruedaHarley, 0);
		Taller.getAlmacenRepuestos().put(ruedaCoche, 4);

		System.out.println("\nAlmacén de Repuestos:\n" + Taller.getAlmacenRepuestos().toString());
		System.out.println("\nCálculo del turno de reparación:");
		taller1.getListaReparables().sort(Taller.COMPARADOR_TURNO_REPARACION);
//		taller1.calcularTurnoReparacion(taller1.getListaReparables());
		taller1.getListaReparables().forEach(System.out::println);

		/*
		 * La reparación tendrá una fecha de entrega del vehículo y tiene un periodo de
		 * garantía de un año. En caso de surgir la misma avería en menos de un año, el
		 * taller reparará dicha avería sin coste para el cliente a menos que en la
		 * diagnosis de detecte algún tipo de mal uso o fraude.
		 */
		cambioRuedasCoche.setFechaEntregaReparable(LocalDate.of(2020, 01, 10));
		cambioRuedasCoche.setFechaFinGarantiaReparacion();
		cambioRuedasHarley.setFechaEntregaReparable(LocalDate.of(2020, 01, 03));
		cambioRuedasHarley.setFechaFinGarantiaReparacion();
		revision1.setFechaEntregaReparable(LocalDate.of(2020, 11, 10));
		revision1.setFechaFinGarantiaReparacion();
		revision1.setMalUso(true);
		revision2.setFechaEntregaReparable(LocalDate.of(2020, 10, 02));
		revision2.setFechaFinGarantiaReparacion();
		revision2.setMalUso(true);
		float precioReparacionCoche = taller1.calcularPrecioReparaciones(cocheRenault);
		float precioReparacionHarley = taller1.calcularPrecioReparaciones(harley1);
		System.out
				.println("\nEl precio de la reparacion del Coche es: " + String.format("%.2f€", precioReparacionCoche));
		System.out.println(
				"\nEl precio de la reparacion de la harley es: " + String.format("%.2f€", precioReparacionHarley));

	}

}
