package Ejercicio5;

public class HiloFibonacci extends Thread {

    @Override
    public void run() {

        try {
            int n1 = 0, n2=1;
            System.out.println(n1);
            Thread.sleep(1000);
            System.out.println(n2);
            Thread.sleep(1000);

            for (int i = 3; i <= 5; i++) {
                int aux = n1 + n2;
                n1 = n2;
                n2 = aux;
                System.out.println(n2);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
