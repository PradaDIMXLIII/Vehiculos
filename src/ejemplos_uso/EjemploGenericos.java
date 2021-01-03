package ejemplos_uso;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Collection;

import comun.Identificable;
import vehiculos.Arrancable;
import vehiculos.Coche;
import vehiculos.CocheProducto;
import vehiculos.Comerciable;
import vehiculos.Moto;
import vehiculos.Vehiculo;

public class EjemploGenericos {

	public static void main(String[] args) {
		ejecutarColeccion(Arrays.asList(new Coche("", ""), new CocheProducto("", "", 0.0f)));
		admiteCocheProducto(new CocheProducto("", "", 0.0f));
		
		Collection coleccionRaw = Arrays.asList(new Coche(), new CocheProducto("", "", 10000.0f));
		Collection<Vehiculo> vehiculos = coleccionRaw;
//		  Collection<Coche> coches = vehiculos; // Error
		imprimirFlota(vehiculos);
		Collection<Coche> coches = coleccionRaw;
		imprimirFlota(coches);
//		Serializador miSerializador = new Serializador();
//		try {
//			BufferedReader buffer = new BufferedReader(new FileReader("coches.json"));
//			String linea;
//			while ((linea = buffer.readLine()) != null) {
//				coches.add(miSerializador.parse(linea, Coche.class));
//			}
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}

	private static void imprimirFlota(Collection<? extends Vehiculo> vehiculos) {
		Collection<? extends Vehiculo> c = vehiculos;
	    vehiculos.forEach(System.out::println);
	}
	
	private static <I extends Comparable<I>, T extends Identificable<I> & Arrancable> void admiteCoche(T t) {
		System.out.println(t.getId().getClass());
		t.arrancar();
	}
	
	private static <T1 extends Identificable<Long> & Arrancable> void ejecutarColeccion(Collection<T1> c) {
		c.forEach(EjemploGenericos::admiteCoche);
	}

	private static  <T2 extends Coche & Comerciable> void admiteCocheProducto(T2 cocheComerciable) {
	    System.out.println(cocheComerciable.getPrecio() + "|" + cocheComerciable.getClass());
	}
	
	private static class Serializador {
		<T> T parse(String[] datos, Class<?> clase) {
			try {
				Class<?> tipo = clase.getConstructors()[0].newInstance(datos[0], datos[1], datos[2]).getClass();
			} catch (InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			}
			return null;
		}
	}
}
