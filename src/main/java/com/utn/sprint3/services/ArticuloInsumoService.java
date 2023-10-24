package com.utn.sprint3.services;

import com.utn.sprint3.entidades.ArticuloInsumo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ArticuloInsumoService extends BaseService<ArticuloInsumo, Long> {

    List<ArticuloInsumo> searchJPQLnombrado(String filtro) throws Exception;

    Page<ArticuloInsumo> searchJPQLnombrado(String filtro, Pageable pageable) throws Exception;
}
