package classes;

import enums.Tasks;

public class ProductoLista {
    private String nombre;
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


    public Tasks getEstadoActual() {
        return estadoActual;
    }

    public void setEstadoActual(Tasks estadoActual) {
        this.estadoActual = estadoActual;
    }
}
