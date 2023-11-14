package com.utn.sprint3.controllers;

import com.utn.sprint3.Enumeraciones.Rol;
import com.utn.sprint3.entidades.Usuario;
import com.utn.sprint3.services.UsuarioServiceImpl;
import lombok.Builder;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Builder
@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/usuario")
public class UsuarioController extends BaseControllerImpl<Usuario, UsuarioServiceImpl>{

    @GetMapping("/searchJPQLnombrado")
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


}
