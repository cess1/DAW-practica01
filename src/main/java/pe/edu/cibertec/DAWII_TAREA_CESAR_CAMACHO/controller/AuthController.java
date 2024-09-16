package pe.edu.cibertec.DAWII_TAREA_CESAR_CAMACHO.controller;


import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.cibertec.DAWII_TAREA_CESAR_CAMACHO.controller.request.LoginRequest;
import pe.edu.cibertec.DAWII_TAREA_CESAR_CAMACHO.controller.response.LoginResponse;
import pe.edu.cibertec.DAWII_TAREA_CESAR_CAMACHO.model.Usuario;
import pe.edu.cibertec.DAWII_TAREA_CESAR_CAMACHO.service.UsuarioServicelmpl;

@RestController
@RequiredArgsConstructor
@RequestMapping("/login")
public class AuthController {

    private final UsuarioServicelmpl usuariService;

    @PostMapping("/user")
    public ResponseEntity<LoginResponse> loginUsuario(@RequestBody LoginRequest loginRequest) {
        if (loginRequest.numeroDocumento().isBlank() ||
                loginRequest.password().isBlank() ||
                loginRequest.tipoDocumento().isBlank()) {
            LoginResponse response = new LoginResponse("01", "Campos incompletos", null);
            return ResponseEntity.status(401).body(response);
        }

        Usuario usuario = usuariService.verificarCredenciales(loginRequest);
        if (usuario != null) {
            LoginResponse response = new LoginResponse("00", "", usuario.getNombre());
            return ResponseEntity.ok(response);
        } else {
            LoginResponse response = new LoginResponse("02", "Error:Sus Credenciales no son correctas", null);
            return ResponseEntity.status(401).body(response);
        }

    }

}
