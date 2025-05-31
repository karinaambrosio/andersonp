package ka.enlatados.empresa.controller;
import ka.enlatados.empresa.entity.Repartidor;
import ka.enlatados.empresa.service.RepartidorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.BufferedReader;
import java.io.InputStreamReader;
@RestController
@RequestMapping("/csv")
@CrossOrigin("*")
public class CsvRepartidorController {
    @Autowired
    private RepartidorService repartidorervice;
    @PostMapping("/repartidores")
    public String cargarRepartidoresCSV(@RequestParam("archivo") MultipartFile archivo) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(archivo.getInputStream()))) {
            String linea;
            boolean primera = true;
            while ((linea = br.readLine()) != null) {
                if (primera) {
                    primera = false; 
                    continue;
                }
                String[] datos = linea.split(";");
                if (datos.length >= 5) {
                    Repartidor repartidor = new Repartidor();
                    repartidor.setCui(datos[0]);
                    repartidor.setNombre(datos[1]);
                    repartidor.setApellidos(datos[2]);
                    repartidor.setLicencia(datos[3]);
                    repartidor.setTelefono(datos[4]);
                }
            }
            return "Repartidores cargados correctamente.";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error al cargar repartidores: " + e.getMessage();
        }
    }
}
