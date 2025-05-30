package ka.enlatados.empresa.impl;

import org.springframework.stereotype.Service;
import ka.enlatados.empresa.service.eddLineales.ListaUsuario;
import ka.enlatados.empresa.entity.Usuario;
import ka.enlatados.empresa.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    private ListaUsuario lista = new ListaUsuario();

    @Override
    public void agregar(Usuario u) {
        lista.agregar(u);
    }

    @Override
    public Usuario buscar(Long id) {
        return lista.buscar(id);
    }

    @Override
    public Iterable<Usuario> listar() {
        return lista.listar();
    }
}
