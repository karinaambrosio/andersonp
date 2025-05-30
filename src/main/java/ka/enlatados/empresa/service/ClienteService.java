package ka.enlatados.empresa.service;
import ka.enlatados.empresa.entity.Cliente;
public interface ClienteService {
    void agregar(Cliente c);
    Cliente buscar(String dpi);
    Iterable<Cliente> listar();
}
