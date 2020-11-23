package vehiculos;

public class Vehiculo {

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
}