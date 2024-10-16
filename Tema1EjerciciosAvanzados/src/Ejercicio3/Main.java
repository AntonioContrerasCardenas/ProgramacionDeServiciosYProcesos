package Ejercicio3;

import Ejercicio3.controlador.SupervisorCarrera;
import Ejercicio3.modelo.Vehiculo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class  Main {
    public static void main(String[] args) {
        List<Vehiculo> vehiculos = new ArrayList<>();

        vehiculos.add(new Vehiculo("Vehiculo1", 1000));
        vehiculos.add(new Vehiculo("Vehiculo2", 1500));
        vehiculos.add(new Vehiculo("Vehiculo3", 2000));

        Collections.sort(vehiculos);

        for (int i = 0; i < vehiculos.size(); i++) {
            vehiculos.get(i).setPriority(Thread.MAX_PRIORITY-i);
        }

        System.out.println("INICIANDO CARRERA...");

        vehiculos.forEach(Thread::start);

        new SupervisorCarrera(vehiculos).start();

        for (Vehiculo vehiculo : vehiculos) {
            try {
                vehiculo.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("FIN DE LA CARRERA");
    }
}
