package com.utn.sprint3.repositorios;

import com.utn.sprint3.entidades.ArticuloManufacturado;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticuloManufacturadoRepository extends BaseRepository<ArticuloManufacturado, Long> {

    //Query para buscar productos por nombre, para hu9
    @Query(value = "SELECT a FROM ArticuloManufacturado a WHERE a.denominacion LIKE %:filtro%")
    List<ArticuloManufacturado> search(@Param("filtro") String filtro);

    @Query(value = "SELECT a FROM ArticuloManufacturado a WHERE a.denominacion LIKE %:filtro%")
    Page<ArticuloManufacturado> search(@Param("filtro") String filtro, Pageable pageable);


    // Query para buscar porductos por rubro, para la hu9
    @Query(value = "SELECT a FROM ArticuloManufacturado a WHERE a.rubroArticulo.denominacion LIKE :filtro")
    List<ArticuloManufacturado> searchRubro(@Param("filtro") String filtro);


}
