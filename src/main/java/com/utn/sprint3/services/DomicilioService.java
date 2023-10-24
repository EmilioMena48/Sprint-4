package com.utn.sprint3.services;

import com.utn.sprint3.entidades.ArticuloInsumo;
import com.utn.sprint3.entidades.Domicilio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DomicilioService extends BaseService<Domicilio, Long> {

    List<Domicilio> searchJPQLnombrado(String filtro) throws Exception;

    Page<Domicilio> searchJPQLnombrado(String filtro, Pageable pageable) throws Exception;
}
