package ejemplos_uso;

import java.util.ArrayList;
import java.util.Collection;

import vehiculos.*;

public class EjemploCollection {

	public static void main(String[] args) {
		
		String matricula = "1234ABC";
		Coche coche = new Coche("Ford Fiesta", "Rojo"); // ¿por que no usar variable Vehiculo?
		coche.setMatricula(matricula);
		Vehiculo moto = new Moto("Suzuki", "Verde");
		
		Collection<Vehiculo> vehiculos = new ArrayList<>();
		// Agrego 2 vehiculos
		vehiculos.add(coche);
		vehiculos.add(moto);
		System.out.println(vehiculos);
		vehiculos.forEach(System.out::println);
		
		System.out.println("\nQuito la moto");
		vehiculos.remove(moto);
		vehiculos.forEach(System.out::println);
		
		coche = new Coche("Ford Fiesta", "Blanco");
		coche.setMatricula(matricula);
		
		Coche aux = coche;
		
		System.out.println(coche.equals(aux));
		System.out.println("\nAñado nuevo coche");
		vehiculos.add(coche);
		vehiculos.forEach(System.out::println);
		
		System.out.println("\nQuito coche " + coche);
		vehiculos.remove(coche);
		vehiculos.forEach(System.out::println);
	}

}
