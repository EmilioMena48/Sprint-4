package com.utn.sprint3.repositorios;

import com.utn.sprint3.Enumeraciones.EstadoPedido;
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


    //total Pedido
    @Query(value = "SELECT SUM(d.cantidad * d.articuloManufacturado.precioVenta) AS total FROM DetallePedido d WHERE d.pedido.id = :filtro")
    Double calcularTotalPorPedido(@Param("filtro") Long filtro);

    //buscar pedidos
    @Query(value = "SELECT c.pedidos FROM Usuario c WHERE c.id = :filtro")
    List<Pedido> buscarPedidos(@Param("filtro") Long filtro);

    //mostrar pedidos con estado 'PREPARACION' para el cocinero

    @Query(value = "SELECT p FROM Pedido p WHERE p.estado = :estadoPedido")
    List<Pedido> buscarPedidosaPreparar(@Param("estadoPedido")EstadoPedido estadoPedido);




}
