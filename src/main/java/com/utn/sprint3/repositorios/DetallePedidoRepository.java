package com.utn.sprint3.repositorios;

import com.utn.sprint3.entidades.DetalleArticuloManufacturado;
import com.utn.sprint3.entidades.DetallePedido;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetallePedidoRepository extends BaseRepository<DetallePedido, Long> {

    @Query(value = "SELECT d FROM DetallePedido d WHERE d.cantidad BETWEEN :minTotal AND :maxTotal")
    List<DetallePedido> search(@Param("minTotal") Double minTotal, @Param("maxTotal") Double maxTotal);


    @Query(value = "SELECT d FROM DetallePedido d WHERE d.cantidad BETWEEN :minTotal AND :maxTotal")
    Page<DetallePedido> search(@Param("minTotal") Double minTotal, @Param("maxTotal") Double maxTotal, Pageable pageable);
}
