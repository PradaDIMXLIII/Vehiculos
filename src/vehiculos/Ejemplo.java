package vehiculos;

public class Ejemplo {

	public static void main(String[] args) {

		String colorPorDefecto = "Rojo";
		Vehiculo miCoche = new Coche("Verde");// .modelo("Mercedes Benz");;
		Vehiculo miCoche2 = new Coche("Azul");
		// miCoche.modelo = "Ford Fiesta";
		// miCoche.color = colorPorDefecto;

		// miCoche.setColor(colorPorDefecto);
		System.out.println(miCoche);

		// miCoche2 = Coche.crearConModelo("Seat Ibiza");

		miCoche = miCoche2;
		// miCoche2.modelo = "Opel Astra";
		// miCoche2.color = "Azul";

		// miCoche2.color = colorPorDefecto;

		System.out.println(new Coche("BMW", "azul platino", 4));
		System.out.println(new Coche("SEAT TOLEDO", colorPorDefecto, 4));
		System.out.println(new Moto("Suzuki", "negro"));
	}
}
