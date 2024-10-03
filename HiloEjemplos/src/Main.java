import clases.Hilo;
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
        Hilo hilo1 = new Hilo("Hilo1");
        hilo1.start();
        Hilo hilo2 = new Hilo("Hilo2");
        hilo2.start();
        Hilo hilo3 = new Hilo("Hilo3");
        hilo3.start();
        Hilo hilo4 = new Hilo("Hilo4");
        hilo4.start();

    }
}