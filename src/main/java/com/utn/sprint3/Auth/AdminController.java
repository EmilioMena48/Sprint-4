package com.utn.sprint3.Auth;

import com.utn.sprint3.Enumeraciones.Rol;
import com.utn.sprint3.entidades.Empleado;
import com.utn.sprint3.services.EmpleadoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
//@PreAuthorize("hasAuthority('ADMINISTRADOR')")
public class AdminController {

    private final AuthService authService;

    @PostMapping("/crearEmpleado")
    public ResponseEntity<AuthResponse> crearEmpleado(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authService.crearEmpleado(request));
    }

}
