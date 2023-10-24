package com.utn.sprint3.repositorios;

import com.utn.sprint3.entidades.EstadisticaArticulo;
import com.utn.sprint3.entidades.EstadisticaPedido;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadisticaPedidoRepository extends BaseRepository<EstadisticaPedido, Long> {
}
