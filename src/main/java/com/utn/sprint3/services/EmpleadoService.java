package com.utn.sprint3.services;

import com.utn.sprint3.entidades.ArticuloInsumo;
import com.utn.sprint3.entidades.Empleado;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmpleadoService extends BaseService<Empleado, Long> {

    List<Empleado> searchJPQLnombrado(String filtro) throws Exception;

    Page<Empleado> searchJPQLnombrado(String filtro, Pageable pageable) throws Exception;
}
