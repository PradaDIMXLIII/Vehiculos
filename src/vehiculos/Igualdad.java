package vehiculos;

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

		// Clases anonimas
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
