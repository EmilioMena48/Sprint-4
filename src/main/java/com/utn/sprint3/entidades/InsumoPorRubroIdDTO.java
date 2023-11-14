package com.utn.sprint3.entidades;

import lombok.Data;

@Data
public class InsumoPorRubroIdDTO {
    String denominacion;

    public InsumoPorRubroIdDTO(String denominacion){
        this.denominacion = denominacion;
    }
}
