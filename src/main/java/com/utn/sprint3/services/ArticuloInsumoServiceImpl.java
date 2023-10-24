package com.utn.sprint3.services;

import com.utn.sprint3.entidades.ArticuloInsumo;
import com.utn.sprint3.entidades.Fecha;
import com.utn.sprint3.repositorios.ArticuloInsumoRepository;
import com.utn.sprint3.repositorios.BaseRepository;
import com.utn.sprint3.repositorios.FechaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticuloInsumoServiceImpl extends BaseServiceImpl<ArticuloInsumo, Long> implements ArticuloInsumoService  {

    @Autowired
    private ArticuloInsumoRepository articuloInsumoRepository;


    public ArticuloInsumoServiceImpl(BaseRepository<ArticuloInsumo, Long> baseRepository) {
        super(baseRepository);
    }


    @Override
    public List<ArticuloInsumo> searchJPQLnombrado(String filtro) throws Exception {
        try {
            List<ArticuloInsumo> articulos = articuloInsumoRepository.search(filtro);
            return articulos;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<ArticuloInsumo> searchJPQLnombrado(String filtro, Pageable pageable) throws Exception {
        try {
            Page<ArticuloInsumo> articulos = articuloInsumoRepository.search(filtro, pageable);
            return articulos;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
