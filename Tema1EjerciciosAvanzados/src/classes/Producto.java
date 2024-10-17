package classes;

public class Producto {
    private String nombre;
    private String estado;

    public Producto(String nombre){
        this.nombre = nombre;
        this.estado = "";
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }
}
