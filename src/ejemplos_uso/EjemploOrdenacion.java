package ejemplos_uso;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import vehiculos.Coche;
import vehiculos.Moto;
import vehiculos.Vehiculo;
import vehiculos.VehiculoConRuedas;

public class EjemploOrdenacion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> listaStrings = Arrays.asList("a", "c", "b", "ab");
		Collection<String> strings = listaStrings;
		System.out.println(strings);

		listaStrings.sort(null);
		// strings.sort(); da error porque strings es del tipo collection, y no permite
		// ordenar
		System.out.println(listaStrings);
		listaStrings.sort(Comparator.reverseOrder());
		System.out.println(listaStrings);

		((List<String>) strings).sort(null); // casteo
		Collections.sort(listaStrings); // clase Collections
		System.out.println(listaStrings);

	}

}
