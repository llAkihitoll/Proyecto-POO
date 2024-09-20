import java.util.ArrayList;

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
     * Muestra la lista de tareas ordenadas según su prioridad.
     */
    public void mostrarHorario() {
        System.out.println("Horario de tareas:");
        for (Tarea tarea : listaTareas) {
            System.out.println(tarea.getNombre() + " - Prioridad: " + tarea.getPrioridad());
        }
    }
}
