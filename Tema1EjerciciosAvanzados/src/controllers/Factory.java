package controllers;

import classes.Producto;
import classes.Workers;
import enums.Tasks;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
public class Factory {
    private Queue<Producto> listaProductosBaseConstruir = new LinkedList<>();
    private Queue<Producto> listaProductosEnsamblar = new LinkedList<>();
    private Queue<Producto> listaProductosEmpaquetar = new LinkedList<>();

    public Factory(List<Producto> listaProductos) {
        listaProductosBaseConstruir.addAll(listaProductos);
    }

    public synchronized Producto getProductosBaseConstruir() {
        return listaProductosBaseConstruir.poll();
    }

    public synchronized Producto getProductosEnsamblar() {
        return listaProductosEnsamblar.poll();
    }

    public synchronized Producto getProductosEmpaquetar() {
        return listaProductosEmpaquetar.poll();
    }

    public synchronized void addProductosEnsamblar(Producto producto) {
        listaProductosEnsamblar.add(producto);
        notifyAll(); // Notifica a otros hilos que un producto está listo para ensamblar
    }

    public synchronized void addProductosEmpaquetar(Producto producto) {
        listaProductosEmpaquetar.add(producto);
        notifyAll(); // Notifica a otros hilos que un producto está listo para empaquetar
    }

    public synchronized void construyeBase(Producto producto) {
        sleep();
        producto.setBaseConstruida(true);
        producto.setEstado("Base construida");
        System.out.println(producto.getNombre() + " con base construida");
        this.addProductosEnsamblar(producto); // Mueve el producto a la cola de ensamblado
        notifyAll();
    }

    public synchronized void ensamblaComponente(Producto producto) {
        System.out.println("Ensamblando componentes");
        while (!producto.isBaseConstruida()) {
            try {
                wait(); // Espera a que la base esté construida
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        sleep();
        producto.setEnsamble(true);
        producto.setEstado("Componentes ensamblados");
        System.out.println(producto.getNombre() + " con componentes ensamblados");
        this.addProductosEmpaquetar(producto); // Mueve el producto a la cola de empaquetado
        notifyAll();
    }

    public synchronized void empaquetaProducto(Producto producto) {
        while (!producto.isEnsamble()) {
            try {
                wait(); // Espera a que el ensamblaje esté completo
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        sleep();
        producto.setEmpaquetado(true);
        producto.setEstado("Producto empaquetado");
        System.out.println(producto.getNombre() + " empaquetado");
        notifyAll();
    }

    public void sleep() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void startWorkers() {
        new Workers(this, Tasks.CONSTRUIRBASE).start();
        new Workers(this, Tasks.ENSAMBLACOMPONENTES).start();
        new Workers(this, Tasks.EMPAQUETAELPRODUCTO).start();
    }
}
