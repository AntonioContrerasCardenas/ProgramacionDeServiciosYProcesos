package Ejercicio9;

public class Download implements Runnable{

    @Override
    public void run() {

        for (int i = 0; i < 3; i++) {
            try {
                System.out.println("Descargando archivo...");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("Error capturado");
            }
        }

    }
}
