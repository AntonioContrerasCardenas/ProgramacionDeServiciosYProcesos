package Ejercicio2;

public class Hilo implements Runnable{

    @Override
    public void run() {
        for (char letra = 'A'; letra <= 'Z'; letra++) {
            System.out.print(letra + " ");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
