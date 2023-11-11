package com.utn.sprint3.services;

import com.utn.sprint3.entidades.ArticuloInsumo;
import com.utn.sprint3.entidades.ArticuloManufacturado;
import com.utn.sprint3.entidades.Factura;
import com.utn.sprint3.repositorios.ArticuloInsumoRepository;
import com.utn.sprint3.repositorios.BaseRepository;
import com.utn.sprint3.repositorios.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacturaServiceImpl extends BaseServiceImpl<Factura, Long> implements FacturaService  {

    @Autowired
    private FacturaRepository facturaRepository;


    public FacturaServiceImpl(BaseRepository<Factura, Long> baseRepository) {
        super(baseRepository);
    }


    @Override
    public List<Factura> searchJPQLnombrado(Double minTotal, Double maxTotal) throws Exception {
        try {
            List<Factura> facturas = facturaRepository.search(minTotal, maxTotal);
            return facturas;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<Factura> searchJPQLnombrado(Double minTotal, Double maxTotal, Pageable pageable) throws Exception {
        try {
            Page<Factura> facturas = facturaRepository.search(minTotal, maxTotal, pageable);
            return facturas;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Factura> buscarPorIdPedido(Long filtro) throws Exception {
        try {
            List<Factura> facturas = facturaRepository.buscarPorIdPedido(filtro);
            return facturas;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
