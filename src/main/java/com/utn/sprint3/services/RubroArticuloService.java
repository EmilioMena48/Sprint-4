package com.utn.sprint3.services;

import com.utn.sprint3.entidades.ArticuloInsumo;
import com.utn.sprint3.entidades.RubroArticulo;
import com.utn.sprint3.entidades.RubroArticuloInsumoDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RubroArticuloService  extends BaseService<RubroArticulo, Long>{

    List<RubroArticulo> searchJPQLnombrado(String filtro) throws Exception;

    Page<RubroArticulo> searchJPQLnombrado(String filtro, Pageable pageable) throws Exception;

    List<RubroArticuloInsumoDTO> searchRubro() throws Exception;
}
