package Ejercicio7;

public class Daemon implements Runnable{
    @Override
    public void run() {
        while (true){
            System.out.println("Guardando progreso...");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                System.out.println("Error en el metodo sleep del hilo");
            }
        }
    }
}
