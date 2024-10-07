package Ejercicio10;

public class Test {
    public static void main(String[] args) {
        Thread hilo1 = new Thread(new Hilo(), "Hilo1");
        Thread hilo2 = new Thread(new Hilo(), "Hilo2");


        hilo1.setPriority(Thread.MIN_PRIORITY);
        hilo2.setPriority(Thread.MAX_PRIORITY);

        hilo1.start();
        hilo2.start();
    }
}
