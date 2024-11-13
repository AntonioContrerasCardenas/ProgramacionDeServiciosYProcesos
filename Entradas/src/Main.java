import models.Pabellon;
import models.Usuario;

public class Main {
    public static void main(String[] args) {
        int numAsientos = 20;
        Pabellon pabellon = new Pabellon(1, numAsientos);

        int numeroReserva = 5;
        Usuario usuario = new Usuario("Juan", numeroReserva, pabellon);
        usuario.resvera();
    }
}