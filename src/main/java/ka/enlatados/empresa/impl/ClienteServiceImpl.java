package ka.enlatados.empresa.impl;
import org.springframework.stereotype.Service;
import ka.enlatados.empresa.service.eddNoLineales.ArbolAVL;
import ka.enlatados.empresa.entity.Cliente;
import ka.enlatados.empresa.service.ClienteService;
@Service
public class ClienteServiceImpl implements ClienteService {
    private ArbolAVL arbol = new ArbolAVL();
    @Override
    public void agregar(Cliente c) { arbol.insertar(c); }
    @Override
    public Cliente buscar(String dpi) { return arbol.buscar(dpi); }
    @Override
    public Iterable<Cliente> listar() { return arbol.listarInOrden(); }
}
