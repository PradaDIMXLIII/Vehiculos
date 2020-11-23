package vehiculos;

public class Moto extends VehiculoConRuedas {

	public Moto() {
		super();
	}

	public Moto(String modelo, String color) {
		super(modelo, color);
	}

	@Override
	public int getNumeroDeRuedas() {
		return 2;
	}

	@Override
	public String toString() {
		return "Moto: " + super.toString();
	}
}
