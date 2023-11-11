package com.utn.sprint3.services;

import com.utn.sprint3.entidades.ArticuloInsumo;
import com.utn.sprint3.entidades.Factura;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface FacturaService extends BaseService<Factura, Long> {

    List<Factura> searchJPQLnombrado(Double minTotal, Double maxTotal) throws Exception;

    Page<Factura> searchJPQLnombrado(Double minTotal, Double maxTotal, Pageable pageable) throws Exception;

    // buscar por filtro id de pedido

    List<Factura> buscarPorIdPedido(Long filtro) throws Exception;
}
