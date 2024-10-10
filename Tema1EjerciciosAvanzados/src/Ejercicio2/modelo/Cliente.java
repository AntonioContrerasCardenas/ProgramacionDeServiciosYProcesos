package Ejercicio2.modelo;

public class Cliente implements Runnable{

    private CuentaBancaria cuentaBancaria;
    private static final int movimientosBancarios = 4;

    public Cliente(CuentaBancaria cuentaBancaria){
        this.cuentaBancaria = cuentaBancaria;
    }


    @Override
    public void run() {
        for (int i = 0; i < movimientosBancarios; i++) {
            cuentaBancaria.depositar(20);
            cuentaBancaria.retirar(70);

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
