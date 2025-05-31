package ka.enlatados.empresa.controller;
import ka.enlatados.empresa.entity.Vehiculo;
import ka.enlatados.empresa.service.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.BufferedReader;
import java.io.InputStreamReader;
@RestController
@RequestMapping("/csv")
@CrossOrigin("*")
public class CsvVehiculoController {
    @Autowired
    private VehiculoService vehiculoService;
    @PostMapping("/vehiculos")
    public String cargarVehiculosCSV(@RequestParam("archivo") MultipartFile archivo) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(archivo.getInputStream()))) {
            String linea;
            boolean esPrimeraLinea = true;
            while ((linea = br.readLine()) != null) {
                if (esPrimeraLinea) {
                    esPrimeraLinea = false;
                    continue;
                }
                String[] datos = linea.split(";");
                if (datos.length >= 5) {
                    Vehiculo vehiculo = new Vehiculo();
                    vehiculo.setPlaca(datos[0]);
                    vehiculo.setMarca(datos[1]);
                    vehiculo.setModelo(datos[2]);
                    vehiculo.setColor(datos[3]);
                    vehiculo.setAnio(Integer.parseInt(datos[4]));
                }
            }
            return "Vehículos cargados correctamente.";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error al cargar vehículos: " + e.getMessage();
        }
    }
}
