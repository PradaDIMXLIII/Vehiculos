package ejemplos_uso;

import static vehiculos.Coche.*;

import vehiculos.Coche;
import vehiculos.Moto;
import vehiculos.Vehiculo;

public class Ejemplo {

	public static void main(String[] args) {

		String colorPorDefecto = "Rojo";
		Vehiculo miCoche = new Coche("Mercedes", "Verde", 4);// .modelo("Mercedes Benz");
		Vehiculo miMoto = new Moto("BMW", "Azul");
//		miCoche.modelo = "Ford Fiesta";
//		miCoche.color = colorPorDefecto;

//		miCoche.setColor(colorPorDefecto);
//		System.out.println(miCoche);

//		miCoche2 = Coche.crearConModelo("Seat Ibiza");

//		miCoche2.modelo = "Opel Astra";
//		miCoche2.color = "Azul";

//		miCoche2.color = colorPorDefecto;

		System.out.println(miCoche);
		System.out.println(miMoto);
	}

}
