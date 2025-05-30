package ka.enlatados.empresa.service.eddLineales;
import ka.enlatados.empresa.entity.Caja;
import java.util.Stack;
public class PilaCaja {
    private Stack<Caja> pila = new Stack<>();
    public void push(Caja c) { pila.push(c); }
    public Caja pop() { return pila.isEmpty()? null : pila.pop(); }
    public Iterable<Caja> listar() { return pila; }
}
