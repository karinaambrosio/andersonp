package ka.enlatados.empresa.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ka.enlatados.empresa.model.Caja;
import ka.enlatados.empresa.service.AlmacenService;
@RestController
@RequestMapping("/api/almacen")
@CrossOrigin("*")
public class AlmacenController {
    @Autowired private AlmacenService servicio;
    @PostMapping("/ingresar")
    public void ingresar(@RequestBody Caja c) { servicio.ingresarCaja(c); }
    @PostMapping("/retirar")
    public Caja retirar() { return servicio.retirarCaja(); }
    @GetMapping
    public Iterable<Caja> listar() { return servicio.listar(); }
}
