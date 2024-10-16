import classes.Producto;
import classes.Workers;
import controllers.Factory;
import enums.Tasks;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        List<Producto> listaProductos = new ArrayList<Producto>();
        listaProductos.add(new Producto("Producto 1"));
        listaProductos.add(new Producto("Producto 2"));
        listaProductos.add(new Producto("Producto 3"));
        listaProductos.add(new Producto("Producto 4"));
        listaProductos.add(new Producto("Producto 5"));
        listaProductos.add(new Producto("Producto 6"));

        Factory factory = new Factory(listaProductos);
//        Thread worker1 = new Thread(new Workers(factory, Tasks.CONSTRUIRBASE));
//        Thread worker2 = new Thread(new Workers(factory, Tasks.EMPAQUETAELPRODUCTO));
//        Thread worker3 = new Thread(new Workers(factory, Tasks.ENSAMBLACOMPONENTES));
//
//        worker1.start();
//        worker3.start();
//        worker2.start();

        for (Producto producto : listaProductos){
            Workers trabajadroBase = new Workers(factory,Tasks.CONSTRUIRBASE, producto);
            Workers trabajadroEnsamble = new Workers(factory,Tasks.ENSAMBLACOMPONENTES, producto);
            Workers trabajadroEmpaqueta = new Workers(factory,Tasks.EMPAQUETAELPRODUCTO, producto);

            trabajadroBase.start();
            trabajadroEnsamble.start();
            trabajadroEmpaqueta.start();
        }

    }
}