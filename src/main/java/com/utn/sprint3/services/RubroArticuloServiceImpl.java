package com.utn.sprint3.services;

import com.utn.sprint3.entidades.*;
import com.utn.sprint3.repositorios.BaseRepository;
import com.utn.sprint3.repositorios.RubroArticuloRepository;
import com.utn.sprint3.repositorios.UnidadMedidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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


    @Override
    public List<RubroArticuloInsumoDTO> searchRubro() throws Exception {
        try {
            List<RubroArticulo> rubros = rubroArticuloRepository.findAll();
            List<RubroArticuloInsumoDTO> listaRubroInsumo = new ArrayList<>();
            for (RubroArticulo rubroArticulo : rubros) {
                List<InsumoPorRubroIdDTO> insumosRubro = rubroArticuloRepository.searchRubro(rubroArticulo.getId());
                RubroArticuloInsumoDTO rubroEnviar = RubroArticuloInsumoDTO.builder()
                        .denominacion(rubroArticulo.getDenominacion())
                        .estadoRubro(rubroArticulo.getEstadoRubro())
                        .articuloInsumos(insumosRubro)
                        .build();
                listaRubroInsumo.add(rubroEnviar);
            }
            return listaRubroInsumo;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
