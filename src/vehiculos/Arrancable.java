package vehiculos;

public interface Arrancable {

	default void arrancar() {
		System.out.println("Configuración por defecto en Interfaz Arrancable");
	}

}
