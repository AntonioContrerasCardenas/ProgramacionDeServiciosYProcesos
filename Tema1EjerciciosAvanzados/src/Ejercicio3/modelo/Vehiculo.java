package Ejercicio3.modelo;

public class Vehiculo extends Thread{

    private int distancia;
    private ThreadGroup grupoPrioridad;

    public Vehiculo(String name, int distancia, ThreadGroup grupoPrioridad){
        super(name);
        this.distancia = distancia;
        this.grupoPrioridad = grupoPrioridad;
    }


}
