package ka.enlatados.empresa.service;
import ka.enlatados.empresa.model.Caja;
import ka.enlatados.empresa.model.Pedido;
public interface PedidoService {
    void agregar(Pedido p);
    Iterable<Pedido> listar();
    Pedido buscar(String id);
    void agregarCaja(String pedidoId, Caja caja);
    Iterable<Caja> listarCajas(String pedidoId);
    void completar(String pedidoId);
}
