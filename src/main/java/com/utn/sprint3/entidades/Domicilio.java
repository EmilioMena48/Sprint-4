package com.utn.sprint3.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;


@Entity
@Table(name = "domicilio")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Domicilio extends Fecha{

    @NotNull
    @Column(name = "calle", length = 500)
    private String calle;

    @NotNull
    @Column(name = "numero",precision = 5)
    private Integer numero;

    @NotNull
    @Column(name = "codPostal")
    private Integer codigoPostal;

    @NotNull
    @Column(name = "localiadad")
    private String localidad;

    @Column(name = "numero_vivienda")
    private Integer numeroDpto;

    @Column(name = "piso_vivienda")
    private Integer pisoDpto;
}
