package ka.enlatados.empresa.service;
import ka.enlatados.empresa.model.Caja;
public interface AlmacenService {
    void ingresarCaja(Caja c);
    Caja retirarCaja();
    Iterable<Caja> listar();
}
