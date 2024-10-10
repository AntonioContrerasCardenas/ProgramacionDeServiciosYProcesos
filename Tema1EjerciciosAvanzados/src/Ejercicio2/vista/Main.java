package Ejercicio2.vista;

import Ejercicio2.controlador.InformeAuditoria;
import Ejercicio2.modelo.Cliente;
import Ejercicio2.modelo.CuentaBancaria;

public class Main {
    public static void main(String[] args) {
        CuentaBancaria cuentaBancaria = new CuentaBancaria(300);
        Thread cliente1 =new Thread( new Cliente(cuentaBancaria) , "Cliente1");
        Thread cliente2 =new Thread(new Cliente(cuentaBancaria) , "Cliente2") ;
        Thread auditoria = new Thread(new InformeAuditoria(cuentaBancaria));

        auditoria.setDaemon(true);
        auditoria.start();

        cliente1.start();
        cliente2.start();

        try {
            cliente1.join();
            cliente2.join();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
