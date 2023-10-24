package com.utn.sprint3.repositorios;

import com.utn.sprint3.entidades.Factura;
import com.utn.sprint3.entidades.Pedido;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends BaseRepository<Pedido, Long> {

    @Query(value = "SELECT p FROM Pedido p WHERE p.totalCosto BETWEEN :minTotal AND :maxTotal")
    List<Pedido> search(@Param("minTotal") Double minTotal, @Param("maxTotal") Double maxTotal);


    @Query(value = "SELECT p FROM Pedido p WHERE p.totalCosto BETWEEN :minTotal AND :maxTotal")
    Page<Pedido> search(@Param("minTotal") Double minTotal, @Param("maxTotal") Double maxTotal, Pageable pageable);
}
