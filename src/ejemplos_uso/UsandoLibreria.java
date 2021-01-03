package ejemplos_uso;

import java.util.Arrays;
import java.util.Collection;

import com.github.commerce.Merchantable;
<<<<<<< HEAD
=======
import com.github.commerce.Product;
>>>>>>> 114b3b5d3e2ef6afa61796fa73e9ab6a11ea9c92

import vehiculos.CocheProducto;
import vehiculos.Comerciable;
import vehiculos.ProductExterno;

public class UsandoLibreria {

	public static void main(String[] args) {
<<<<<<< HEAD
		
		ProductExterno productoExterno = new ProductExterno("CocheRaro", 25000f);
	    CocheProducto cocheProducto = new CocheProducto("Seat", "Blanco", 16000);
		
	    System.out.println("Usando Comerciable");
	    Collection<Comerciable> productos = Arrays.asList(
	                productoExterno,
	                cocheProducto
	        );
	    

	    productos.forEach(System.out::println);
	    System.out.println(getValorTotal(productos));
	    
	    System.out.println("\nUsando Merchantable");
	    Collection<Merchantable> merchantables = Arrays.asList(
	                productoExterno,
	                cocheProducto
	        );
	    merchantables.forEach(System.out::println);
	    System.out.println(merchantables.stream().mapToDouble(Merchantable::priceToDouble).sum());

	  }

	  private static float getValorTotal(Collection<Comerciable> comerciables) {
	    return (float)comerciables.stream().mapToDouble(UsandoLibreria::toDouble).sum();
	  }

	  private static Double toDouble(Comerciable comerciable) {
	    return new Double(comerciable.getPrecio());
	  }

	}


=======
		ProductExterno productoExterno = new ProductExterno("CocheRaro", 25000f);
		CocheProducto cocheProducto = new CocheProducto("Seat", "Blanco", 16000);

		System.out.println("Usando Comerciable");
		Collection<Comerciable> productos = Arrays.asList(productoExterno, cocheProducto,
				new Comerciable() {
					
					@Override
					public float getPrecio() {
						return 1000000;
					}
					
					@Override
					public String getDescripcion() {
						return "Sin descrpicion";
					}
				});

		productos.forEach(System.out::println);
		System.out.println(getValorTotal(productos));
		
//		Collection<CocheProducto> coches = Arrays.asList(cocheProducto);
//		System.out.println(getValorTotal(coches));
		sell(cocheProducto);
		
		System.out.println("\nUsando Merchantable");
		Collection<Merchantable> merchantables = Arrays.asList(
		            productoExterno,
		            cocheProducto
		    );
		merchantables.forEach(System.out::println);
//		System.out.println(merchantables.stream().mapToDouble(Merchantable::priceToDouble).sum());
		System.out.println(getValorTotal2(merchantables));
	}

	private static float getValorTotal(Collection<Comerciable> comerciables) {
//		return (float) comerciables.stream().mapToDouble(UsandoLibreria::toDouble).sum();
		float resultado = 0;
		for (Comerciable comerciable : comerciables) {
			resultado += comerciable.getPrecio();
		}
		return resultado;
	}
	
	private static float getValorTotal2(Collection<Merchantable> merchantables) {
//		return (float) comerciables.stream().mapToDouble(UsandoLibreria::toDouble).sum();
		float resultado = 0;
		for (Merchantable merchantable : merchantables) {
			resultado += merchantable.getPrice();
		}
		return resultado;
	}

//	private static Double toDouble(Comerciable comerciable) {
//		return new Double(comerciable.getPrecio());
//	}

	public static boolean sell(Merchantable p) {return false;}
}
>>>>>>> 114b3b5d3e2ef6afa61796fa73e9ab6a11ea9c92
