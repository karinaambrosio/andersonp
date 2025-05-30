package ka.enlatados.empresa.impl;
import org.springframework.stereotype.Service;
import ka.enlatados.empresa.service.eddLineales.PilaCaja;
import ka.enlatados.empresa.entity.Caja;
import ka.enlatados.empresa.service.AlmacenService;
@Service
public class AlmacenServiceImpl implements AlmacenService {
    private PilaCaja pila = new PilaCaja();
    @Override
    public void ingresarCaja(Caja c) { pila.push(c); }
    @Override
    public Caja retirarCaja() { return pila.pop(); }
    @Override
    public Iterable<Caja> listar() { return pila.listar(); }
}
