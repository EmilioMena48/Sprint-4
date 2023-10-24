package com.utn.sprint3.services;

import com.utn.sprint3.entidades.ArticuloInsumo;
import com.utn.sprint3.entidades.DetalleFactura;
import com.utn.sprint3.entidades.Factura;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DetalleFacturaService extends BaseService<DetalleFactura, Long> {

    List<DetalleFactura> searchJPQLnombrado(Double minTotal, Double maxTotal) throws Exception;

    Page<DetalleFactura> searchJPQLnombrado(Double minTotal, Double maxTotal, Pageable pageable) throws Exception;
}
