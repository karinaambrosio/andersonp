package ka.enlatados.empresa.service.eddLineales;

import ka.enlatados.empresa.entity.Usuario;
import java.util.ArrayList;
import java.util.List;

public class ListaUsuario {
    private Nodo inicio;

    private class Nodo {
        Usuario dato;
        Nodo sig;
        Nodo(Usuario u) { dato = u; }
    }

    public void agregar(Usuario u) {
        Nodo nuevo = new Nodo(u);
        if (inicio == null) {
            inicio = nuevo;
        } else {
            Nodo t = inicio;
            while (t.sig != null) {
                t = t.sig;
            }
            t.sig = nuevo;
        }
    }

    public Usuario buscar(Long id) {
        Nodo t = inicio;
        while (t != null) {
            if (t.dato.getId().equals(id)) {
                return t.dato;
            }
            t = t.sig;
        }
        return null;
    }

    public Iterable<Usuario> listar() {
        List<Usuario> lista = new ArrayList<>();
        Nodo t = inicio;
        while (t != null) {
            lista.add(t.dato);
            t = t.sig;
        }
        return lista;
    }
}
