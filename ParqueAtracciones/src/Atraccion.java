import java.util.ArrayList;
import java.util.List;

public class Atraccion extends Thread {

    private final String nombre;
    private final int capacidad;
    private final int tiempoOperacion;
    private List<Visitante> visitantesActuales;

    public Atraccion(String nombre, int capacidad, int tiempoOperacion) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.tiempoOperacion = tiempoOperacion;
        this.visitantesActuales = new ArrayList<>();

        setDaemon(true);
    }

    public synchronized void visitanteEntra(Visitante visitante) throws InterruptedException {

        while (visitantesActuales.size() >= capacidad) {
            System.out.println("La atracción " + nombre + " está llena");
            wait();

        }
        visitantesActuales.add(visitante);
        System.out.println(visitante.getNombre() + " entra en la atracción " + nombre);
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(tiempoOperacion);


                bajarVisitantes();

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private synchronized void bajarVisitantes() {
        System.out.println("Bajando visitantes de la atracción " + nombre);

        visitantesActuales.clear();

        notifyAll();
    }

    public int getTiempoOperacion() {
        return tiempoOperacion;
    }
}
