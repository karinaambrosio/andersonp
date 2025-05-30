package ka.enlatados.empresa.service.eddNoLineales;
import ka.enlatados.empresa.entity.Cliente;
import java.util.ArrayList;
import java.util.List;
public class ArbolAVL {
    private class Nodo {
        Cliente dato;
        Nodo izq, der;
        int altura;
        Nodo(Cliente c) {
            dato = c;
            altura = 1;
        }
    }
    private Nodo raiz;
    public void insertar(Cliente c) {
        raiz = insertar(raiz, c);
    }
    private Nodo insertar(Nodo n, Cliente c) {
        if (n == null) return new Nodo(c);
        if (c.getDpi().compareTo(n.dato.getDpi()) < 0)
            n.izq = insertar(n.izq, c);
        else
            n.der = insertar(n.der, c);
         return n;
    }

    public Cliente buscar(String dpi) {
        Nodo actual = raiz;
        while (actual != null) {
            if (dpi.equals(actual.dato.getDpi()))
                return actual.dato;
            else if (dpi.compareTo(actual.dato.getDpi()) < 0)
                actual = actual.izq;
            else
                actual = actual.der;
        }
        return null;
    }
    public Iterable<Cliente> listarInOrden() {
        List<Cliente> lista = new ArrayList<>();
        inOrden(raiz, lista);
        return lista;
    }
    private void inOrden(Nodo n, List<Cliente> lista) {
        if (n != null) {
            inOrden(n.izq, lista);
            lista.add(n.dato);
            inOrden(n.der, lista);
        }
    }
}
