package com.utn.sprint3.repositorios;

import com.utn.sprint3.entidades.Cliente;
import com.utn.sprint3.entidades.Empleado;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpleadoRepository extends BaseRepository<Empleado, Long> {

    @Query(value = "SELECT e FROM Empleado e WHERE e.nombre LIKE %:filtro% OR e.apellido LIKE %:filtro%")
    List<Empleado> search(@Param("filtro") String filtro);

    @Query(value = "SELECT e FROM Empleado e WHERE e.nombre LIKE %:filtro% OR e.apellido LIKE %:filtro%")
    Page<Empleado> search(@Param("filtro") String filtro, Pageable pageable);
}
