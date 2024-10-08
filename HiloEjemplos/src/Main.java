import clases.Hilo;
import clases.HiloClase;
import clases.HiloMultiple;

import java.util.Arrays;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        HiloMultiple[] vectorHilos = new HiloMultiple[10];

        /*for (int i = 0; i < vectorHilos.length; i++) {
            vectorHilos[i] = new HiloMultiple("Hilo "+ i);
        }

        for (HiloMultiple hilo : vectorHilos){
            hilo.start();
            //Pierde potencia del hilo pero hacemos que se muestren de manera ordenada
            try {
                hilo.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/

        //Con lambda
        //Arrays.setAll(vectorHilos, ind -> new HiloMultiple("Hilo " + (ind + 1)));
        //Arrays.stream(vectorHilos).forEach(e -> e.start());
//        Hilo hilo1 = new Hilo("Hilo1");
//        hilo1.start();
//        Hilo hilo2 = new Hilo("Hilo2");
//        hilo2.start();
//        Hilo hilo3 = new Hilo("Hilo3");
//        hilo3.start();
//        Hilo hilo4 = new Hilo("Hilo4");
//        hilo4.start();

        //Creacion de grupos
        int cantidadHilosGrupo = 5;
        ThreadGroup grupo1 = new ThreadGroup("Grupo1");
        grupo1.setMaxPriority(Thread.MAX_PRIORITY);
        crearHilosPorGrupo(cantidadHilosGrupo, grupo1);

        ThreadGroup grupo2 = new ThreadGroup("Grupo2");
        grupo2.setMaxPriority(Thread.MIN_PRIORITY);
        crearHilosPorGrupo(cantidadHilosGrupo, grupo2);


        Thread vectorGrupo1[] = new Thread [grupo1.activeCount()];
        Thread vectorGrupo2[] = new Thread [grupo2.activeCount()];


        grupo1.enumerate(vectorGrupo1);
        grupo2.enumerate(vectorGrupo2);

        for (Thread hilo : vectorGrupo1){
            try {
                hilo.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        if(grupo1.activeCount() == 0)
            System.out.println("Grupo1 terminado");

        for (Thread hilo : vectorGrupo2){
            try {
                hilo.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        if(grupo2.activeCount() == 0)
            System.out.println("Grupo2 terminado");



    }

    private static void crearHilosPorGrupo(int cantidadHilosGrupo, ThreadGroup grupo1) {
        for (int i = 0; i < cantidadHilosGrupo; i++) {
            HiloClase hilo = new HiloClase(i+ "ª" , grupo1);
            hilo.start();

            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}