import classes.ProductoLista;
import controllers.FactoryList;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<ProductoLista> listaProductos = new ArrayList<ProductoLista>();
        listaProductos.add(new ProductoLista("Producto 1"));
        listaProductos.add(new ProductoLista("Producto 2"));
        listaProductos.add(new ProductoLista("Producto 3"));
        listaProductos.add(new ProductoLista("Producto 4"));
        listaProductos.add(new ProductoLista("Producto 5"));
        listaProductos.add(new ProductoLista("Producto 6"));


        FactoryList factory = new FactoryList(listaProductos);
        factory.startWorkers();
    }
}