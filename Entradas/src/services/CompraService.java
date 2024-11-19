package services;

import models.Asiento;
import models.Pabellon;
import models.Usuario;
import utils.Logger;

import java.util.List;
import java.util.Random;

public class CompraService {
    List<Pabellon> pabellones;
    private static final Random random = new Random();
    private static int numCompras = 0;

    public CompraService(List<Pabellon> pabellones) {
        this.pabellones = pabellones;
    }

    public boolean reservaAsientos(int numAsientos, Usuario usuario) {

        for (Pabellon pabellon : pabellones) {
            Logger.log("CompraService: intentando reservar " + numAsientos + " asientos en pabellon " + pabellon.getId());
            List<Asiento> asientosDisponibles = pabellon.getAsientosDisponibles();
            numCompras++;
            if (asientosDisponibles.size() >= numAsientos) {
                Logger.log("CompraService: se han encontrado " + numAsientos + " asientos disponibles en pabellon " + pabellon.getId() + " para " + usuario.getNombre());
                int inicio = random.nextInt(asientosDisponibles.size() - numAsientos);
                if (pabellon.reservaAsientos(inicio, numAsientos, usuario)) {
                    //Logger.log("CompraService: se han reservado " + numAsientos + " asientos en pabellon " + pabellon.getId());
                    Logger.log("CompraService : Procedemos al pago de " + usuario.getNombre());
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    if (numCompras == 5) {
                        Logger.log("CompraService : Pago fallido de " + usuario.getNombre());
                        pabellon.liberaAsientos(usuario);
                        numCompras = 0;
                        return false;
                    }
                    Logger.log("CompraService : Pago completado de " + usuario.getNombre());
                    return true;
                }
            }
        }

        return false;
    }

    public void mostrarAsientosReservados() {
        for (Pabellon pabellon : pabellones) {
            pabellon.mostrarAsientosReservados();
        }
    }
}
