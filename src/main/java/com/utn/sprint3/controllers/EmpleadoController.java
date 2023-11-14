package com.utn.sprint3.controllers;

import com.utn.sprint3.Enumeraciones.Rol;
import com.utn.sprint3.entidades.ArticuloInsumo;
import com.utn.sprint3.entidades.Empleado;
import com.utn.sprint3.entidades.Usuario;
import com.utn.sprint3.entidades.UsuarioDTO;
import com.utn.sprint3.services.ArticuloInsumoServiceImpl;
import com.utn.sprint3.services.EmpleadoServiceImpl;
import com.utn.sprint3.services.UsuarioServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping(path = "/api/v1/empleados")
@RequiredArgsConstructor

public class EmpleadoController extends BaseControllerImpl<Usuario, UsuarioServiceImpl>{


    @GetMapping("/hola")
    public String hola(){
       return "hola";
    }

    @GetMapping("/nombre")
    public ResponseEntity<?> searchJPQLnombrado(@RequestParam String filtro){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.searchJPQLnombrado(filtro));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\"Error, por favor intente mas tarde\"}");
        }
    }

    @GetMapping("/searchJPQLnombradoPaged")
    public ResponseEntity<?> searchJPQLnombrado(@RequestParam String filtro, Pageable pageable){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.searchJPQLnombrado(filtro, pageable));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\"Error, por favor intente mas tarde\"}");
        }
    }

    //hu4
    @GetMapping("/buscarEmpleados")
    public ResponseEntity<List<UsuarioDTO>> buscarPorRoles() {
        try {
            List<Rol> roles = Arrays.asList(Rol.COCINERO, Rol.DELIVERY, Rol.CAJERO);
            List<UsuarioDTO> usuariosDTO = servicio.findByRoles(roles);
            return new ResponseEntity<>(usuariosDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
