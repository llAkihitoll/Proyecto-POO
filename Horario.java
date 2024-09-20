import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * La clase Horario gestiona una lista de tareas del usuario.
 */
public class Horario {
    private ArrayList<Tarea> listaTareas;

    /**
     * Constructor que inicializa el horario con una lista de tareas.
     * 
     * @param listaTareas Lista de tareas proporcionada.
     */
    public Horario(ArrayList<Tarea> listaTareas) {
        this.listaTareas = listaTareas;
    }

    /**
     * Ordena la lista de tareas según la prioridad (de menor a mayor).
     */
    public void tareasPrioritarias() {
        Collections.sort(listaTareas, Comparator.comparingInt(Tarea::getPrioridad));
    }
}
