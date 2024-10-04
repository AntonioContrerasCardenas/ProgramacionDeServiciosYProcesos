package Ejercicio7;

public class Test {
    public static void main(String[] args) {
        Thread daemon = new Thread(new Daemon());
        daemon.setDaemon(true);
        daemon.start();

        try {
            Thread.sleep(10000);
            System.out.println("Tarea terminada");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
