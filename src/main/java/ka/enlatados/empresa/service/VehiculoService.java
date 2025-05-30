package ka.enlatados.empresa.service;
import ka.enlatados.empresa.entity.Vehiculo;
public interface VehiculoService {
    void agregar(Vehiculo v);
    Iterable<Vehiculo> listar();
    Vehiculo buscar(String placa);
}
