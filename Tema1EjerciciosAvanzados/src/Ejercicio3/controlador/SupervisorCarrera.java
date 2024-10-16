package Ejercicio3.controlador;

import Ejercicio3.modelo.Vehiculo;

import java.util.List;
import java.util.Random;

public class SupervisorCarrera extends Thread{

    private List<Vehiculo> vehiculos;
    private Random random = new Random();

    public SupervisorCarrera(List<Vehiculo> vehiculos){
        this.vehiculos = vehiculos;
        this.setDaemon(true);
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(5000);
                Vehiculo vehiculoAccidentado = vehiculos.get(random.nextInt(vehiculos.size()));

                if(vehiculoAccidentado.isAlive() && !vehiculoAccidentado.isInterrupted()){
                    System.out.println("Se averia el vehiculo " + vehiculoAccidentado.getName());
                    vehiculoAccidentado.interrupt();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
