package com.tallerpepe;

import java.time.LocalDate;
import java.util.Collection;

public interface Reparable {

	LocalDate getFechaEntrada();

	Collection<Reparacion> getReparacionesPendientes();
}
