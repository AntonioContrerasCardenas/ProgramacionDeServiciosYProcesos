package Ejercicio10;

public class Hilo implements Runnable{

    @Override
    public void run() {
        String nombre = Thread.currentThread().getName();
        int prioridad = Thread.currentThread().getPriority();

        System.out.println("Nombre: " + nombre + ", prioridad: " + prioridad);

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
