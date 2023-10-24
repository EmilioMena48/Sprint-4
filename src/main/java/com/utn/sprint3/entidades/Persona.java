package com.utn.sprint3.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.OneToMany;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.ArrayList;
import java.util.List;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Persona extends Fecha{

    private String nombre;

    private String apellido;

    private String telefono;

    private String email;

    @NotNull
    @Column(name = "username", nullable = false)
    private String username;




}
