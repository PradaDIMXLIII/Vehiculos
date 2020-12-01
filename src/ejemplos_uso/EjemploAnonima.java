package ejemplos_uso;

import vehiculos.Coche;
import vehiculos.Moto;
import vehiculos.Vehiculo;
import vehiculos.VehiculoConRuedas;

public class EjemploAnonima {

	public static void main(String[] args) {
		Vehiculo original = new Vehiculo("Original", null);
		System.out.println(original.getClass());
		
		Vehiculo anonimo = new Vehiculo("Anonimo", null) {
			String ancla = "Ancla standard";

			@Override
			public String getColor() {
				// TODO Auto-generated method stub
				return super.getColor() + "*";
			}

			@Override
			public String toString() {
				// TODO Auto-generated method stub
				return super.toString() + " " + ancla;
			}
			
		};
		System.out.println(anonimo);
		
		VehiculoConRuedas triciclo = new VehiculoConRuedas("Fisher-Price", "Multicolor") {

			@Override
			public int getNumeroDeRuedas() {
				return 3;
			}
		};

		System.out.println(triciclo);
		Moto harley = new Moto("Harley-Davidson", "Rosa") {

			@Override
			public void setColor(String color) {
				if (!(color.equals("Rojo") || color.equals("Negro"))) {
					System.out.println("No se permite ese color para " + modelo);
				}
			}
		};

		System.out.println(harley);
		harley.setColor("Rojo");
		System.out.println(harley);

		Vehiculo barco = new Vehiculo("CMB Yachts", "Blanco") {
			double eslora = 47.8;

			private double getEslora() {
				return eslora;
			}

			public String toString() {
				return super.toString() + " con " + getEslora() + "m de eslora";
			}
		};

		System.out.println(barco);
		Coche cocheConPin = new Coche() {

			@Override
			public String toString() {
				return "El código secreto es: " + miCodigoSecreto;
			}
		};

		System.out.println(cocheConPin);
		System.out.println(triciclo.getClass());
		System.out.println(harley.getClass());
		System.out.println(barco.getClass());

	}

	}

