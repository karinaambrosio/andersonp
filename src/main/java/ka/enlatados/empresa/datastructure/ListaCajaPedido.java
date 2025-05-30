package ka.enlatados.empresa.datastructure;
import ka.enlatados.empresa.model.Caja;
import java.util.ArrayList;
import java.util.List;
public class ListaCajaPedido {
    private Nodo inicio;
    private class Nodo {
        Caja dato;
        Nodo sig;
        Nodo(Caja c) { dato = c; }
    }
    public void agregar(Caja c) {
        Nodo n = new Nodo(c);
        if (inicio == null) inicio = n;
        else {
            Nodo t = inicio;
            while (t.sig != null) t = t.sig;
            t.sig = n;
        }
    }
    public Iterable<Caja> listar() {
        List<Caja> lista = new ArrayList<>();
        Nodo t = inicio;
        while (t != null) {
            lista.add(t.dato);
            t = t.sig;
        }
        return lista;
    }
}
