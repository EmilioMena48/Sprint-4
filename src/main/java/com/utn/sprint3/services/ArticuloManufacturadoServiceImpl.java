package com.utn.sprint3.services;

import com.utn.sprint3.entidades.ArticuloInsumo;
import com.utn.sprint3.entidades.ArticuloManufacturado;
import com.utn.sprint3.entidades.RubroArticulo;
import com.utn.sprint3.repositorios.ArticuloInsumoRepository;
import com.utn.sprint3.repositorios.ArticuloManufacturadoRepository;
import com.utn.sprint3.repositorios.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ArticuloManufacturadoServiceImpl extends BaseServiceImpl<ArticuloManufacturado, Long>  implements ArticuloManufacturadoService {

    @Autowired
    private ArticuloManufacturadoRepository articuloManufacturadoRepository;

    public ArticuloManufacturadoServiceImpl(BaseRepository<ArticuloManufacturado, Long> baseRepository) {
        super(baseRepository);
    }

    @Override
    public List<ArticuloManufacturado> searchJPQLnombrado(String filtro) throws Exception {
        try {
            List<ArticuloManufacturado> articulos = articuloManufacturadoRepository.search(filtro);
            return articulos;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<ArticuloManufacturado> searchJPQLnombrado(String filtro, Pageable pageable) throws Exception {
        try {
            Page<ArticuloManufacturado> articulos = articuloManufacturadoRepository.search(filtro, pageable);
            return articulos;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<ArticuloManufacturado> searchRubro(String filtro) throws Exception {
        try {
            List<ArticuloManufacturado> articulos = articuloManufacturadoRepository.searchRubro(filtro);
            return articulos;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
