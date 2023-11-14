package com.utn.sprint3.repositorios;

import com.utn.sprint3.entidades.ArticuloInsumo;
import com.utn.sprint3.entidades.InsumoPorRubroIdDTO;
import com.utn.sprint3.entidades.RubroArticulo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RubroArticuloRepository extends BaseRepository<RubroArticulo, Long> {

    @Query(value = "SELECT r FROM RubroArticulo r WHERE r.denominacion LIKE %:filtro%")
    List<RubroArticulo> search(@Param("filtro") String filtro);

    @Query(value = "SELECT r FROM RubroArticulo r WHERE r.denominacion LIKE %:filtro%")
    Page<RubroArticulo> search(@Param("filtro") String filtro, Pageable pageable);

    @Query(value = "SELECT new com.utn.sprint3.entidades.InsumoPorRubroIdDTO(a.denominacion) FROM ArticuloInsumo a WHERE a.rubroArticulo.id = :id")
    List<InsumoPorRubroIdDTO> searchRubro(@Param("id") Long id);
}
