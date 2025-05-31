package ka.enlatados.empresa.controller;
import ka.enlatados.empresa.entity.Pedido;
import ka.enlatados.empresa.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
@RestController
@RequestMapping("/csv")
@CrossOrigin("*")
public class CsvPedidosController {
    @Autowired
    private PedidoService PedidoService;
    @PostMapping("/pedidos")
    public String cargarPedidosCSV(@RequestParam("archivo") MultipartFile archivo) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(archivo.getInputStream()))) {
            String linea;
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                if (datos.length >= 4) {
                    Pedido pedido = new Pedido();
                    pedido.setId(datos[0]);
                    pedido.setOrigen(datos[1]);
                    pedido.setDestino(datos[2]);
                    pedido.setFechaHora(LocalDateTime.parse(datos[3], formatter));
                    pedido.setRepartidor(null);
                    pedido.setCliente(null);
                    pedido.setVehiculo(null);
                    pedido.setCompletado(false);
                }
            }
            return "Pedidos cargados correctamente.";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error al cargar pedidos: " + e.getMessage();
        }
    }
}
