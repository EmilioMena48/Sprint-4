package com.utn.sprint3.services;

import com.utn.sprint3.entidades.ArticuloInsumo;
import com.utn.sprint3.entidades.UnidadMedida;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UnidadMedidaService  extends BaseService<UnidadMedida, Long>{

    List<UnidadMedida> searchJPQLnombrado(String filtro) throws Exception;

    Page<UnidadMedida> searchJPQLnombrado(String filtro, Pageable pageable) throws Exception;
}
