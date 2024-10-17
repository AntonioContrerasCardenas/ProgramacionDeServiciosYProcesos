package classes;

public class Producto {
    private String nombre;
    private String estado;
    private boolean baseConstruida = false;
    private boolean ensamble = false;
    private boolean empaquetado = false;

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

    public boolean isEnsamble() {
        return ensamble;
    }

    public void setEnsamble(boolean ensamble) {
        this.ensamble = ensamble;
    }

    public boolean isBaseConstruida() {
        return baseConstruida;
    }

    public void setBaseConstruida(boolean baseConstruida) {
        this.baseConstruida = baseConstruida;
    }

    public boolean isEmpaquetado() {
        return empaquetado;
    }

    public void setEmpaquetado(boolean empaquetado) {
        this.empaquetado = empaquetado;
    }
}
