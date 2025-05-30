package ka.enlatados.empresa.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ka.enlatados.empresa.model.Cliente;
import ka.enlatados.empresa.service.ClienteService;
@RestController
@RequestMapping("/api/clientes")
@CrossOrigin("*")
public class ClienteController {
    @Autowired private ClienteService servicio;
    @PostMapping
    public void agregar(@RequestBody Cliente c) { servicio.agregar(c); }
    @GetMapping
    public Iterable<Cliente> listar() { return servicio.listar(); }
    @GetMapping("/{dpi}")
    public Cliente buscar(@PathVariable String dpi) { return servicio.buscar(dpi); }
}
