package com.utn.sprint3.entidades;

import com.utn.sprint3.Enumeraciones.EstadoRubro;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class RubroArticuloInsumoDTO {
    String denominacion;
    EstadoRubro estadoRubro;
    List<InsumoPorRubroIdDTO> articuloInsumos;

    public RubroArticuloInsumoDTO(String denominacion, EstadoRubro estadoRubro, List<InsumoPorRubroIdDTO> articuloInsumos){
        this.denominacion = denominacion;
        this.estadoRubro = estadoRubro;
        this.articuloInsumos = articuloInsumos;
    }
}
