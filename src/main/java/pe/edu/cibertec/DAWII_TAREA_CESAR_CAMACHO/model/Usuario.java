package pe.edu.cibertec.DAWII_TAREA_CESAR_CAMACHO.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    private String nombre;
    private String password;
    private String numeroDocumento;
    private String tipoDocumento;
}
