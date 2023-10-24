package com.utn.sprint3.services;

import com.utn.sprint3.entidades.EstadisticaMonetaria;
import com.utn.sprint3.entidades.EstadisticaPedido;
import com.utn.sprint3.repositorios.BaseRepository;
import com.utn.sprint3.repositorios.EstadisticaMonetariaRepository;
import com.utn.sprint3.repositorios.EstadisticaPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstadisticaPedidoServiceImpl extends BaseServiceImpl<EstadisticaPedido, Long> implements EstadisticaPedidoService  {

    @Autowired
    private EstadisticaPedidoRepository estadisticaPedidoRepository;


    public EstadisticaPedidoServiceImpl(BaseRepository<EstadisticaPedido, Long> baseRepository) {
        super(baseRepository);
    }
}
