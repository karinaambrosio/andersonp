package ka.enlatados.empresa.impl;
import org.springframework.stereotype.Service;
import ka.enlatados.empresa.datastructure.ListaPedido;
import ka.enlatados.empresa.model.Caja;
import ka.enlatados.empresa.model.Pedido;
import ka.enlatados.empresa.service.PedidoService;
@Service
public class PedidoServiceImpl implements PedidoService {
    private ListaPedido lista = new ListaPedido();
    @Override
    public void agregar(Pedido p) { lista.agregar(p); }
    @Override
    public Iterable<Pedido> listar() { return lista.listar(); }
    @Override
    public Pedido buscar(String id) { return lista.buscar(id); }
    @Override
    public void agregarCaja(String pedidoId, Caja caja) {
        lista.agregarCaja(pedidoId, caja);
    }
    @Override
    public Iterable<Caja> listarCajas(String pedidoId) {
        return lista.listarCajas(pedidoId);
    }
    @Override
    public void completar(String pedidoId) {
        lista.completar(pedidoId);
    }
}
