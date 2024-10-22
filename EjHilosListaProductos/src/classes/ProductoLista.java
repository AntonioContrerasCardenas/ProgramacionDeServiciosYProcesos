package classes;

import enums.Tasks;

public class ProductoLista {
    private String nombre;
    private boolean baseConstruida;
    private boolean ensamble;
    private boolean empaquetado;
    private Tasks estadoActual;
    private StringBuilder cadena;

    public ProductoLista(String nombre) {
        this.nombre = nombre;
        this.estadoActual = Tasks.CONSTRUIRBASE;
        this.cadena = new StringBuilder();
        this.cadena.append(nombre).append(": ");
    }

    public void setProducto(String cadena){
        this.cadena.append("...").append(cadena);
    }

    public StringBuilder getCadena() {
        return cadena;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isBaseConstruida() {
        return baseConstruida;
    }

    public void setBaseConstruida(boolean baseConstruida) {
        this.baseConstruida = baseConstruida;
    }

    public boolean isEnsamble() {
        return ensamble;
    }

    public void setEnsamble(boolean ensamble) {
        this.ensamble = ensamble;
    }

    public boolean isEmpaquetado() {
        return empaquetado;
    }

    public void setEmpaquetado(boolean empaquetado) {
        this.empaquetado = empaquetado;
    }

    public Tasks getEstadoActual() {
        return estadoActual;
    }

    public void setEstadoActual(Tasks estadoActual) {
        this.estadoActual = estadoActual;
    }
}
