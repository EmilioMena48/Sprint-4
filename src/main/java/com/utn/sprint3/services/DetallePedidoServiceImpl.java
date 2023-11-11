package com.utn.sprint3.services;

import com.utn.sprint3.entidades.ArticuloInsumo;
import com.utn.sprint3.entidades.DetallePedido;
import com.utn.sprint3.entidades.Factura;
import com.utn.sprint3.repositorios.ArticuloInsumoRepository;
import com.utn.sprint3.repositorios.BaseRepository;
import com.utn.sprint3.repositorios.DetallePedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetallePedidoServiceImpl extends BaseServiceImpl<DetallePedido, Long> implements DetallePedidoService  {

    @Autowired
    private DetallePedidoRepository detallePedidoRepository;


    public DetallePedidoServiceImpl(BaseRepository<DetallePedido, Long> baseRepository) {
        super(baseRepository);
    }

    @Override
    public List<DetallePedido> searchJPQLnombrado(Double minTotal, Double maxTotal) throws Exception {
        try {
            List<DetallePedido> detallePedidos = detallePedidoRepository.search(minTotal, maxTotal);
            return detallePedidos;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<DetallePedido> searchJPQLnombrado(Double minTotal, Double maxTotal, Pageable pageable) throws Exception {
        try {
            Page<DetallePedido> detallePedidos = detallePedidoRepository.search(minTotal, maxTotal, pageable);
            return detallePedidos;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Double calcularTotal(Long filtro) throws Exception {
        try {
            Double total = detallePedidoRepository.calcularTotal(filtro);
            return total;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
