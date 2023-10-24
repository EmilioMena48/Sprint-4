package com.utn.sprint3.services;

import com.utn.sprint3.entidades.ArticuloInsumo;
import com.utn.sprint3.entidades.EstadisticaMonetaria;
import com.utn.sprint3.repositorios.ArticuloInsumoRepository;
import com.utn.sprint3.repositorios.BaseRepository;
import com.utn.sprint3.repositorios.EstadisticaMonetariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstadisticaMonetariaServiceImpl extends BaseServiceImpl<EstadisticaMonetaria, Long> implements EstadisticaMonetariaService  {

    @Autowired
    private EstadisticaMonetariaRepository estadisticaMonetariaRepository;


    public EstadisticaMonetariaServiceImpl(BaseRepository<EstadisticaMonetaria, Long> baseRepository) {
        super(baseRepository);
    }
}
