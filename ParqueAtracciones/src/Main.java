public class Main {
    public static void main(String[] args) {

//        Simula un parque con varias atracciones (hilos). Cada atracción tiene una capacidad máxima y un tiempo de operación.
//        Los visitantes (hilos) hacen cola para subirse a las atracciones. Usa Semaphore para controlar el acceso a las atracciones.

        Atraccion atraccion1 = new Atraccion("Atraccion 1", 5, 5000);
        Atraccion atraccion2 = new Atraccion("Atraccion 2", 3, 3000);

        atraccion1.start();
        atraccion2.start();

        for (int i = 0; i < 20; i++) {
            new Visitante("Visitante" + i, i % 2 == 0 ? atraccion1 : atraccion2).start();
        }
    }
}