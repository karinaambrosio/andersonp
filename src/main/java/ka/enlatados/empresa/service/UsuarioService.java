package ka.enlatados.empresa.service;
import ka.enlatados.empresa.model.Usuario;
public interface UsuarioService {
    void agregar(Usuario u);
    Usuario buscar(String username);
    Iterable<Usuario> listar();
}
