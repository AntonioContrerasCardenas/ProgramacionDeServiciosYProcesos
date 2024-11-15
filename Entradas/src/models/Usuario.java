package models;

import services.CompraService;
import utils.Logger;

import java.util.Random;

public class Usuario extends Thread {
    private final String nombre;
    private final int numAsientos;
    private static final int numeroIntentos = 3;
    private final Random random;
    private CompraService compraService;

    public Usuario(String nombre, int numAsientos, CompraService compraService) {
        this.nombre = nombre;
        this.numAsientos = numAsientos;
        this.compraService = compraService;
        this.random = new Random();
    }

    public Usuario(String nombre, CompraService compraService) {
        this.nombre = nombre;
        this.compraService = compraService;
        this.random = new Random();
        this.numAsientos = random.nextInt(4) + 1;
    }

    @Override
    public void start() {
        boolean reservado = false;
        int intentos = 0;

        while (!reservado && intentos < numeroIntentos) {
            Logger.log(nombre + " intenta reservar entradas.");

            reservado = compraService.reservaAsientos(numAsientos, this);
            if (reservado) {
                Logger.log(nombre + " ha reservado " + numAsientos + " asientos.");
                //pabellon.mostrarAsientosReservados();
            } else {
                Logger.log(nombre + " no ha podido reservar " + numAsientos + " asientos.");
            }

            intentos++;

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }


    public String getNombre() {
        return nombre;
    }
}
