package com.utn.sprint3.entidades;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DomicilioDTO implements Serializable {

    Long id;
    String calle;
    Integer numero;
    Integer codigoPostal;
    String localidad;
    String departamento;
    Integer numeroVivienda;
    String pisoDto;
}
