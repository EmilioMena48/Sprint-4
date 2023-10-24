package com.utn.sprint3.controllers;

import com.utn.sprint3.entidades.EstadisticaArticulo;
import com.utn.sprint3.entidades.EstadisticaPedido;
import com.utn.sprint3.services.EstadisticaArticuloServiceImpl;
import com.utn.sprint3.services.EstadisticaPedidoServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/EstadisticasPedidos")
public class EstadisticaPedidoController extends BaseControllerImpl<EstadisticaPedido, EstadisticaPedidoServiceImpl>{
}
