package com.utn.sprint3.entidades;

import com.utn.sprint3.Enumeraciones.Rol;
import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

@Entity
@Table(name = "empleado")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Empleado extends Persona implements UserDetails {

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
