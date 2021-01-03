package ejemplos_uso;

import vehiculos.Moto;
import vehiculos.Vehiculo;
import vehiculos.VehiculoConRuedas;

public class EjemploAnonima {

	private static String colorValido2 = "Verde";

	public static void main(String[] args) {

		Vehiculo original = new Vehiculo("Original", null);
		System.out.println(original.getClass());

		Vehiculo anonimo = new VehiculoConRuedas("Anonimo", null) {
			public String ancla = "Ancla standard";

			@Override
			public String getColor() {
				return super.getColor() + "*";
			}

			@Override
			public String toString() {
				return super.toString() + " " + ancla;
			}

			@Override
			public int getNumeroDeRuedas() {
				return 0;
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
					System.out.println("No se permite ese color para " + getModelo());
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
		System.out.println(triciclo.getClass());
		System.out.println(harley.getClass());
		System.out.println(barco.getClass());

		System.out.println(anonimo.getClass());

		System.out.println(original);
		System.out.println(anonimo);
		System.out.println(triciclo);
		System.out.println(triciclo);
		System.out.println(triciclo);
		System.out.println(triciclo);

		String colorValido1 = "Azul";
//		String colorValido2 = "Verde";

		Moto harley2 = new Moto("Harley-Davidson", "Rojo") {

			@Override
			public void setColor(String color) {
				if (!(color.equals(colorValido1) || color.equals(colorValido2))) {
					System.out.println("No se permite ese color para " + getModelo());
				} else {
					super.setColor(color);
				}
			}

		};
		harley.setColor("Verde");
		System.out.println(harley2);
	}

}
