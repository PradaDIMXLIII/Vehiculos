package vehiculos;

import comun.Identificable;

public class Coche extends VehiculoConRuedas implements Identificable<Long> {

	private int numeroDeRuedas;
	private String matricula;
	private Motor motor;
	private Long id = 0L;

	@Override
	public Long getId() {
		return id;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Motor getMotor() {
		return motor;
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
		this(modelo, color, ruedas, null);
	}

	public Coche(String modelo, String color, int ruedas, Motor motor) {
		super(modelo, color);
		numeroDeRuedas = ruedas;
		velocidad = 5;
		this.motor = motor;
	}

	@Override
	public String toString() {
		return "Placa " + getMatricula() + " - " + super.toString() + " | " + getMotor();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getMatricula() == null) ? 0 : getMatricula().hashCode());
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
		if (getMatricula() == null) {
			if (other.getMatricula() != null)
				return false;
		} else if (!getMatricula().equals(other.getMatricula()))
			return false;
		if (getModelo() == null) {
			if (other.getModelo() != null)
				return false;
		} else if (!getModelo().equals(other.getModelo()))
			return false;
		return true;
	}

	@Override
	public void arrancar() {
		System.out.println("Coche arrancando");

	}

	@Override
	public int getNumeroDeRuedas() {
		return numeroDeRuedas;
	}

}
