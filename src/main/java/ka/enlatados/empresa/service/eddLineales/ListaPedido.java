package ka.enlatados.empresa.service.eddLineales;
import ka.enlatados.empresa.entity.Pedido;
import ka.enlatados.empresa.entity.Caja;

import java.util.ArrayList;
import java.util.List;
public class ListaPedido {
    private Nodo inicio;
    private class Nodo {
        Pedido dato;
        Nodo sig;
        ListaCajaPedido cajas;
        Nodo(Pedido p) {
            dato = p;
            cajas = new ListaCajaPedido();
        }
    }
    public void agregar(Pedido p) {
        Nodo n = new Nodo(p);
        if (inicio == null) inicio = n;
        else {
            Nodo t = inicio;
            while (t.sig != null) t = t.sig;
            t.sig = n;
        }
    }
    public Iterable<Pedido> listar() {
        List<Pedido> lista = new ArrayList<>();
        Nodo t = inicio;
        while (t != null) {
            lista.add(t.dato);
            t = t.sig;
        }
        return lista;
    }
    public Nodo buscarNodo(String id) {
        Nodo t = inicio;
        while (t != null) {
            if (t.dato.getId().equals(id)) return t;
            t = t.sig;
        }
        return null;
    }
    public Pedido buscar(String id) {
        Nodo n = buscarNodo(id);
        return (n != null) ? n.dato : null;
    }
    public void agregarCaja(String id, Caja c) {
        Nodo n = buscarNodo(id);
        if (n != null) n.cajas.agregar(c);
    }
    public Iterable<Caja> listarCajas(String id) {
        Nodo n = buscarNodo(id);
        return (n != null) ? n.cajas.listar() : new ArrayList<>();
    }
    public void completar(String id) {
        Nodo n = buscarNodo(id);
        if (n != null) n.dato.setCompletado(true);
    }
}
