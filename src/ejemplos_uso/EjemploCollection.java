package ejemplos_uso;

import java.util.ArrayList;
import java.util.Collection;

<<<<<<< HEAD
import vehiculos.*;
=======
import vehiculos.Coche;
import vehiculos.Moto;
import vehiculos.Vehiculo;
>>>>>>> 114b3b5d3e2ef6afa61796fa73e9ab6a11ea9c92

public class EjemploCollection {

	public static void main(String[] args) {
		String matricula = "1234ABC";
		Coche coche = new Coche("Ford Fiesta", "Rojo"); // ¿por que no usar variable Vehiculo?
		coche.setMatricula(matricula);
		Vehiculo moto = new Moto("Suzuki", "Verde");
<<<<<<< HEAD
				
		Collection<Vehiculo> vehiculos = new ArrayList<>();
		vehiculos.add(coche);
		vehiculos.add(moto);
		System.out.println(vehiculos);
		
=======
		
		Collection<Vehiculo> vehiculos = new ArrayList<>();
		// Agrego 2 vehiculos
		vehiculos.add(coche);
		vehiculos.add(moto);
		System.out.println(vehiculos);
>>>>>>> 114b3b5d3e2ef6afa61796fa73e9ab6a11ea9c92
		vehiculos.forEach(System.out::println);
		
		System.out.println("\nQuito la moto");
		vehiculos.remove(moto);
		vehiculos.forEach(System.out::println);
		
<<<<<<< HEAD
		coche = new Coche("Ford Fiesta", "Blanco");
		coche.setMatricula(matricula);
		
=======
		Coche aux = coche;
		
		coche = new Coche("Ford Fiesta", "Blanco");
		coche.setMatricula(matricula);
		System.out.println(coche.equals(aux));
>>>>>>> 114b3b5d3e2ef6afa61796fa73e9ab6a11ea9c92
		System.out.println("\nAñado nuevo coche");
		vehiculos.add(coche);
		vehiculos.forEach(System.out::println);
		
		System.out.println("\nQuito coche " + coche);
		vehiculos.remove(coche);
		vehiculos.forEach(System.out::println);
<<<<<<< HEAD

=======
>>>>>>> 114b3b5d3e2ef6afa61796fa73e9ab6a11ea9c92
	}

}
