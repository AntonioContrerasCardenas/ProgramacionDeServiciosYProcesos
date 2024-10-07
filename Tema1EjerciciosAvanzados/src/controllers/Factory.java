package controllers;

import enums.Tasks;

public class Factory {
    private boolean baseFinish;
    private boolean ensambleFinish;

    public Factory(){
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

            default -> {

            }
        }
        notifyAll();
    }

    private void empaquetaProducto() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }

    private void ensamblaComponente() {
    }

    private void construyeBase() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        this.baseFinish = true;
    }
}
