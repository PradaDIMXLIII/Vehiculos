package ejemplos_uso;

public interface Movible {

	default float distanciaRecorrida(float tiempo) {
		return getVelocidad() * tiempo;
	}

	float getVelocidad();
}
