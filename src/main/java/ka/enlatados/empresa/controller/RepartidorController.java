package ka.enlatados.empresa.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ka.enlatados.empresa.entity.Repartidor;
import ka.enlatados.empresa.service.RepartidorService;
@RestController
@RequestMapping("/api/repartidores")
@CrossOrigin("*")
public class RepartidorController {
    @Autowired private RepartidorService servicio;
    @PostMapping
    public void agregar(@RequestBody Repartidor r) { servicio.agregar(r); }
    @GetMapping
    public Iterable<Repartidor> listar() { return servicio.listar(); }
    @GetMapping("/{cui}")
    public Repartidor buscar(@PathVariable String cui) { return servicio.buscar(cui); }
}
