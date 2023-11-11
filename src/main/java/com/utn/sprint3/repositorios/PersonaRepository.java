package com.utn.sprint3.repositorios;

import com.utn.sprint3.entidades.Persona;

import java.io.Serializable;

public interface PersonaRepository<E extends Persona, ID extends Serializable> extends BaseRepository<Persona, Long> {

 //   Optional<Persona> findByUsername(String username);

}
