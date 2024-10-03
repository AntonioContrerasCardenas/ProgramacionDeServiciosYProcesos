package Ejercicio3;

public class HiloMultiple extends Thread{

    public String nombreAnimal;
    public String sonidoAnimal;

    public HiloMultiple(String nombreAnimal, String sonidoAnimal){
        this.nombreAnimal = nombreAnimal;
        this.sonidoAnimal = sonidoAnimal;
    }

    @Override
    public void run() {
        System.out.println("Nombre de animal: " + nombreAnimal +", sonido: " + sonidoAnimal);
    }
}
