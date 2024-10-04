package Ejercicio8;

public class Hilo implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(1000);
                System.out.println("Mensaje desde el hilo");
            } catch (InterruptedException e) {
                System.out.println("Error capturado");
            }
        }
    }
}
