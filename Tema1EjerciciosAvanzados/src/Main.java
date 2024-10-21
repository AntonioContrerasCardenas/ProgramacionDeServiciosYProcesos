import classes.Producto;
import classes.ProductoLista;
import classes.Workers;
import controllers.Factory;
import controllers.FactoryList;
import enums.Tasks;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        List<ProductoLista> listaProductos = new ArrayList<ProductoLista>();
        listaProductos.add(new ProductoLista("Producto 1"));
        listaProductos.add(new ProductoLista("Producto 2"));
        listaProductos.add(new ProductoLista("Producto 3"));
        listaProductos.add(new ProductoLista("Producto 4"));
        listaProductos.add(new ProductoLista("Producto 5"));
        listaProductos.add(new ProductoLista("Producto 6"));

//        Factory factory = new Factory(listaProductos);
        FactoryList factory = new FactoryList(listaProductos);
        factory.startWorkers();


    }
}