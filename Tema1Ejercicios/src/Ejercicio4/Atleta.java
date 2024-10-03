package Ejercicio4;

public class Atleta implements Runnable{

    public Integer numeroAtleta;

    public Atleta(Integer numeroAtleta){
        this.numeroAtleta = numeroAtleta;
    }

    @Override
    public void run() {
        System.out.println("Atleta " + numeroAtleta +" corriendo");
    }
}
