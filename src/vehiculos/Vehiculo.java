package vehiculos;

public class Vehiculo implements Comparable<Vehiculo> {

	private static final String MODELO_NO_DISPONIBLE = "N/A";
	protected String modelo;
	private String color;

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	protected String getModelo() {
		// return modelo == null ? MODELO_NO_DISPONIBLE : modelo;
		return modelo;
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
				// return getModelo()
				+ " (" + color + ")";
	}

	@Override
	public int compareTo(Vehiculo vehiculo) {
		return getModelo().compareTo(vehiculo.getModelo());
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