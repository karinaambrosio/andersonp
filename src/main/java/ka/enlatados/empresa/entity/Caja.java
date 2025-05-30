package ka.enlatados.empresa.entity;
import java.time.LocalDateTime;
public class Caja {
    private String correlativo;
    private LocalDateTime fechaIngreso;
    public String getCorrelativo() { return correlativo; }
    public void setCorrelativo(String correlativo) { this.correlativo = correlativo; }
    public LocalDateTime getFechaIngreso() { return fechaIngreso; }
    public void setFechaIngreso(LocalDateTime fechaIngreso) { this.fechaIngreso = fechaIngreso; }
}
