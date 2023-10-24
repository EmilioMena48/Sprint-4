package com.utn.sprint3.repositorios;

import com.utn.sprint3.entidades.Base;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface BaseRepository <E extends Base, ID extends Serializable> extends JpaRepository<E, ID> {

}
