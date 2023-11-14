package com.utn.sprint3.repositorios;

import com.utn.sprint3.Enumeraciones.Rol;
import com.utn.sprint3.entidades.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends BaseRepository<Usuario, Long>{

    Optional<Usuario> findByUsername(String username);

    boolean existsByUsername(String username);

    @Query(value = "SELECT c FROM Usuario c WHERE c.nombre LIKE %:filtro% OR c.apellido LIKE %:filtro%")
    List<Usuario> search(@Param("filtro") String filtro);

    @Query(value = "SELECT c FROM Usuario c WHERE c.nombre LIKE %:filtro% OR c.apellido LIKE %:filtro%")
    Page<Usuario> search(@Param("filtro") String filtro, Pageable pageable);

   //mostrar empleados al admin en una lista para hu4
    @Query("SELECT u FROM Usuario u WHERE u.rol IN (:roles)")
    List<Usuario> findByRoles(@Param("roles") List<Rol> roles);

    //Metodo para que empleado edite sus datos

    Usuario findById(long id);




}
