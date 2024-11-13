package models;

public class Asiento {
    private int id;
    private Usuario usuarioAReservar;
    private boolean reservado;

    public Asiento(int id) {
        this.id = id;
        this.reservado = false;
    }

    public boolean reserva(Usuario usuario) {
        if (reservado) return false;
        usuarioAReservar = usuario;
        reservado = true;
        return true;
    }

    public boolean cancelaReserva() {
        if (!reservado) return false;
        usuarioAReservar = null;
        reservado = false;
        return true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getUsuarioAReservar() {
        return usuarioAReservar;
    }

    public void setUsuarioAReservar(Usuario usuarioAReservar) {
        this.usuarioAReservar = usuarioAReservar;
    }

    public boolean isReservado() {
        return reservado;
    }

    public void setReservado(boolean reservado) {
        this.reservado = reservado;
    }
}
