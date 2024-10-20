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

        factory.startWorkers();


    }
}