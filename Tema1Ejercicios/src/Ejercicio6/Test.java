package Ejercicio6;

public class Test {
    public static void main(String[] args) {
        CuentaBancaria cuenta = new CuentaBancaria(100);
        Thread cliente1 = new Thread(new Cliente(cuenta), "Cliente 1");
        Thread cliente2 = new Thread(new Cliente(cuenta), "Cliente 2");

        cliente1.start();
        cliente2.start();

        // Esperar a que ambos hilos terminen
        /*try {
            cliente1.join();
            cliente2.join();
        } catch (InterruptedException e) {
            System.out.println("Hilos interrumpidos.");
        }

        System.out.println("Saldo final de la cuenta: " + cuenta.getSaldo() + "euros");
         */
    }
}
