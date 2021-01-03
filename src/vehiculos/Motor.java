package vehiculos;

public class Motor {

	String modelo;
	float potencia; // CV
	
	public String getModelo() {
		return modelo;
	}
	
	public float getPotencia() {
		return potencia;
	}

	public Motor(String modelo, float potencia) {
		super();
		this.modelo = modelo;
		this.potencia = potencia;
	}

	@Override
	public String toString() {
		return "Motor [modelo=" + modelo + ", potencia=" + potencia + "]";
	}
	
	
}
