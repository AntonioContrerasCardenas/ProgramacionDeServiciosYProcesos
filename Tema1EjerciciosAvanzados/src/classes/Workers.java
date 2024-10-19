package classes;

import controllers.Factory;
import enums.Tasks;

public class Workers extends Thread{

    private Tasks task;
    private final Factory factory;

    public Workers(Factory factory,Tasks task){
        this.task = task;
        this.factory = factory;
    }

    @Override
    public void run() {
        while (true) switch (task) {
            case CONSTRUIRBASE -> {
                Producto producto = factory.getProductosBaseConstruir();
                if (producto == null) {
                    waitFactories();
                }else{
                    this.factory.construyeBase(producto);
                }
            }
            case EMPAQUETAELPRODUCTO -> {
                    while (true) {
                        System.out.println("IIIIIIII");

                        Producto producto = factory.getProductosEmpaquetar();
                        if (producto != null)
                            this.factory.empaquetaProducto(producto);


                    }


            }
            case ENSAMBLACOMPONENTES -> {

                    Producto producto = factory.getProductosEnsamblar();
                    if (producto == null) {
                        waitFactories();
                    }else{
                        this.factory.ensamblaComponente(producto);
                    }

            }
        }

    }

    private void waitFactories() {
        synchronized (factory){
            try {
                factory.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
