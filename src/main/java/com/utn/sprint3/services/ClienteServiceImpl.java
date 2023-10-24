package com.utn.sprint3.services;

import com.utn.sprint3.entidades.ArticuloInsumo;
import com.utn.sprint3.entidades.Cliente;
import com.utn.sprint3.repositorios.ArticuloInsumoRepository;
import com.utn.sprint3.repositorios.BaseRepository;
import com.utn.sprint3.repositorios.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl extends BaseServiceImpl<Cliente, Long> implements ClienteService  {

    @Autowired
    private ClienteRepository clienteRepository;


    public ClienteServiceImpl(BaseRepository<Cliente, Long> baseRepository) {
        super(baseRepository);
    }

    @Override
    public List<Cliente> searchJPQLnombrado(String filtro) throws Exception {
        try {
            List<Cliente> clientes = clienteRepository.search(filtro);
            return clientes;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<Cliente> searchJPQLnombrado(String filtro, Pageable pageable) throws Exception {
        try {
            Page<Cliente> clientes = clienteRepository.search(filtro, pageable);
            return clientes;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
