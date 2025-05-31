package ka.enlatados.empresa.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.BufferedReader;
import java.io.InputStreamReader;
@RestController
@RequestMapping("/csv")
public class CargaCsvController {
    @PostMapping("/cargar")
    public ResponseEntity<String> cargarCsv(@RequestParam("archivo") MultipartFile archivo) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(archivo.getInputStream()))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println("Línea leída: " + linea);
            }
            return ResponseEntity.ok("Archivo cargado correctamente");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al cargar archivo: " + e.getMessage());
        }
    }
}
