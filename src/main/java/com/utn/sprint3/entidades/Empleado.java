package com.utn.sprint3.entidades;

import com.utn.sprint3.Enumeraciones.Rol;
import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "empleado")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Empleado extends Persona{

    private Rol rol;

    @ManyToMany
    @JoinTable(
            name = "pedidos_empleados",
            joinColumns = @JoinColumn(name = "empleado_id"),
            inverseJoinColumns = @JoinColumn(name = "pedido_id")
    )
    @Builder.Default
    private Set<Pedido> pedidos = new HashSet<>();

    public void agregarPedidos(Pedido p) {
        pedidos.add(p);
    }

    @NotNull
    @OneToMany
    @JoinColumn(name = "id_empleado")
    // @Builder.Default
    private List<Domicilio> domicilios = new ArrayList<>();

    public void agregarDomicilios(Domicilio d) {
        domicilios.add(d);
    }
}
