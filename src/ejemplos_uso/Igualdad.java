package ejemplos_uso;

import vehiculos.Coche;
import vehiculos.Vehiculo;

public class Igualdad {

	public static void main(String[] args) {
		Coche coche1 = new Coche("Seat Ibiza", "Rojo");
		coche1.setMatricula("1234 BBB");
		Coche coche2 = new Coche("Seat Ibiza", "Rojo");
		coche2.setMatricula("1234 BBB");
		Vehiculo coche3 = coche1;

		// Igualdad
		System.out.println("coche1 y coche2 son iguales: " + coche1.equals(coche2));
		System.out.println("Pinto coche2 de Negro");
		coche2.setColor("Negro");
		System.out.println("Los coches siguen siendo iguales: " + coche1.equals(coche2));
		System.out.println("Cambio la matrícula a coche2");
		coche2.setMatricula("5555 CCC");
		System.out.println("Los coches siguen siendo iguales: " + coche1.equals(coche2));

		// Identidad
		System.out.println("coche1 y coche2 son el mismo: " + (coche1 == coche2));
		System.out.println("coche1 y coche3 son el mismo: " + (coche3 == coche1));

	}
}
