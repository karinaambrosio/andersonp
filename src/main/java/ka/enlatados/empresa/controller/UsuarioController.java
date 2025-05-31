package ka.enlatados.empresa.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ka.enlatados.empresa.entity.Usuario;
import ka.enlatados.empresa.service.UsuarioService;
@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin("*")
public class UsuarioController {
    @Autowired
    private UsuarioService servicio;
    @PostMapping
    public void agregar(@RequestBody Usuario u) {
        servicio.agregar(u);
    }
    @GetMapping
    public Iterable<Usuario> listar() {
        return servicio.listar();
    }
    @GetMapping("/{id}")
    public Usuario buscar(@PathVariable Long id) {
        return servicio.buscar(id);
    }
}
