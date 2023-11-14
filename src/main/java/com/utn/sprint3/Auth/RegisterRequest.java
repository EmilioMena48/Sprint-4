package com.utn.sprint3.Auth;

import com.utn.sprint3.Enumeraciones.Rol;
import com.utn.sprint3.entidades.Domicilio;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
    String username;
    String password;
    String nombre;
    String apellido;
    String telefono;
    String email;
    Rol rol;
  /*  String calle;
    Integer numero;*/
   // List<Domicilio> domicilios;
}
