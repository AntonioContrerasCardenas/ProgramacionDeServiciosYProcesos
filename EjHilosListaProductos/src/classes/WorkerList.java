package classes;

import controllers.FactoryList;
import enums.Tasks;

public class WorkerList extends Thread{

    private Tasks task;
    private final FactoryList factory;

    public WorkerList(FactoryList factory, Tasks task) {
        this.task = task;
        this.factory = factory;
    }
    @Override
    public void run() {
        while (!factory.isTrabajoAcabado()) {
            ProductoLista producto = factory.getProducto(task);
            if (producto != null) {
                switch (task) {
                    case CONSTRUIRBASE -> factory.construyeBase(producto);
                    case ENSAMBLACOMPONENTES -> factory.ensamblaComponente(producto);
                    case EMPAQUETAELPRODUCTO -> factory.empaquetaProducto(producto);
                }
            }
        }

    }
}
