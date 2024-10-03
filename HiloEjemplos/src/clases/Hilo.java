package clases;

public class Hilo extends Thread{
    public static Integer contador = 0;

    public Hilo(String name){
        super(name);
    }

    @Override
    public void run() {

            while (contador<=3){
                synchronized (contador){
                    if (contador<=3){
                        System.out.println(this.currentThread().getName() + " : " + contador);
                        contador++;
                    }


                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }


    }
}
