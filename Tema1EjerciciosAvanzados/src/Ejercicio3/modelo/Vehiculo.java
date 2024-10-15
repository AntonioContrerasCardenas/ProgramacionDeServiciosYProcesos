package Ejercicio3.modelo;

import java.util.Comparator;

public class Vehiculo extends Thread implements Comparable<Vehiculo> {

    private static final int DISTANCIA_RECORRER = 100;
    private final int velocidad;
    private int distanciaRecorrida = 0;
    private static final int DISTANCIASUMAR = 10;
    private boolean accidente = false;

    public Vehiculo(String name, int velocidad){
        super(name);
        this.velocidad = velocidad;
    }

    @Override
    public void run() {
        System.out.println(getName() + " empezando a correr...");
        while(distanciaRecorrida < DISTANCIA_RECORRER){
            try {
                sleep(velocidad);
            } catch (InterruptedException e) {
                System.out.println("Vehiculo " + getName() + " interrumpido");
            }
            distanciaRecorrida += 10;
        }

        System.out.println(getName() + " ha terminado la carrera");
    }


    public int getVelocidad() {
        return velocidad;
    }

    @Override
    public int compareTo(Vehiculo o) {
        return this.getVelocidad() - o.getVelocidad();
    }
}
