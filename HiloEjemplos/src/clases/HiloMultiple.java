package clases;

public class HiloMultiple extends Thread {
    private String nombre;
    // Constructor que recibe el nombre del hilo
    public HiloMultiple(String nombre) {
        this.nombre = nombre;
    }
    // Código que ejecutará el hilo
    public void run() {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(nombre + " está corriendo.");
    }

}