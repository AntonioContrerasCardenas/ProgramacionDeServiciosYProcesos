package clases;

public class HiloClase extends Thread{

    private boolean finish = false;

    public HiloClase(String name, ThreadGroup grupo){
        super(grupo, name);
    }

    @Override
    public synchronized void run() {
        System.out.println("Hilo " + this.getName() + ", del grupo " + this.getThreadGroup().getName() + " iniciado");
        finish = true;
        while (!finish){
            try {
                wait();

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }

        notifyAll();
//        try {
//            Thread.sleep(1500);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

//        System.out.println("Hilo " + Thread.currentThread().getName() + ", del grupo " + this.getThreadGroup().getName() + " terminado");
    }
}
