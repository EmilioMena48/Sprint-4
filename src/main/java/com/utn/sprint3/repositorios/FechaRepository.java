package com.utn.sprint3.repositorios;

import com.utn.sprint3.entidades.Base;
import com.utn.sprint3.entidades.Fecha;

import java.io.Serializable;

public interface FechaRepository<E extends Base, ID extends Serializable> extends BaseRepository<Fecha, Long>{
}
