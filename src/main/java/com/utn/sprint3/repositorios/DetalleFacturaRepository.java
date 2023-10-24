package com.utn.sprint3.repositorios;

import com.utn.sprint3.entidades.DetalleArticuloManufacturado;
import com.utn.sprint3.entidades.DetalleFactura;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetalleFacturaRepository extends BaseRepository<DetalleFactura, Long> {

    @Query(value = "SELECT d FROM DetalleFactura d WHERE d.cantidad BETWEEN :minTotal AND :maxTotal")
    List<DetalleFactura> search(@Param("minTotal") Double minTotal, @Param("maxTotal") Double maxTotal);


    @Query(value = "SELECT d FROM DetalleFactura d WHERE d.cantidad BETWEEN :minTotal AND :maxTotal")
    Page<DetalleFactura> search(@Param("minTotal") Double minTotal, @Param("maxTotal") Double maxTotal, Pageable pageable);
}
