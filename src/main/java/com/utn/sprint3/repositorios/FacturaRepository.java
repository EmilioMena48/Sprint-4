package com.utn.sprint3.repositorios;

import com.utn.sprint3.entidades.ArticuloInsumo;
import com.utn.sprint3.entidades.Factura;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface FacturaRepository extends BaseRepository<Factura, Long> {

    @Query(value = "SELECT f FROM Factura f WHERE f.totalVenta BETWEEN :minTotal AND :maxTotal")
    List<Factura> search(@Param("minTotal") Double minTotal, @Param("maxTotal") Double maxTotal);


    @Query(value = "SELECT f FROM Factura f WHERE f.totalVenta BETWEEN :minTotal AND :maxTotal")
    Page<Factura> search(@Param("minTotal") Double minTotal, @Param("maxTotal") Double maxTotal, Pageable pageable);

    // buscar factura por filtro id pedido para hu13
    @Query(value = "SELECT f FROM Factura f WHERE f.pedido.id = :filtro")
    List<Factura> buscarPorIdPedido(@Param("filtro") Long filtro);
}
