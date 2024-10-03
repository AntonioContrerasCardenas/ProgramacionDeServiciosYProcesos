package Ejercicio6;

public class CuentaBancaria {
    public double saldo;

    public CuentaBancaria(double saldo){
        this.saldo = saldo;
    }

    public synchronized void retirar(double cantidadRetirar){
        String nombre = Thread.currentThread().getName();
        if(cantidadRetirar <= saldo){
            saldo -= cantidadRetirar;
            System.out.println( nombre + " retira " + cantidadRetirar + " y su saldo ahora es " + saldo);
        }else{
            System.out.println( nombre + " no puede retirar " + cantidadRetirar + " porque su saldo es " + saldo);
        }
    }

    public double getSaldo() {
        return saldo;
    }
}
