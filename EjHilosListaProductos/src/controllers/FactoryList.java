package controllers;

import classes.ProductoLista;
import classes.WorkerList;
import enums.Tasks;

import java.util.List;

public class FactoryList {
    private final List<ProductoLista> listaProductos;
    private boolean isTrabajoAcabado = false;
    private static int contador = 0;

    public FactoryList(List<ProductoLista> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public synchronized ProductoLista getProducto(Tasks task) {
        while(!hayProductoConTarea(task)){
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        for (ProductoLista producto : listaProductos) {
            if (producto.getEstadoActual() == task) {
                return producto;
            }
        }

        return null;
    }

    private boolean hayProductoConTarea(Tasks task) {
        for (ProductoLista producto : listaProductos) {
            if (producto.getEstadoActual() == task) {
                return true;
            }
        }
        return false;
    }

    public synchronized void avanzarTarea(ProductoLista producto) {
        notifyAll();
    }

    public void construyeBase(ProductoLista producto) {
        sleep();
        producto.setBaseConstruida(true);
        producto.setEstadoActual(Tasks.CONSTRUIRBASE);
        System.out.println(producto.getNombre() + " con base construida");
        avanzarTarea(producto);
    }

    public void ensamblaComponente(ProductoLista producto) {
        sleep();
        producto.setEnsamble(true);
        producto.setEstadoActual(Tasks.ENSAMBLACOMPONENTES);
        System.out.println(producto.getNombre() + " con componentes ensamblados");
        avanzarTarea(producto);
    }

    public void empaquetaProducto(ProductoLista producto) {
        sleep();
        producto.setEmpaquetado(true);
        System.out.println(producto.getNombre() + " EMPAQUETADO");
        contador++;
        if (contador == listaProductos.size()) {
            setTrabajoAcabado(true);
        }
    }

    public void setTrabajoAcabado(boolean trabajoAcabado) {
        isTrabajoAcabado = trabajoAcabado;
    }

    public boolean isTrabajoAcabado() {
        return isTrabajoAcabado;
    }

    public void sleep() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void startWorkers() {
        new WorkerList(this, Tasks.INICIANDO).start();
        new WorkerList(this, Tasks.CONSTRUIRBASE).start();
        new WorkerList(this, Tasks.ENSAMBLACOMPONENTES).start();
    }
}
