package pe.edu.cibertec.DAWII_TAREA_CESAR_CAMACHO.controller.request;

public record LoginRequest(
        String tipoDocumento,
        String numeroDocumento,
        String password
) {
}
