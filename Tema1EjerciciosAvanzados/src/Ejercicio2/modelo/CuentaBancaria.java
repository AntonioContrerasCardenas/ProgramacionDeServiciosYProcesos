package Ejercicio2.modelo;

public class CuentaBancaria {
    private int saldo;

    public CuentaBancaria(int saldo){
        this.saldo = saldo;
    }

    public synchronized void depositar(int cantidad){
        String nameThread = Thread.currentThread().getName();
        saldo += cantidad;
        System.out.println(nameThread + " depositando " + cantidad + "e, saldo actual: " + saldo);
    }

    public synchronized void retirar(int cantidad){
        String nameThread = Thread.currentThread().getName();
        if(saldo - cantidad < 0){
            System.out.println(nameThread + " no puede retirar " + cantidad +"e debido a que el saldo es " + saldo + "e");
        }else {
            saldo -= cantidad;
            System.out.println(nameThread + " retirando " + cantidad + "e, saldo actual: " + saldo);
        }
    }

    public int getSaldo() {
        return saldo;
    }
}
