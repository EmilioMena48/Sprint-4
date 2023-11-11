package com.utn.sprint3.services;

import com.utn.sprint3.entidades.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UsuarioService extends BaseService<Usuario, Long> {

    List<Usuario> searchJPQLnombrado(String filtro) throws Exception;

    Page<Usuario> searchJPQLnombrado(String filtro, Pageable pageable) throws Exception;
}
