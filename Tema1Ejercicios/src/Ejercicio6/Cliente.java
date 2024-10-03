package Ejercicio6;

public class Cliente implements Runnable{

    private CuentaBancaria cuenta;

    public Cliente(CuentaBancaria cuenta){
        this.cuenta = cuenta;
    }

    @Override
    public void run() {
        cuenta.retirar(70);
    }
}
