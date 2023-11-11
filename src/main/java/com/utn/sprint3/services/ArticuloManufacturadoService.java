package com.utn.sprint3.services;

import com.utn.sprint3.entidades.ArticuloInsumo;
import com.utn.sprint3.entidades.ArticuloManufacturado;
import com.utn.sprint3.entidades.RubroArticulo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ArticuloManufacturadoService  extends BaseService<ArticuloManufacturado, Long>{

    //SearchNombre
    List<ArticuloManufacturado> searchJPQLnombrado(String filtro) throws Exception;

    Page<ArticuloManufacturado> searchJPQLnombrado(String filtro, Pageable pageable) throws Exception;

    List<ArticuloManufacturado> searchRubro(String filtro) throws Exception;
}
