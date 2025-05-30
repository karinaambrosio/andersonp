package ka.enlatados.empresa.datastructure;
import ka.enlatados.empresa.model.Usuario;
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
        if (inicio == null) inicio = nuevo;
        else {
            Nodo t = inicio;
            while (t.sig != null) t = t.sig;
            t.sig = nuevo;
        }
    }
    public Usuario buscar(String username) {
        Nodo t = inicio;
        while (t != null) {
            if (t.dato.getUsername().equals(username)) return t.dato;
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
