package com.utn.sprint3.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.Date;

@Entity
@Table(name = "unidad_medida")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UnidadMedida extends Fecha {

    @NotNull
    @Column(name = "denominacion", length = 255)
    private String denominacion;

    @NotNull
    @Column(name = "abreviatura", length = 25)
    private String abreviatura;
}