import classes.Workers;
import controllers.Factory;
import enums.Tasks;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Factory factory = new Factory();
        Thread worker1 = new Thread(new Workers(factory, Tasks.CONSTRUIRBASE));
        Thread worker2 = new Thread(new Workers(factory, Tasks.EMPAQUETAELPRODUCTO));
        Thread worker3 = new Thread(new Workers(factory, Tasks.ENSAMBLACOMPONENTES));

        worker3.start();
        worker1.start();
        worker2.start();

    }
}