import java.util.ArrayList;
import java.util.List;

// lista privada que almacena las recompensas
public class Badges {
    private List<String> recompensas;
    private List<String> recompensasAdquiridas;

// constructor que inicializa la lista de recompensas como un nuevo Arraylist
    public Badges() {
        this.recompensas = new ArrayList<>();
        this.recompensasAdquiridas = new ArrayList<>();
        inicializarRecompensas();
    }
    
// metodo para que devuelva la lista de recompensas
    public List<String> getRecompensas() {
        return recompensas;
    }

    public List<String>getRecompensasAdquiridas(){
        return recompensasAdquiridas;
    
// metodo para agregar una nueva recompensa a la lista 
    public void agregarRecompensa(String recompensa) {
        recompensas.add(recompensa);
    }
}
