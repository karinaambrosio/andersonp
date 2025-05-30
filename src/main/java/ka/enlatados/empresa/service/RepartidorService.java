package ka.enlatados.empresa.service;
import ka.enlatados.empresa.entity.Repartidor;
public interface RepartidorService {
    void agregar(Repartidor r);
    Iterable<Repartidor> listar();
    Repartidor buscar(String cui);
}
