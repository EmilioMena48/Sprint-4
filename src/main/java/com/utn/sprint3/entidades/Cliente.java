package com.utn.sprint3.entidades;

import com.utn.sprint3.Enumeraciones.Rol;
import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cliente")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Cliente extends Persona{

    private Rol rol;


    @OneToMany
    @JoinColumn(name = "cliente_id")
   // @Builder.Default
    private List<Pedido> pedidos = new ArrayList<>();

    public void agregarPedidos(Pedido p) {
        pedidos.add(p);
    }

    @NotNull
    @OneToMany
    @JoinColumn(name = "id_cliente")
    // @Builder.Default
    private List<Domicilio> domicilios = new ArrayList<>();

    public void agregarDomicilios(Domicilio d) {
        domicilios.add(d);
    }

    public void mostrarDomicilios(){
        System.out.println("Domicilios de " + getNombre() + " " + getApellido() + ":");
        int counter = 0;
        for (Domicilio domicilio : domicilios) {
            counter += 1;
            System.out.println("\nDomicilio "+counter+"\n\tCalle: " + domicilio.getCalle() + ", Número: " + domicilio.getNumero());
        }
        System.out.println("----------------------------------------");
    }

    public void mostrarPedidos() {
        System.out.println("Pedidos de " + getNombre() + " " + getApellido() + ":");
        int counter1 = 0;
        for (Pedido pedido : pedidos) {
            counter1 += 1;
            System.out.println("\nPedido "+counter1+"\nFecha: " + pedido.getFechaPedido() + "Total: " + pedido.getTotal());
        }
        System.out.println("----------------------------------------");
    }


}
