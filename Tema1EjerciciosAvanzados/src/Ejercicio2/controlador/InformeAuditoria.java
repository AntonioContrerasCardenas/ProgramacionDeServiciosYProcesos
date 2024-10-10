package Ejercicio2.controlador;

import Ejercicio2.modelo.CuentaBancaria;

public class InformeAuditoria implements Runnable{
    private CuentaBancaria cuentaBancaria;

    public InformeAuditoria(CuentaBancaria cuentaBancaria){
        this.cuentaBancaria = cuentaBancaria;
    }

    @Override
    public void run() {
        while (true){
            System.out.println("El saldo de la cuenta bancaria es: " + cuentaBancaria.getSaldo());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
