package com.utn.sprint3.entidades;

import com.utn.sprint3.Enumeraciones.Rol;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UsuarioDTO implements Serializable {

    Long id;
    String username;
    String password;
    String nombre;
    String apellido;
    String telefono;
    String email;
  //  Date fechaNacimiento;
    Rol rol;
}
