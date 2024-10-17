package controllers;

import classes.Producto;
import enums.Tasks;

import java.util.List;

public class Factory {
    private boolean baseFinish;
    private boolean ensambleFinish;
    private List<Producto> listaProductos;

    public Factory(List<Producto> listaProductos){
        this.listaProductos = listaProductos;
        this.baseFinish = false;
        this.ensambleFinish = false;
    }

//    public synchronized void work(Tasks tasks){
//
//        for (Producto producto : listaProductos) {
//            switch (tasks) {
//                case CONSTRUIRBASE -> {
//                    construyeBase(producto);
//                }
//
//                case ENSAMBLACOMPONENTES -> {
//                    ensamblaComponente(producto);
//                }
//
//                case EMPAQUETAELPRODUCTO -> {
//                    empaquetaProducto(producto);
//                }
//            }
//        }
//
//    }

    public synchronized void empaquetaProducto(Producto producto) {

        while(!producto.isEnsamble()) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        sleep();
        producto.setEmpaquetado(true);
        producto.setEstado("Producto empaquetado");
        System.out.println(producto.getNombre() + " empaquetado");
        notifyAll();

//        sleep();
//        producto.setEstado("Producto empaquetado");
//        System.out.println(producto.getNombre() + " empaquetado");
//        notifyAll();
    }

    public synchronized void ensamblaComponente(Producto producto) {

        while(!producto.isBaseConstruida()) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        sleep();
        producto.setEnsamble(true);
        producto.setEstado("Componentes ensamblados");
        System.out.println(producto.getNombre() + " con componentes ensamblados");
        notifyAll();

//        sleep();
//        this.ensambleFinish = true;
//        producto.setEstado("Componentes ensamblados");
//        System.out.println(producto.getNombre() + " con componentes ensamblados");
//        notifyAll();
    }

    public synchronized void construyeBase(Producto producto) {

        sleep();
        producto.setBaseConstruida(true);
        producto.setEstado("Base construida");
        System.out.println(producto.getNombre() + " con base construida");
        notifyAll();

//        sleep();
//        this.baseFinish = true;
//        producto.setEstado("Base construida");
//        System.out.println(producto.getNombre() + " con base construida");
//        notifyAll();
    }

    public void sleep(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
