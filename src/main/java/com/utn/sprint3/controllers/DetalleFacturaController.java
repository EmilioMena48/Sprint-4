package com.utn.sprint3.controllers;

import com.utn.sprint3.entidades.ArticuloInsumo;
import com.utn.sprint3.entidades.DetalleFactura;
import com.utn.sprint3.services.ArticuloInsumoServiceImpl;
import com.utn.sprint3.services.DetalleFacturaServiceImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/detallesFactura")
public class DetalleFacturaController extends BaseControllerImpl<DetalleFactura, DetalleFacturaServiceImpl>{

    @GetMapping("/searchJPQLnombrado")
    public ResponseEntity<?> searchNativo(@RequestParam Double minTotal, @RequestParam Double maxTotal){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.searchJPQLnombrado(minTotal, maxTotal));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\"Error, por favor intente mas tarde\"}");
        }
    }

    @GetMapping("/searchJPQLnombradoPaged")
    public ResponseEntity<?> searchNativo(@RequestParam Double minTotal, @RequestParam Double maxTotal, Pageable pageable){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.searchJPQLnombrado(minTotal, maxTotal));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\"Error, por favor intente mas tarde\"}");
        }
    }
}
