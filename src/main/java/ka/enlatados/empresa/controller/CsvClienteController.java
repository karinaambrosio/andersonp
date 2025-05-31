package ka.enlatados.empresa.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ka.enlatados.empresa.entity.Cliente;
import ka.enlatados.empresa.service.ClienteService;
import java.io.BufferedReader;
import java.io.InputStreamReader;
@RestController
@RequestMapping("/csv")
@CrossOrigin("*")
public class CsvClienteController {
    @Autowired
    private ClienteService clienteService;
    @PostMapping("/clientes")
    public String cargarClientesCSV(@RequestParam("archivo") MultipartFile archivo) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(archivo.getInputStream()))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                if (datos.length >= 4) {
                	Cliente cliente = new Cliente();
                	cliente.setDpi(datos[0]);
                	cliente.setNombre(datos[1]);
                	cliente.setApellidos(datos[2]);
                	cliente.setTelefono(datos[3]);
                	clienteService.agregar(cliente);
                }
            }
            return "Clientes cargados correctamente.";
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }
}
