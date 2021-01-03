package ejemplos_uso;

public interface Acelerable extends Movible {

	float getAceleracion();
	
	@Override
	default float distanciaRecorrida(float tiempo) {
		return Movible.super.distanciaRecorrida(tiempo)
				+ (0.5f*getAceleracion()*tiempo*tiempo);
	}
}
