package com.utn.sprint3.entidades;

import com.utn.sprint3.Enumeraciones.Rol;
import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Data

@Entity
@Table(name = "cliente")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Usuario extends Persona implements UserDetails {


    @Column(name = "rol")
    public Rol rol;

    @Column(name = "nombre")
    protected String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "fecha_nac")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaNacimiento;

    @NotNull
    @Column(name = "username", nullable = false)
    private String username;


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


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority((rol.name())));
    }
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override
    public boolean isEnabled() {
        return true;
    }

}
