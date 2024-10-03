package Ejercicio3;

public class Test {
    public static void main(String[] args) {
        HiloMultiple hilo1 = new HiloMultiple("Gato" , "miau");
        HiloMultiple hilo2 = new HiloMultiple("Perro" , "waug");
        HiloMultiple hilo3 = new HiloMultiple("Vaca" , "muuuu");
        hilo1.start();
        hilo2.start();
        hilo3.start();
    }
}
