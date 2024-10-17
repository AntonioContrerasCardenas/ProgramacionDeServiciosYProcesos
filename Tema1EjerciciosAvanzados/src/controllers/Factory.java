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

    public synchronized void work(Tasks tasks){

            switch (tasks){
                case CONSTRUIRBASE -> {
                    construyeBase();
                }

                case ENSAMBLACOMPONENTES -> {
                    ensamblaComponente();
                }

                case EMPAQUETAELPRODUCTO -> {
                    empaquetaProducto();
                }
            }


    }

    private void empaquetaProducto() {

        while(!this.ensambleFinish) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        sleep();
        System.out.println("Producto empaquetado");
        notifyAll();
    }

    private void ensamblaComponente() {

        while(!this.baseFinish) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        sleep();
        this.ensambleFinish = true;
        System.out.println("Componentes ensamblados");
        notifyAll();
    }

    private void construyeBase() {

        sleep();
        this.baseFinish = true;
        System.out.println("Base construida");
        notifyAll();
    }

    public void sleep(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
