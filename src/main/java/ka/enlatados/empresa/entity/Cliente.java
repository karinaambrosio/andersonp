package ka.enlatados.empresa.entity;
public class Cliente {
    private String dpi;
    private String nombre;
    private String apellidos;
    private String telefono;
    public Cliente() {}
    public Cliente(String dpi, String nombre, String apellidos, String telefono) {
        this.dpi = dpi;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
    }
    public String getDpi() { return dpi; }
    public void setDpi(String dpi) { this.dpi = dpi; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
}
