package bootcamp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

    RepositorioCliente repositorioCliente = new RepositorioCliente();
    RespositorioLocalizador repositorioLocalizador = new RespositorioLocalizador();

    Cliente cli1 = new Cliente("Ramiro Perez");
    repositorioCliente.add(cli1);
    List<Reserva> reservas = List.of(
            new Reserva(ReservasEnum.TRANSPORTE, 500.46),
            new Reserva(ReservasEnum.VIAJE, 1300.0),
            new Reserva(ReservasEnum.COMIDA, 100.50),
            new Reserva(ReservasEnum.HOTEL, 2500.0)
    );

    Localizador local1 = new Localizador(cli1, reservas);

    repositorioLocalizador.add(local1);
    repositorioLocalizador.mostrarLocalizadores();

    List<Reserva> reservas2 = List.of(
            new Reserva(ReservasEnum.HOTEL, 100.0),
            new Reserva(ReservasEnum.VIAJE, 100.0),
            new Reserva(ReservasEnum.HOTEL, 100.0),
            new Reserva(ReservasEnum.VIAJE, 100.0)
    );
    Localizador local2 = new Localizador(cli1, reservas2);
    repositorioLocalizador.add(local2);
    repositorioLocalizador.mostrarLocalizadores();
    List<Reserva> reservas3 =List.of(new Reserva(ReservasEnum.HOTEL, 100.0));
    Localizador local3= new Localizador(cli1, reservas3);
    repositorioLocalizador.add(local3);
    repositorioLocalizador.mostrarLocalizadores();
        repositorioLocalizador.mostrarPorTipoReserva();
        System.out.println("Total de ventas:");
        System.out.println(repositorioLocalizador.mostrarTotalVentas());
        System.out.println("Total promedio");
        System.out.println(repositorioLocalizador.mostrarTotalPromedio());

    }


    
}