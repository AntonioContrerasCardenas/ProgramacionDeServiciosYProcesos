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
        this.estadoActual = Tasks.CONSTRUIRBASE;  // Inicialmente, todos los productos comienzan en la fase de construcción.
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
