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
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UsuarioRepository usuarioRepository;
    private final DomicilioRepository domicilioRepository;
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


        Domicilio domicilio = new Domicilio();

        domicilio.setCalle(request.getCalle());
        domicilio.setNumero(request.getNumero());
        domicilio.setCodigoPostal(request.getCodigoPostal());
        domicilio.setLocalidad(request.getLocalidad());
        domicilio.setDepartamento(request.getDepartamento());
        domicilio.setNumeroVivienda(request.getNumeroVivienda());
        domicilio.setPisoDto(request.getPisoDto());



        domicilioRepository.save(domicilio);


        Usuario user = new Usuario();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setNombre(request.getNombre());
        user.setApellido(request.getApellido());
        user.setEmail(request.getEmail());
        user.setTelefono(request.getTelefono());
        user.setRol(Rol.CLIENTE);


        user.setDomicilio(domicilio);


        usuarioRepository.save(user);

        return AuthResponse.builder()
                .token(jwtService.getToken(user))
                .build();
    }



    public AuthResponse crearEmpleado(RegisterRequest request) {

        Domicilio domicilio = new Domicilio();

        domicilio.setCalle(request.getCalle());
        domicilio.setNumero(request.getNumero());
        domicilio.setCodigoPostal(request.getCodigoPostal());
        domicilio.setLocalidad(request.getLocalidad());
        domicilio.setDepartamento(request.getDepartamento());
        domicilio.setNumeroVivienda(request.getNumeroVivienda());
        domicilio.setPisoDto(request.getPisoDto());


        domicilioRepository.save(domicilio);


        Usuario empleado = new Usuario();
        empleado.setUsername(request.getUsername());
        empleado.setPassword(passwordEncoder.encode(request.getPassword()));
        empleado.setNombre(request.getNombre());
        empleado.setApellido(request.getApellido());
        empleado.setEmail(request.getEmail());
        empleado.setTelefono(request.getTelefono());
        empleado.setRol(request.getRol());

        empleado.setDomicilio(domicilio);

         usuarioRepository.save(empleado);

        return AuthResponse.builder()
                .token(jwtService.getToken(empleado))
                .build();
    }

    public AuthResponse actualizarEmpleado(RegisterRequest request, Long empleadoId) {
        // Obtener el empleado existente desde la base de datos
        Optional<Usuario> optionalEmpleado = usuarioRepository.findById(empleadoId);

        if (optionalEmpleado.isPresent()) {
            Usuario empleado = optionalEmpleado.get();

            // Actualizar los campos del empleado con la información proporcionada en la solicitud
            empleado.setUsername(request.getUsername());
            empleado.setNombre(request.getNombre());
            empleado.setApellido(request.getApellido());
            empleado.setEmail(request.getEmail());
            empleado.setTelefono(request.getTelefono());
            empleado.setRol(request.getRol());

            // Obtener el domicilio asociado al empleado
            Domicilio domicilio = empleado.getDomicilio();

            // Actualizar los campos del domicilio con la información proporcionada en la solicitud
            domicilio.setCalle(request.getCalle());
            domicilio.setNumero(request.getNumero());
            domicilio.setCodigoPostal(request.getCodigoPostal());
            domicilio.setLocalidad(request.getLocalidad());
            domicilio.setDepartamento(request.getDepartamento());
            domicilio.setNumeroVivienda(request.getNumeroVivienda());
            domicilio.setPisoDto(request.getPisoDto());


            // Guardar los cambios en la base de datos
            domicilioRepository.save(domicilio);

            empleado.setDomicilio(domicilio);

            usuarioRepository.save(empleado);

            return AuthResponse.builder()
                    .token(jwtService.getToken(empleado))
                    .build();
        } else {
            // Manejar el caso en que no se encuentre el empleado con el ID proporcionado
            throw new UsernameNotFoundException("Empleado no encontrado con ID: " + empleadoId);
        }
    }



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

