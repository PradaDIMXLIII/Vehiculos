package vehiculos;

public class Coche extends Vehiculo {

	private int numeroDeRuedas;
	private String matricula;
	protected static int miCodigoSecreto = 12345;

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Coche() {
		this("Blanco");
		// numeroDeRuedas = 4;
	}

	public Coche(String color) {
		// this();
		// numeroDeRuedas = 4;
		// setColor(color); // como ya tengo el setter lo utilizo
		this(null, color);
	}

	public Coche(String modelo, String color) {
		// super(modelo, color);
		// numeroDeRuedas = 4;
		this(modelo, color, 4);
	}

	public Coche(String modelo, String color, int ruedas) {
		super(modelo, color);
		numeroDeRuedas = ruedas;
	}

	// public Coche color(String color) {
	// setColor(color);
	// return this;
	// }
	//
	// public Coche modelo(String modelo) {
	// this.modelo = modelo;
	// return this;
	// }

	// public static Coche crearConModelo(String modelo) {
	// Coche coche = new Coche();
	// coche.modelo = modelo;
	// return coche;
	// }

	@Override
	public String toString() {
		return super.toString() + ", " + numeroDeRuedas + " ruedas";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		result = prime * result + ((getModelo() == null) ? 0 : getModelo().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coche other = (Coche) obj;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		if (getModelo() == null) {
			if (other.getModelo() != null)
				return false;
		} else if (!getModelo().equals(other.getModelo()))
			return false;
		return true;
	}
}
