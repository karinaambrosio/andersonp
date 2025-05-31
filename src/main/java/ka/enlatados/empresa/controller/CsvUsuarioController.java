package ka.enlatados.empresa.controller;
import ka.enlatados.empresa.entity.Usuario;
import ka.enlatados.empresa.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.BufferedReader;
import java.io.InputStreamReader;
@RestController
@RequestMapping("/csv")
@CrossOrigin("*")
public class CsvUsuarioController {
    @Autowired
    private UsuarioService usuarioService;
    @PostMapping("/usuarios")
    public String cargarUsuariosCSV(@RequestParam("archivo") MultipartFile archivo) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(archivo.getInputStream()))) {
            String linea;
            boolean esPrimeraLinea = true;
            while ((linea = br.readLine()) != null) {
                if (esPrimeraLinea) {
                    esPrimeraLinea = false;
                    continue;
                }
                String[] datos = linea.split(";");
                if (datos.length >= 4) {
                    Usuario usuario = new Usuario();
                    usuario.setId(Long.parseLong(datos[0]));
                    usuario.setNombre(datos[1]);
                    usuario.setApellido(datos[2]);
                    usuario.setContrasena(datos[3]);
                }
            }
            return "Usuarios cargados correctamente.";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error al cargar usuarios: " + e.getMessage();
        }
    }
}
