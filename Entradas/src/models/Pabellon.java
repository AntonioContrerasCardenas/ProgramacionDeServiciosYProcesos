package models;

import java.util.ArrayList;
import java.util.List;

public class Pabellon {
    private int id;
    private List<Asiento> asientos;

    public Pabellon(int id, int numAsientos) {
        this.id = id;
        this.asientos = new ArrayList<>();
        for (int i = 0; i < numAsientos; i++) {
            asientos.add(new Asiento(i));
        }
    }

    public int numAsientos() {
        return asientos.size();
    }

    public synchronized boolean reservaAsientos(int inicio, int numAsientos, Usuario usuario) {
        for (int i = inicio; i < inicio + numAsientos; i++) {
            if (i > asientos.size() || asientos.get(i).isReservado()) {
                return false;
            }
        }

        for (int i = inicio; i < inicio + numAsientos; i++) {
            asientos.get(i).reserva(usuario);
        }

        return true;
    }

    public synchronized void mostrarAsientosReservados() {
        System.out.println("(Pabellon " + id + ")");
        for (Asiento asiento : asientos) {
            if (asiento.isReservado()) {
                System.out.print(asiento.getId() + ":" + asiento.getUsuarioAReservar().getNombre().toUpperCase() + " ");
            } else {
                System.out.print(asiento.getId() + ":- ");
            }
        }

        System.out.println();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public synchronized List<Asiento> getAsientosDisponibles() {
        return asientos.stream().filter(a -> !a.isReservado()).toList();
    }

    public synchronized void liberaAsientos(Usuario usuario) {
        asientos.stream().filter(a -> a.getUsuarioAReservar() == usuario).forEach(Asiento::cancelaReserva);
    }
}
