package com.utn.sprint3.controllers;

import com.utn.sprint3.entidades.ArticuloInsumo;
import com.utn.sprint3.entidades.EstadisticaMonetaria;
import com.utn.sprint3.services.ArticuloInsumoServiceImpl;
import com.utn.sprint3.services.EstadisticaMonetariaServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/estadisticasMonetarias")
public class EstadisticaMonetariaController extends BaseControllerImpl<EstadisticaMonetaria, EstadisticaMonetariaServiceImpl>{
}
