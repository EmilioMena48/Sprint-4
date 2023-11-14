package com.utn.sprint3.services;

import com.utn.sprint3.Enumeraciones.Rol;
import com.utn.sprint3.entidades.Usuario;
import com.utn.sprint3.entidades.UsuarioDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Arrays;
import java.util.List;

public interface UsuarioService extends BaseService<Usuario, Long> {

    List<Usuario> searchJPQLnombrado(String filtro) throws Exception;

    Page<Usuario> searchJPQLnombrado(String filtro, Pageable pageable) throws Exception;

    //mostrar empleados al admin en una lista para hu4

    List<Rol> roles = Arrays.asList(Rol.COCINERO, Rol.DELIVERY, Rol.CAJERO);
    List<UsuarioDTO> findByRoles(List<Rol> roles) throws Exception;



}
