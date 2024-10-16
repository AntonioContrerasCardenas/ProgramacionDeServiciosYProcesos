package Ejercicio3.modelo;

import java.util.Comparator;

public class Vehiculo extends Thread implements Comparable<Vehiculo> {

    private static final int DISTANCIA_RECORRER = 100;
    private final int velocidad;
    private int distanciaRecorrida = 0;
    private static final int DISTANCIASUMAR = 10;
    private boolean averiado = false;

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
                System.out.println(getName() + ", lleva recorrido " + distanciaRecorrida +"m");
                distanciaRecorrida += DISTANCIASUMAR;
            } catch (InterruptedException e) {
//                if (!averiado){
//                    averiado = true;
//                    System.out.println("Se averia el vehiculo " + getName());
//                }else{
//                    System.out.println("Se repara el vehiculo " + getName());
//                    averiado = false;
//                }
                accidenteVehiculo();


            }
        }

        System.out.println(getName() + " ha terminado la carrera");
    }

    private void accidenteVehiculo() {
        try {
            System.out.println("Se averia el vehiculo " + getName());
            sleep(2000);
            System.out.println("Se repara el vehiculo " + getName());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public int getVelocidad() {
        return velocidad;
    }

    @Override
    public int compareTo(Vehiculo o) {
        return this.getVelocidad() - o.getVelocidad();
    }
}
