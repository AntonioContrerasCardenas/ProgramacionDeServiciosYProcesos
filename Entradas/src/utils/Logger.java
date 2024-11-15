package utils;

public class Logger {
    public static synchronized void log(String mensaje) {
        System.out.println(mensaje);
    }
}
