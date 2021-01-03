package vehiculos;

import com.github.commerce.Merchantable;

public class CocheProducto extends Coche implements Comerciable, Merchantable {

	private float precio;

	public CocheProducto(String modelo, String color, float precio) {
		super(modelo, color);
		this.precio = precio;
	}

	@Override
	public String getDescripcion() {
		return getModelo();
	}

	@Override
	public float getPrecio() {
		return precio;
	}

	@Override
	public String getDescription() {
		return getDescripcion();
	}

	@Override
	public float getPrice() {
		return getPrecio();
	}

	public String toString() {
		return getString();
	}

}
