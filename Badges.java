import java.util.ArrayList;
import java.util.List;

public class Badges {
    private List<String> recompensas;

    public Badges() {
        this.recompensas = new ArrayList<>();
    }

    public List<String> getRecompensas() {
        return recompensas;
    }

    public void agregarRecompensa(String recompensa) {
        recompensas.add(recompensa);
    }
}
