package com.utn.sprint3.services;

import com.utn.sprint3.entidades.ArticuloInsumo;
import com.utn.sprint3.entidades.Factura;
import com.utn.sprint3.entidades.Pedido;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PedidoService extends BaseService<Pedido, Long> {

    List<Pedido> searchJPQLnombrado(Double minTotal, Double maxTotal) throws Exception;

    Page<Pedido> searchJPQLnombrado(Double minTotal, Double maxTotal, Pageable pageable) throws Exception;


    //calcular total pedido
    Double calcularTotalPorPedido(Long filtro) throws Exception;

    List<Pedido> buscarPedidos(Long filtro) throws Exception;

    //hu17
    List<Pedido> buscarPedidosaPreparar() throws Exception;
}
