package ejemplos_uso;

import vehiculos.Arrancable;
import vehiculos.Moto;
import vehiculos.VehiculoConRuedas;

public class EjemploInterface {

	public static void main(String[] args) {
		Arrancable vcr = new VehiculoConRuedas() {
			
			@Override
			public int getNumeroDeRuedas() {
				// TODO Auto-generated method stub
				return 0;
			}
		};
		
		vcr.arrancar();
	}

}
