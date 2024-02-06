package bootcamp;

import java.util.List;

public class Localizador {
    private Cliente cliente;
    private double total;
    private List<Reserva> reservas;
    private boolean paqueteCompleto;
private boolean clienteFrecuente;

    public Localizador(Cliente cliente, double total, List<Reserva> reservas) {
        this.cliente = cliente;
        this.total = total;
        this.reservas = reservas;

    }

    public Localizador(Cliente cliente, List<Reserva> reservas) {
        this.cliente = cliente;
        this.reservas = reservas;
        boolean existeHotel = reservas.stream().filter(reserva -> reserva.getTipoReserva().equals(ReservasEnum.HOTEL)).count() > 0;
        boolean existeViaje = reservas.stream().filter(reserva -> reserva.getTipoReserva().equals(ReservasEnum.VIAJE)).count() > 0;
        boolean existeComida = reservas.stream().filter(reserva -> reserva.getTipoReserva().equals(ReservasEnum.COMIDA)).count() > 0;
        boolean existeTransporte = reservas.stream().filter(reserva -> reserva.getTipoReserva().equals(ReservasEnum.TRANSPORTE)).count() > 0;
        if(existeHotel && existeComida && existeTransporte && existeViaje){
            this.paqueteCompleto = true;
        }
        if (reservas.stream().filter((reserva -> reserva.getTipoReserva().equals(ReservasEnum.HOTEL))).count() >= 2) {
            reservas = reservas.stream().map((reserva -> {
                if (reserva.getTipoReserva().equals(ReservasEnum.HOTEL)) {
                    reserva.setCosto(reserva.getCosto() * 0.95);
                    return reserva;
                }
                return reserva;
            })).toList();
        }
        if (reservas.stream().filter((reserva -> reserva.getTipoReserva().equals(ReservasEnum.VIAJE))).count() >= 2) {
            reservas = reservas.stream().map((reserva -> {
                if (reserva.getTipoReserva().equals(ReservasEnum.VIAJE)) {
                    reserva.setCosto(reserva.getCosto() * 0.95);
                    return reserva;
                }
                return reserva;
            })).toList();
        }

        this.total = reservas.stream().mapToDouble(Reserva::getCosto).sum();
        if (this.paqueteCompleto){
            this.total *= 0.9;
        }

    }

    @Override
    public String toString() {
        return "Localizador{" +
                "cliente=" + cliente +
                ", total=" + total +
                ", reservas=" + reservas +
                ", paqueteCompleto=" + paqueteCompleto +
                ", clienteFrecuente=" + clienteFrecuente +
                '}';
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setClienteFrecuente(boolean clienteFrecuente) {
        this.clienteFrecuente = clienteFrecuente;
        this.total *= 0.95;

    }
}