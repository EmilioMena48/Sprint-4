package com.utn.sprint3.repositorios;

import com.utn.sprint3.entidades.Base;
import com.utn.sprint3.entidades.Fecha;
import com.utn.sprint3.entidades.Persona;

import java.io.Serializable;

public interface PersonaRepository<E extends Base, ID extends Serializable> extends FechaRepository<Persona, Long> {
}
