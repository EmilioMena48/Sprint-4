package com.utn.sprint3.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

import java.math.BigDecimal;
import java.util.Collection;

@Entity
@Table(name = "articulo_insumo")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class ArticuloInsumo extends Fecha{

    @NotNull
    @Column(name = "denominacion")
    private String denominacion;

    @Column(name = "url_imagen")
    private String urlImagen;

    @NotNull
    @Column(name = "precio_compra", precision = 10, scale = 2)
    private BigDecimal precioCompra;

    @NotNull
    @Column(name = "stock_actual", precision = 10, scale = 2)
    private BigDecimal stockActual;

    @NotNull
    @Column(name = "stock_minimo", precision = 10, scale = 2)
    private BigDecimal stockMinimo;

    @NotNull
    @ManyToOne()
    @JoinColumn(name = "id_unidad_medida")
    private UnidadMedida unidadMedida;

    @NotNull
    @ManyToOne()
    @JoinColumn(name = "id_rubro_articulo")
    private RubroArticulo rubroArticulo;


    @ManyToMany(mappedBy = "ArticuloInsumo")
    private Collection<EstadisticaMonetaria> estadisticaMonetarias;

    public Collection<EstadisticaMonetaria> getEstadisticaMonetarias() {
        return estadisticaMonetarias;
    }

    public void setEstadisticaMonetarias(Collection<EstadisticaMonetaria> estadisticaMonetarias) {
        this.estadisticaMonetarias = estadisticaMonetarias;
    }
}
