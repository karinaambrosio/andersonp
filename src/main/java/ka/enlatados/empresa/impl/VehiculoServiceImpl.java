package ka.enlatados.empresa.impl;
import org.springframework.stereotype.Service;
import ka.enlatados.empresa.datastructure.ColaVehiculo;
import ka.enlatados.empresa.model.Vehiculo;
import ka.enlatados.empresa.service.VehiculoService;
@Service
public class VehiculoServiceImpl implements VehiculoService {
    private ColaVehiculo cola = new ColaVehiculo();
    @Override
    public void agregar(Vehiculo v) { cola.encolar(v); }
    @Override
    public Iterable<Vehiculo> listar() { return cola.listar(); }
    @Override
    public Vehiculo buscar(String placa) { return cola.buscar(placa); }
}
