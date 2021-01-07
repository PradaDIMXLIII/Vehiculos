package ejemplos_uso;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import com.tallerpepe.Presupuesto;
import com.tallerpepe.Reparable;
import com.tallerpepe.Reparacion;
import com.tallerpepe.Repuesto;

public class EjemploPresupuesto {

	public static void main(String[] args) {
		
		Repuesto rueda = new Repuesto("Rueda", 100f);
		Repuesto valvula = new Repuesto("Valvula", 5f);

		List<Reparacion> reparaciones = Arrays.asList(new Reparacion(.5f, rueda, valvula), // Cambio rueda
				new Reparacion(.4f) // Paralelo
		);
		// Pongo en garantia la primera reparacion
		reparaciones.get(0).setGarantia(true);

		Reparable reparable = new Reparable() {

			@Override
			public List<Reparacion> getReparacionesPendientes() {
				return reparaciones;
			}

			@Override
			public LocalDate getFechaEntrada() {
				return LocalDate.now();
			}

			@Override
			public String toString() {
				return "Mi Reparable (pendiente: " + getReparacionesPendientes().size() + ")";
			}
		};

		Presupuesto presupuesto = new Presupuesto(reparable);
		System.out.println(presupuesto.calcularTextoPresupuesto(20f));
	}

}
