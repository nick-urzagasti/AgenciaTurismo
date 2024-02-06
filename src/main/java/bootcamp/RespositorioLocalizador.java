package bootcamp;

import java.util.ArrayList;
import java.util.List;

public class RespositorioLocalizador {
    private List<Localizador> localizadores;

    public RespositorioLocalizador() {
        localizadores = new ArrayList<>();
    }
    public void add(Localizador localizador){
        if(localizadores.stream().filter(local -> local.getCliente() == localizador.getCliente()).count() >= 2){
            localizador.setClienteFrecuente(true);
        }
        localizadores.add(localizador);
    }
    public void mostrarLocalizadores(){
        localizadores.forEach(System.out::println);
    }
    public long contarLocalizadores(){
        return this.localizadores.size();
    }

    public long contarReservas(){
        return this
    }

}
