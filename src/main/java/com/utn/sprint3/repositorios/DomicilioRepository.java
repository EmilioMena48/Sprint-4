package com.utn.sprint3.repositorios;

import com.utn.sprint3.entidades.ArticuloInsumo;
import com.utn.sprint3.entidades.Domicilio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DomicilioRepository extends BaseRepository<Domicilio, Long> {

    @Query(value = "SELECT d FROM Domicilio d WHERE d.localidad LIKE %:filtro%")
    List<Domicilio> search(@Param("filtro") String filtro);

    @Query(value = "SELECT d FROM Domicilio d WHERE d.localidad LIKE %:filtro%")
    Page<Domicilio> search(@Param("filtro") String filtro, Pageable pageable);
}
