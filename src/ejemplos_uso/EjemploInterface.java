package ejemplos_uso;

import vehiculos.Arrancable;
import vehiculos.Coche;
import vehiculos.Vehiculo;
import vehiculos.VehiculoConRuedas;

public class EjemploInterface {

	public static void main(String[] args) {

		Object ordenador = new Arrancable() {

			@Override
			public void arrancar() {
				System.out.println("Encendido");
			}
		};

		Coche coche = new Coche();
		Arrancable a = coche;
		Vehiculo v = coche;

		Arrancable persona = new Arrancable() {

			@Override
			public void arrancar() {
				System.out.println("Me tomo un café");
			}
		};

		Arrancable vcr = new VehiculoConRuedas() {

			@Override
			public int getNumeroDeRuedas() {
				// TODO Auto-generated method stub
				return 0;
			}
		};

		vcr.arrancar();

		Arrancable[] arrancables = { (Arrancable) ordenador, coche, persona, new Coche(), vcr };

		arrancarTodos(arrancables);

		System.out.println(coche.distanciaRecorrida(3.5f));

		Movible tortuga = new Movible() {

			@Override
			public float getVelocidad() {
				return 0.2f;
			}
		};
		System.out.println(tortuga.distanciaRecorrida(4));
	}

	private static void arrancarTodos(Arrancable[] arrancables) {
		for (Arrancable arrancable : arrancables) {
			arrancable.arrancar();
		}

	}
}
