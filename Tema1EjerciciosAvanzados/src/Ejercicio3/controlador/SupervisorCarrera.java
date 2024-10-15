package Ejercicio3.controlador;

import Ejercicio3.modelo.Vehiculo;

public class SupervisorCarrera implements Runnable{

    private Vehiculo[] vehiculos;

    public SupervisorCarrera(Vehiculo[] vehiculos){
        this.vehiculos = vehiculos;
    }

    @Override
    public void run() {
        while (true){
            System.out.println("SupervisorCarrera ejecutando");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
