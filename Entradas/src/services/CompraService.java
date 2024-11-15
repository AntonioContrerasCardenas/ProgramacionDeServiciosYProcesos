package services;

import models.Asiento;
import models.Pabellon;
import models.Usuario;
import utils.Logger;

import java.util.List;

public class CompraService {
    List<Pabellon> pabellones;

    public CompraService(List<Pabellon> pabellones) {
        this.pabellones = pabellones;
    }

    public synchronized boolean reservaAsientos(int numAsientos, Usuario usuario) {

        for (Pabellon pabellon : pabellones) {
            Logger.log("CompraService: intentando reservar " + numAsientos + " asientos en pabellon " + pabellon.getId());
            List<Asiento> asientosDisponibles = pabellon.getAsientosDisponibles();
            if (asientosDisponibles.size() >= numAsientos) {
                Logger.log("CompraService: se han encontrado " + numAsientos + " asientos disponibles en pabellon " + pabellon.getId());
                if (pabellon.reservaAsientos(0, numAsientos, usuario)) {
                    Logger.log("CompraService: se han reservado " + numAsientos + " asientos en pabellon " + pabellon.getId());
                    Logger.log("CompraService : Procedemos al pago de " + usuario.getNombre());
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
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
