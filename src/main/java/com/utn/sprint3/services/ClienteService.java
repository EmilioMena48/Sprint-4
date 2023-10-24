package com.utn.sprint3.services;

import com.utn.sprint3.entidades.ArticuloInsumo;
import com.utn.sprint3.entidades.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ClienteService extends BaseService<Cliente, Long> {

    List<Cliente> searchJPQLnombrado(String filtro) throws Exception;

    Page<Cliente> searchJPQLnombrado(String filtro, Pageable pageable) throws Exception;
}
