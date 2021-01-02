package vehiculos;

import com.github.commerce.Product;

public class ProductExterno extends Product implements Comerciable {

	@Override
	public String getDescripcion() {
		return getDescription();
	}

	@Override
	public float getPrecio() {
		return getPrice();
	}
	
	public String toString() {
		return getString();
	}
	

	public ProductExterno(String description, float price) {
		super(description, price);
	}

}
