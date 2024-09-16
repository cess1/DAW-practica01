package pe.edu.cibertec.DAWII_TAREA_CESAR_CAMACHO.service;


import org.springframework.stereotype.Service;
import pe.edu.cibertec.DAWII_TAREA_CESAR_CAMACHO.controller.request.LoginRequest;
import pe.edu.cibertec.DAWII_TAREA_CESAR_CAMACHO.model.Usuario;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Service
public class UsuarioServicelmpl implements UsuarioService {

    @Override
    public Usuario verificarCredenciales(LoginRequest login) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                getClass().getClassLoader().getResourceAsStream("usuario.txt")))){
            String line;
            while ((line =reader.readLine()) !=null){
                String[] datos = line.split(";");
                if (datos.length ==4){
                    String tipoDocumento = datos[0];
                    String numeroDocumento = datos[1];
                    String password = datos[2];
                    String nombre = datos[3];

                    if (login.tipoDocumento().equals(tipoDocumento) &&
                            login.numeroDocumento().equals(numeroDocumento) &&
                            login.password().equals(password)) {

                        return new Usuario(nombre, password, numeroDocumento, tipoDocumento);

                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("e.getMessage() = " + e.getMessage());
        }
        return null;
    }
}
