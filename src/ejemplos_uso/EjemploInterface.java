package ejemplos_uso;

import vehiculos.Arrancable;
<<<<<<< HEAD
import vehiculos.Moto;
=======
import vehiculos.Coche;
import vehiculos.Moto;
import vehiculos.Vehiculo;
>>>>>>> 114b3b5d3e2ef6afa61796fa73e9ab6a11ea9c92
import vehiculos.VehiculoConRuedas;

public class EjemploInterface {

	public static void main(String[] args) {
<<<<<<< HEAD
=======
		
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
		
>>>>>>> 114b3b5d3e2ef6afa61796fa73e9ab6a11ea9c92
		Arrancable vcr = new VehiculoConRuedas() {
			
			@Override
			public int getNumeroDeRuedas() {
				// TODO Auto-generated method stub
				return 0;
			}
		};
		
<<<<<<< HEAD
		vcr.arrancar();
	}

=======
		Arrancable[] arrancables = { (Arrancable)ordenador, coche, persona, new Coche(), vcr };

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
>>>>>>> 114b3b5d3e2ef6afa61796fa73e9ab6a11ea9c92
}
