package ka.enlatados.empresa.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ka.enlatados.empresa.model.Vehiculo;
import ka.enlatados.empresa.service.VehiculoService;
@RestController
@RequestMapping("/api/vehiculos")
@CrossOrigin("*")
public class VehiculoController {
    @Autowired private VehiculoService servicio;
    @PostMapping
    public void agregar(@RequestBody Vehiculo v) { servicio.agregar(v); }
    @GetMapping
    public Iterable<Vehiculo> listar() { return servicio.listar(); }
    @GetMapping("/{placa}")
    public Vehiculo buscar(@PathVariable String placa) { return servicio.buscar(placa); }
}
