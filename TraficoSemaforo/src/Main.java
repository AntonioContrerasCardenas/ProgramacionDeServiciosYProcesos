public class Main {
    public static void main(String[] args) {

        /*
        Crea un programa que simule un semáforo de tráfico con tres luces (verde, amarillo y rojo) que cambian cada cierto tiempo.
        Mientras tanto, varios autos (hilos) intentan pasar. Solo los autos en verde pueden continuar; los demás deben esperar.
         */

        Semaforo semaforo = new Semaforo();
        semaforo.start();

        for (int i = 0; i < 30; i++) {
            new Coche("Coche" + i, semaforo).start();
        }


        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}