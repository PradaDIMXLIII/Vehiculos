package vehiculos;

public abstract class VehiculoConRuedas extends Vehiculo implements Arrancable {

	public VehiculoConRuedas() {
		super();
	}

	public VehiculoConRuedas(String modelo, String color) {
		super(modelo, color);
	}

	public abstract int getNumeroDeRuedas();

	@Override
	public String toString() {
		return super.toString() + ", " + getNumeroDeRuedas() + " ruedas";
	}

//	@Override
//	public void arrancar() {
//		System.out.println("Vehiculo con ruedas arrancado");
//		
//	}
	
	

}