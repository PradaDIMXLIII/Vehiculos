package vehiculos;

import java.util.Comparator;
import ejemplos_uso.Acelerable;

public class Vehiculo implements Acelerable, Comparable<Vehiculo> {

	private static final String MODELO_NO_DISPONIBLE = "N/A";
	public static final Comparator<Vehiculo> COMPARADOR_LONGITUD_MODELO = new Comparator<Vehiculo>() {
		@Override
		public int compare(Vehiculo arg0, Vehiculo arg1) {
			return arg0.getModelo().length() - arg1.getModelo().length();
		}
	};
	private String modelo;
	private String color;
	protected float velocidad = 0;

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	protected String getModelo() {
		return modelo == null ? MODELO_NO_DISPONIBLE : modelo + " (" + getColor() + ")";
	}

	public Vehiculo() {
	}

	public Vehiculo(String modelo, String color) {
		this.modelo = modelo;
		setColor(color);
	}

	@Override
	public String toString() {
		return (getModelo() == null ? MODELO_NO_DISPONIBLE : getModelo())
				+ " (" + color + ")";
	}

	@Override
	public float getVelocidad() {
		return velocidad;
	}

	@Override
	public float getAceleracion() {
		return 2;
	}

	@Override
	public int compareTo(Vehiculo other) {
		int resultado = COMPARADOR_LONGITUD_MODELO.compare(this, other);
		if (resultado == 0) {
			resultado = getColor().compareTo(other.getColor());
		}
		if (resultado == 0) {

		}

		return resultado;
	}


//	public int compareTo(Vehiculo vehiculo) {
//		// para ordenar por el tamaño de los carateres del modelo
//		return getModelo().length() - (vehiculo.getModelo().length());
//	}

//	public int compareTo(Vehiculo vehiculo) {
//		// para ordenar por el tamaño de los carateres del modelo
//		int resultado = getModelo().length() - (vehiculo.getModelo().length());
//		if (resultado==0) {
//			resultado = getColor().compareTo(vehiculo.getColor());
//		}
//		/* en el caso de que el tamaño de caracteres del modelo y los colores sean iguales, puedo 
//		* seguir añadiendo más parámetros */
//		if (resultado == 0) {
//			resultado = getColor().length() - (vehiculo.getColor().length());
//		}
//		return resultado;
//	}

}