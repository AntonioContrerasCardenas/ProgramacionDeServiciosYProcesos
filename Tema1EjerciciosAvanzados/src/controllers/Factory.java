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
    boolean isTrabajoAcabado = false;
    static int totalProductos = 0;
    static int contador = 0;

    public Factory(List<Producto> listaProductos) {
        totalProductos = listaProductos.size();
        listaProductosBaseConstruir.addAll(listaProductos);
    }

    public synchronized Producto getProductosBaseConstruir() {
        while (listaProductosBaseConstruir.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        //notifyAll();
        return listaProductosBaseConstruir.poll();
    }

    public synchronized Producto getProductosEnsamblar() {
        while (listaProductosEnsamblar.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        //notifyAll();
        return listaProductosEnsamblar.poll();
    }

    public synchronized Producto getProductosEmpaquetar() {
        while (listaProductosEmpaquetar.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        //notifyAll();
        return listaProductosEmpaquetar.poll();
    }

    public synchronized void addProductosEnsamblar(Producto producto) {
        listaProductosEnsamblar.add(producto);
        notifyAll();
    }

    public synchronized void addProductosEmpaquetar(Producto producto) {
        listaProductosEmpaquetar.add(producto);
        notifyAll();
    }

    public void construyeBase(Producto producto) {
        sleep();
        producto.setBaseConstruida(true);
        producto.setEstado("Base construida");
        System.out.println(producto.getNombre() + " con base construida");
        this.addProductosEnsamblar(producto);
//        synchronized (this) {
//            this.addProductosEnsamblar(producto);
//        }
    }

    public synchronized void ensamblaComponente(Producto producto) {
        sleep();
        producto.setEnsamble(true);
        producto.setEstado("Componentes ensamblados");
        System.out.println(producto.getNombre() + " con componentes ensamblados");
        this.addProductosEmpaquetar(producto);

    }

    public synchronized void empaquetaProducto(Producto producto) {
        sleep();
        producto.setEmpaquetado(true);
        producto.setEstado("Producto empaquetado");
        System.out.println(producto.getNombre() + " EMPAQUETADO");
        contador++;
        if(totalProductos == contador){
            setTrabajoAcabado(true);
        }
    }

    public void setTrabajoAcabado(boolean trabajoAcabado) {
        isTrabajoAcabado = trabajoAcabado;
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

    public boolean isTrabajoAcabado() {
        return isTrabajoAcabado;
    }
}
