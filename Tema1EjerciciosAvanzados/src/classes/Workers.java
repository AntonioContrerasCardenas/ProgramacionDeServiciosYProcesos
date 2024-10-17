package classes;

import controllers.Factory;
import enums.Tasks;

public class Workers extends Thread{

    private Tasks task;
    private Factory factory;
    private Producto producto;

    public Workers(Factory factory,Tasks task, Producto producto){
        this.task = task;
        this.factory = factory;
        this.producto = producto;
    }

    @Override
    public void run() {
        switch (task) {
            case CONSTRUIRBASE -> this.factory.construyeBase(producto);
            case EMPAQUETAELPRODUCTO -> this.factory.empaquetaProducto(producto);
            case ENSAMBLACOMPONENTES -> this.factory.ensamblaComponente(producto);
        }
    }
}
