package Ejercicio2;


public class Test {
    public static void main(String[] args) {
        Thread hilo = new Thread(new Hilo()) ;
        hilo.start();
    }
}
