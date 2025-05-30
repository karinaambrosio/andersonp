package ka.enlatados.empresa.datastructure;
import ka.enlatados.empresa.model.Repartidor;
import java.util.LinkedList;
import java.util.Queue;
public class ColaRepartidor {
    private Queue<Repartidor> cola = new LinkedList<>();
    public void encolar(Repartidor r) { cola.add(r); }
    public Repartidor desencolar() { return cola.poll(); }
    public Iterable<Repartidor> listar() { return cola; }
    public Repartidor buscar(String cui) {
        return cola.stream().filter(r -> r.getCui().equals(cui)).findFirst().orElse(null);
    }
}
