package com.utn.sprint3.services;

import com.utn.sprint3.entidades.ArticuloInsumo;
import com.utn.sprint3.entidades.DetallePedido;
import com.utn.sprint3.entidades.Factura;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DetallePedidoService extends BaseService<DetallePedido, Long> {

    List<DetallePedido> searchJPQLnombrado(Double minTotal, Double maxTotal) throws Exception;

    Page<DetallePedido> searchJPQLnombrado(Double minTotal, Double maxTotal, Pageable pageable) throws Exception;


    // calcular total de un producto
    Double calcularTotal(Long filtro) throws Exception;
}
