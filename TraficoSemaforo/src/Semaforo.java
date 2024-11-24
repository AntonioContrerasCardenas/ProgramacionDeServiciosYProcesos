public class Semaforo extends Thread {
    private EstadoEnum estado;
    private static final int NUMERO_AUTOS = 3;
    private int cochesPasados = 0;

    public Semaforo() {
        this.estado = EstadoEnum.AMARILLO;
        this.setDaemon(true);
    }

    public EstadoEnum getEstado() {
        return estado;
    }

    @Override
    public void run() {
        try {
            while (true) {
                switch (estado) {
                    case ROJO -> {
                        Thread.sleep(2000);
                        this.estado = EstadoEnum.VERDE;
                        System.out.println(estado);
                        synchronized (this) {
                            cochesPasados = 0;
                            this.notifyAll();
                        }
                    }

                    case AMARILLO -> {
                        Thread.sleep(2000);
                        this.estado = EstadoEnum.ROJO;
                        System.out.println(estado);
                    }

                    case VERDE -> {
                        Thread.sleep(2000);
                        this.estado = EstadoEnum.AMARILLO;
                        System.out.println(estado);
                    }
                }
                synchronized (this) {
                    notifyAll();
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public synchronized void pasarVehiculo(Coche coche) throws InterruptedException {
        while (estado != EstadoEnum.VERDE || cochesPasados >= NUMERO_AUTOS) {
            wait();
        }

        cochesPasados++;
        System.out.println(coche.getNombreCoche() + " pasa por el semáforo");

        if (cochesPasados >= NUMERO_AUTOS) {
            Thread.sleep(1000);

            this.notifyAll();

        }
    }
}
