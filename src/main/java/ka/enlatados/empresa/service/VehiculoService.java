package ka.enlatados.empresa.service;
import ka.enlatados.empresa.model.Vehiculo;
public interface VehiculoService {
    void agregar(Vehiculo v);
    Iterable<Vehiculo> listar();
    Vehiculo buscar(String placa);
}
