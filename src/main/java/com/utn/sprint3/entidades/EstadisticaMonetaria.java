package com.utn.sprint3.entidades;

import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Estadistica_Monetaria")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EstadisticaMonetaria extends Base {

    @NotNull
    private Integer Ganancias;

    @NotNull
    private Date Fecha_Inicio;

    @NotNull
    private Date Fecha_Fin;



    @JoinTable(
            name = "EstadisticaMonetariaFactura",
            joinColumns = @JoinColumn(name = "FK_EstadisticaMonetaria", nullable = false),
            inverseJoinColumns = @JoinColumn(name="FK_Factura", nullable = false)
    )
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Factura> Factura = new HashSet<>();
    @JoinTable(
            name = "EstadisticaMonetariaArticuloInsumo",
            joinColumns = @JoinColumn(name = "FK_EstadisticaMonetaria", nullable = false),
            inverseJoinColumns = @JoinColumn(name="FK_ArticuloInsumo", nullable = false)
    )
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<ArticuloInsumo> ArticuloInsumo = new HashSet<>();
}
