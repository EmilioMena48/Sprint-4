package com.utn.sprint3.services;

import com.utn.sprint3.entidades.ArticuloInsumo;
import com.utn.sprint3.entidades.RubroArticulo;
import com.utn.sprint3.entidades.UnidadMedida;
import com.utn.sprint3.repositorios.BaseRepository;
import com.utn.sprint3.repositorios.RubroArticuloRepository;
import com.utn.sprint3.repositorios.UnidadMedidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RubroArticuloServiceImpl extends BaseServiceImpl<RubroArticulo, Long>  implements RubroArticuloService {

    @Autowired
    private RubroArticuloRepository rubroArticuloRepository;

    public RubroArticuloServiceImpl(BaseRepository<RubroArticulo, Long> baseRepository) {
        super(baseRepository);
    }

    @Override
    public List<RubroArticulo> searchJPQLnombrado(String filtro) throws Exception {
        try {
            List<RubroArticulo> rubroArticulos = rubroArticuloRepository.search(filtro);
            return rubroArticulos;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<RubroArticulo> searchJPQLnombrado(String filtro, Pageable pageable) throws Exception {
        try {
            Page<RubroArticulo> rubroArticulos = rubroArticuloRepository.search(filtro, pageable);
            return rubroArticulos;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
