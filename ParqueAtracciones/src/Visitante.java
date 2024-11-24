public class Visitante extends Thread {

    private final String nombre;
    private final Atraccion atraccion;

    public Visitante(String nombre, Atraccion atraccion) {
        this.nombre = nombre;
        this.atraccion = atraccion;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public void run() {
        try {
            while (true) {
                atraccion.visitanteEntra(this);
                Thread.sleep(atraccion.getTiempoOperacion());
                break;
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
