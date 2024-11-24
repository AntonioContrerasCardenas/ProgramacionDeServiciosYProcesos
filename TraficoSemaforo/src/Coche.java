public class Coche extends Thread {

    private String nombreCoche;
    private final Semaforo semaforo;

    private static int contadorCoches = 0;
    private static final int LIMITE_COCHES = 3;

    public Coche(String nombreCoche, Semaforo semaforo) {
        this.nombreCoche = nombreCoche;
        this.semaforo = semaforo;
    }

    @Override
    public void run() {
        try {
            semaforo.pasarVehiculo(this);
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public String getNombreCoche() {
        return nombreCoche;
    }
}
