package com.tallerpepe;

import java.time.LocalDate;
import java.util.List;

public interface Reparable {

	LocalDate getFechaEntrada(); 

	List<Reparacion> getReparacionesPendientes();
}
