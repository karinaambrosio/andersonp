package ka.enlatados.empresa.impl;
import org.springframework.stereotype.Service;
import ka.enlatados.empresa.datastructure.ColaRepartidor;
import ka.enlatados.empresa.model.Repartidor;
import ka.enlatados.empresa.service.RepartidorService;
@Service
public class RepartidorServiceImpl implements RepartidorService {
    private ColaRepartidor cola = new ColaRepartidor();
    @Override
    public void agregar(Repartidor r) { cola.encolar(r); }
    @Override
    public Iterable<Repartidor> listar() { return cola.listar(); }
    @Override
    public Repartidor buscar(String cui) { return cola.buscar(cui); }
}
