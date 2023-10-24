package com.utn.sprint3.services;

import com.utn.sprint3.entidades.ArticuloInsumo;
import com.utn.sprint3.entidades.DetalleArticuloManufacturado;
import com.utn.sprint3.entidades.Factura;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DetalleArticuloManufacturadoService extends BaseService<DetalleArticuloManufacturado, Long> {

    List<DetalleArticuloManufacturado> searchJPQLnombrado(Double minTotal, Double maxTotal) throws Exception;

    Page<DetalleArticuloManufacturado> searchJPQLnombrado(Double minTotal, Double maxTotal, Pageable pageable) throws Exception;
}
