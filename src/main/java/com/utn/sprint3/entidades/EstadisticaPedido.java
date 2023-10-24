package com.utn.sprint3.entidades;


import ch.qos.logback.core.net.server.Client;
import com.utn.sprint3.entidades.Pedido;
import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Estadistica_Pedido")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EstadisticaPedido extends Base {

    @NotNull
    private Integer CantidadPedidos;

    @NotNull
    private Integer importeTotal;

    @NotNull
    private Date Fecha_Inicio;

    @NotNull
    private Date Fecha_Fin;

    @NonNull
    @JoinTable(
            name = "EstadisticaPedidoCliente",
            joinColumns = @JoinColumn(name = "FK_EstadisticaPedido", nullable = false),
            inverseJoinColumns = @JoinColumn(name="FK_Cliente", nullable = false)
    )
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Cliente> Cliente = new HashSet<>();

}
