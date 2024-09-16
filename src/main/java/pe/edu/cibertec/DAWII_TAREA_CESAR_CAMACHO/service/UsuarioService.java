package pe.edu.cibertec.DAWII_TAREA_CESAR_CAMACHO.service;

import pe.edu.cibertec.DAWII_TAREA_CESAR_CAMACHO.controller.request.LoginRequest;
import pe.edu.cibertec.DAWII_TAREA_CESAR_CAMACHO.model.Usuario;

public interface UsuarioService {

    Usuario verificarCredenciales(LoginRequest login);
}
