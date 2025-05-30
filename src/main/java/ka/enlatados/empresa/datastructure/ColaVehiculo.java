package ka.enlatados.empresa.datastructure;
import ka.enlatados.empresa.model.Vehiculo;
import java.util.LinkedList;
import java.util.Queue;
public class ColaVehiculo {
    private Queue<Vehiculo> cola = new LinkedList<>();
    public void encolar(Vehiculo v) { cola.add(v); }
    public Vehiculo desencolar() { return cola.poll(); }
    public Iterable<Vehiculo> listar() { return cola; }
    public Vehiculo buscar(String placa) {
        return cola.stream().filter(v -> v.getPlaca().equals(placa)).findFirst().orElse(null);
    }
}
