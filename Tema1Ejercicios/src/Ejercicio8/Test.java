package Ejercicio8;

public class Test {
    public static void main(String[] args) {
        Thread hilo = new Thread(new Hilo());
        hilo.start();

        System.out.println(hilo.isAlive() ? "Hilo vivo" : "Hilo muerto");

        try {
            hilo.join();
        } catch (InterruptedException e) {
        }

        System.out.println(hilo.isAlive() ? "Hilo vivo" : "Hilo muerto");

    }
}
