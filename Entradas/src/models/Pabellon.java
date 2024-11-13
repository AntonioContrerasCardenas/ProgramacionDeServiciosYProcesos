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

    public int numAsientos(){
        return asientos.size();
    }

    public boolean reservaAsientos(int inicio, int numAsientos, Usuario usuario) {
        for (int i = inicio; i < inicio + numAsientos; i++) {
            if(i > asientos.size() || asientos.get(i).isReservado()){
                return false;
            }
        }

        for (int i = inicio; i < inicio + numAsientos; i++) {
            asientos.get(i).reserva(usuario);
        }

        return true;
    }

    public void mostrarAsientosReservados() {
        for (Asiento asiento : asientos) {
            if (asiento.isReservado()) {
                System.out.println(asiento.getUsuarioAReservar().getNombre());
            }else {
                System.out.println("Vacio");
            }
        }
    }
}
