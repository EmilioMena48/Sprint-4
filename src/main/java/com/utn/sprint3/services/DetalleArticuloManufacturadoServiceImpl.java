package com.utn.sprint3.services;

import com.utn.sprint3.entidades.ArticuloInsumo;
import com.utn.sprint3.entidades.DetalleArticuloManufacturado;
import com.utn.sprint3.entidades.Factura;
import com.utn.sprint3.repositorios.ArticuloInsumoRepository;
import com.utn.sprint3.repositorios.BaseRepository;
import com.utn.sprint3.repositorios.DetalleArticuloManufacturadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DetalleArticuloManufacturadoServiceImpl extends BaseServiceImpl<DetalleArticuloManufacturado, Long> implements DetalleArticuloManufacturadoService {

    @Autowired
    private DetalleArticuloManufacturadoRepository detalleArticuloManufacturadoRepository;

    public DetalleArticuloManufacturadoServiceImpl(BaseRepository<DetalleArticuloManufacturado, Long> baseRepository) {
        super(baseRepository);
    }

    @Override
    public List<DetalleArticuloManufacturado> searchJPQLnombrado(Double minTotal, Double maxTotal) throws Exception {
        try {
            List<DetalleArticuloManufacturado> detalleArticuloManufacturados = detalleArticuloManufacturadoRepository.search(minTotal, maxTotal);
            return detalleArticuloManufacturados;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<DetalleArticuloManufacturado> searchJPQLnombrado(Double minTotal, Double maxTotal, Pageable pageable) throws Exception {
        try {
            Page<DetalleArticuloManufacturado> detalleArticuloManufacturados = detalleArticuloManufacturadoRepository.search(minTotal, maxTotal, pageable);
            return detalleArticuloManufacturados;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
