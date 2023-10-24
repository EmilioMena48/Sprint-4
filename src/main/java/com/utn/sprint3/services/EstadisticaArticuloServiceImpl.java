package com.utn.sprint3.services;

import com.utn.sprint3.entidades.ArticuloInsumo;
import com.utn.sprint3.entidades.EstadisticaArticulo;
import com.utn.sprint3.repositorios.ArticuloInsumoRepository;
import com.utn.sprint3.repositorios.BaseRepository;
import com.utn.sprint3.repositorios.EstadisticaArticuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstadisticaArticuloServiceImpl extends BaseServiceImpl<EstadisticaArticulo, Long> implements EstadisticaArticuloService  {

    @Autowired
    private EstadisticaArticuloRepository estadisticaArticuloRepository;


    public EstadisticaArticuloServiceImpl(BaseRepository<EstadisticaArticulo, Long> baseRepository) {
        super(baseRepository);
    }
}
