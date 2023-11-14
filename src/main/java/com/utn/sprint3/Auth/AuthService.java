package com.utn.sprint3.Auth;


import com.utn.sprint3.Enumeraciones.Rol;
import com.utn.sprint3.Jwt.JwtService;
import com.utn.sprint3.entidades.Domicilio;
import com.utn.sprint3.entidades.Usuario;
import com.utn.sprint3.repositorios.*;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UsuarioRepository usuarioRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        UserDetails user = usuarioRepository.findByUsername(request.getUsername()).orElseThrow();
        String token = jwtService.getToken(user);
        return AuthResponse.builder()
                .token(token)
                .build();
    }

    public AuthResponse register(RegisterRequest request) {
        Usuario user = new Usuario();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setNombre(request.getNombre());
        user.setApellido(request.getApellido());
        user.setEmail(request.getEmail());
        user.setTelefono(request.getTelefono());
        user.setRol(Rol.CLIENTE);



      /*  List<Domicilio> domicilios = new ArrayList<>();*/
     /*   Domicilio domicilio = new Domicilio();
        domicilio.setCalle(request.getCalle());
        domicilio.setNumero(request.getNumero());
     /*   domicilios.add(domicilio);

        user.setDomicilios(domicilios);*/



        usuarioRepository.save(user);

        return AuthResponse.builder()
                .token(jwtService.getToken(user))
                .build();
    }


    public AuthResponse crearEmpleado(RegisterRequest request) {
        Usuario empleado = new Usuario();
        empleado.setUsername(request.getUsername());
        empleado.setPassword(passwordEncoder.encode(request.getPassword()));
        empleado.setNombre(request.getNombre());
        empleado.setApellido(request.getApellido());
        empleado.setEmail(request.getEmail());
        empleado.setTelefono(request.getTelefono());
      //  empleado.setFechaNacimiento(request.getFechaNacimiento());
        empleado.setRol(request.getRol());

        // Guarda el nuevo usuario en la base de datos
         usuarioRepository.save(empleado);

        return AuthResponse.builder()
                .token(jwtService.getToken(empleado))
                .build();
    }

    // Método para generar automáticamente al administrador si no existe
    @PostConstruct
    public void inicializar() {
        if (!usuarioRepository.existsByUsername("admin")) {
            Usuario admin = new Usuario();
            admin.setUsername("admin");
            admin.setPassword(passwordEncoder.encode("contraseñaAdmin"));
            admin.setRol(Rol.ADMINISTRADOR);

            usuarioRepository.save(admin);
        }
    }
}

