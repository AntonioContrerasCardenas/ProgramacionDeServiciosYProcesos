import models.Pabellon;
import models.Usuario;
import services.CompraService;
import utils.Logger;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        int numAsientos = 20;

        List<Pabellon> pabellons = List.of(new Pabellon(1, numAsientos), new Pabellon(2, numAsientos), new Pabellon(3, numAsientos));

        CompraService compraService = new CompraService(pabellons);

        List<Usuario> usuarios = List.of(new Usuario("Juan", compraService), new Usuario("Pedro", compraService), new Usuario("Maria", compraService)
                , new Usuario("Jose", compraService), new Usuario("Antonio", compraService)
                , new Usuario("Luis", compraService), new Usuario("Paco", compraService)
        );

        for (Usuario usuario : usuarios) {
            usuario.start();
        }

        for (Usuario usuario : usuarios) {
            try {
                usuario.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        compraService.mostrarAsientosReservados();

        Logger.log("La aplicación ha finalizado.");
    }
}