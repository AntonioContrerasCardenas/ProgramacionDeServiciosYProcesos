package Ejercicio9;

public class Test {
    public static void main(String[] args) {
        Thread download = new Thread(new Download());

        download.start();

        try {
            download.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Descarga terminada");
    }
}
