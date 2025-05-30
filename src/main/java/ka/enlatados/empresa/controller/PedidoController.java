package ka.enlatados.empresa.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ka.enlatados.empresa.entity.Caja;
import ka.enlatados.empresa.entity.Pedido;
import ka.enlatados.empresa.service.PedidoService;
@RestController
@RequestMapping("/api/pedidos")
@CrossOrigin("*")
public class PedidoController {
    @Autowired private PedidoService servicio;
    @PostMapping
    public void agregar(@RequestBody Pedido p) { servicio.agregar(p); }
    @GetMapping
    public Iterable<Pedido> listar() { return servicio.listar(); }
    @GetMapping("/{id}")
    public Pedido buscar(@PathVariable String id) { return servicio.buscar(id); }
    @PostMapping("/{id}/cajas")
    public void agregarCaja(@PathVariable String id, @RequestBody Caja c) {
        servicio.agregarCaja(id, c);
    }
    @GetMapping("/{id}/cajas")
    public Iterable<Caja> listarCajas(@PathVariable String id) {
        return servicio.listarCajas(id);
    }
    @PostMapping("/{id}/completar")
    public void completar(@PathVariable String id) {
        servicio.completar(id);
    }
}
