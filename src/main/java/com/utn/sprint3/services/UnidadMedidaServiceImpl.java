package com.utn.sprint3.services;

import com.utn.sprint3.entidades.ArticuloInsumo;
import com.utn.sprint3.entidades.RubroArticulo;
import com.utn.sprint3.entidades.UnidadMedida;
import com.utn.sprint3.repositorios.ArticuloInsumoRepository;
import com.utn.sprint3.repositorios.BaseRepository;
import com.utn.sprint3.repositorios.UnidadMedidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnidadMedidaServiceImpl extends BaseServiceImpl<UnidadMedida, Long> implements UnidadMedidaService {

    @Autowired
    private UnidadMedidaRepository unidadMedidaRepository;

    public UnidadMedidaServiceImpl(BaseRepository<UnidadMedida, Long> baseRepository) {
        super(baseRepository);
    }

    @Override
    public List<UnidadMedida> searchJPQLnombrado(String filtro) throws Exception {
        try {
            List<UnidadMedida> unidadMedidas = unidadMedidaRepository.search(filtro);
            return unidadMedidas;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<UnidadMedida> searchJPQLnombrado(String filtro, Pageable pageable) throws Exception {
        try {
            Page<UnidadMedida> unidadMedidas = unidadMedidaRepository.search(filtro, pageable);
            return unidadMedidas;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
