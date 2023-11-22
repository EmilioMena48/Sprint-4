package com.utn.sprint3.entidades;

import com.utn.sprint3.Enumeraciones.Rol;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class EmpleadoDTO implements Serializable {

    Date fechaAlta;
    Long id;
    String username;
    String nombre;
    String apellido;
    String telefono;
    String email;
    Rol rol;
    DomicilioDTO domicilio;
}
