package Ejercicio4;

public class Test {
    public static void main(String[] args) {
        Thread atleta1 = new Thread(new Atleta(1)) ;
        Thread atleta2 = new Thread(new Atleta(2)) ;
        Thread atleta3 = new Thread(new Atleta(3)) ;

        atleta1.start();
        atleta2.start();
        atleta3.start();
    }
}
