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
        if(isTrabajoAcabado()){
            return null;
        }

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
        producto.setEstadoActual(Tasks.ENSAMBLACOMPONENTES);
        producto.setProducto("construido");
        //System.out.println(producto.getNombre() + " con base construida");
        System.out.println(producto.getCadena());
        avanzarTarea(producto);
    }

    public void ensamblaComponente(ProductoLista producto) {
        sleep();
        producto.setEnsamble(true);
        producto.setEstadoActual(Tasks.EMPAQUETAELPRODUCTO);
        producto.setProducto("ensamblado");
        //System.out.println(producto.getNombre() + " con componentes ensamblados");
        System.out.println(producto.getCadena());
        avanzarTarea(producto);
    }

    public void empaquetaProducto(ProductoLista producto) {
        sleep();
        producto.setEmpaquetado(true);
        producto.setEstadoActual(Tasks.FINALIZADO);
        //System.out.println(producto.getNombre() + " EMPAQUETADO");
        producto.setProducto("empaquetado");
        System.out.println(producto.getCadena());
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
        new WorkerList(this, Tasks.CONSTRUIRBASE).start();
        new WorkerList(this, Tasks.ENSAMBLACOMPONENTES).start();
        new WorkerList(this, Tasks.EMPAQUETAELPRODUCTO).start();
    }
}
