package ka.enlatados.empresa.impl;
import org.springframework.stereotype.Service;
import ka.enlatados.empresa.datastructure.ListaUsuario;
import ka.enlatados.empresa.model.Usuario;
import ka.enlatados.empresa.service.UsuarioService;
@Service
public class UsuarioServiceImpl implements UsuarioService {
    private ListaUsuario lista = new ListaUsuario();
    @Override
    public void agregar(Usuario u) {
        lista.agregar(u);
    }
    @Override
    public Usuario buscar(String username) {
        return lista.buscar(username);
    }
    @Override
    public Iterable<Usuario> listar() {
        return lista.listar();
    }
}
