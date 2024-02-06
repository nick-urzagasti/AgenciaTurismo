package bootcamp;

public class Reserva {
    private ReservasEnum tipoReserva;
    private double costo;

    public Reserva(ReservasEnum tipoReserva, double costo) {
        this.tipoReserva = tipoReserva;
        this.costo = costo;
    }

    public double getCosto() {
        return costo;
    }

    public ReservasEnum getTipoReserva() {
        return tipoReserva;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "tipoReserva=" + tipoReserva +
                ", costo=" + costo +
                '}';
    }
}
