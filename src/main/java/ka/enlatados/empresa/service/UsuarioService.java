package ka.enlatados.empresa.service;
import ka.enlatados.empresa.entity.Usuario;
public interface UsuarioService {
    void agregar(Usuario u);
    Usuario buscar(Long id);
    Iterable<Usuario> listar();
}
