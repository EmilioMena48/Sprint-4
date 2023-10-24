package com.utn.sprint3.services;

import com.utn.sprint3.entidades.ArticuloInsumo;
import com.utn.sprint3.entidades.DetalleFactura;
import com.utn.sprint3.entidades.Factura;
import com.utn.sprint3.repositorios.ArticuloInsumoRepository;
import com.utn.sprint3.repositorios.BaseRepository;
import com.utn.sprint3.repositorios.DetalleFacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleFacturaServiceImpl extends BaseServiceImpl<DetalleFactura, Long> implements DetalleFacturaService  {

    @Autowired
    private DetalleFacturaRepository detalleFacturaRepository;


    public DetalleFacturaServiceImpl(BaseRepository<DetalleFactura, Long> baseRepository) {
        super(baseRepository);
    }

    @Override
    public List<DetalleFactura> searchJPQLnombrado(Double minTotal, Double maxTotal) throws Exception {
        try {
            List<DetalleFactura> detalleFacturas = detalleFacturaRepository.search(minTotal, maxTotal);
            return detalleFacturas;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<DetalleFactura> searchJPQLnombrado(Double minTotal, Double maxTotal, Pageable pageable) throws Exception {
        try {
            Page<DetalleFactura> detalleFacturas = detalleFacturaRepository.search(minTotal, maxTotal, pageable);
            return detalleFacturas;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
