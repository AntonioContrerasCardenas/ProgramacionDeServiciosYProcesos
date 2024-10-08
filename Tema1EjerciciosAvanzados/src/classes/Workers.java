package classes;

import controllers.Factory;
import enums.Tasks;

public class Workers implements Runnable{

    private Tasks task;
    private Factory factory;

    public Workers(Factory factory,Tasks task){
        this.task = task;
        this.factory = factory;
    }

    @Override
    public void run() {
        System.out.println("Trabajador con cargo: " + task+", despierto");
        this.factory.work(this.task);
    }
}
