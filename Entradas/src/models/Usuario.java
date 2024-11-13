package models;

import java.util.Random;

public class Usuario {
    private final String nombre;
    private final int numAsientos;
    private final Pabellon pabellon;
    private static final int numeroIntentos = 3;
    private final Random random;

    public Usuario(String nombre, int numAsientos, Pabellon pabellon) {
        this.nombre = nombre;
        this.numAsientos = numAsientos;
        this.pabellon = pabellon;
        this.random = new Random();
    }

    public void resvera(){
        boolean reservado = false;
        int intentos = 0;

        while(!reservado && intentos < numeroIntentos){
            int posicionInicioReserva = random.nextInt(pabellon.numAsientos()-numAsientos+1);
            System.out.println(nombre + " intenta reservar en posicion " + posicionInicioReserva);

            reservado = pabellon.reservaAsientos(posicionInicioReserva, numAsientos, this);

            if (reservado) {
                System.out.println(nombre + " ha reservado sus entradas exitosamente.");
                pabellon.mostrarAsientosReservados();
            } else {
                System.out.println("No se pudo reservar asientos contiguos. " + nombre + " intenta nuevamente.");
            }

            intentos++;
        }
    }

    public String getNombre() {
        return nombre;
    }
}
