import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * La clase Horario gestiona la lista de tareas del usuario y las organiza
 * en función de su prioridad.
 */
public class Horario {
    private ArrayList<Tarea> listaTareas;

    /**
     * Constructor que inicializa el horario con una lista de tareas.
     * @param listaTareas Lista de tareas iniciales.
     */
    public Horario(ArrayList<Tarea> listaTareas) {
        this.listaTareas = listaTareas;
    }

    /**
     * Constructor por defecto que inicializa el horario con una lista vacía.
     */
    public Horario() {
        this.listaTareas = new ArrayList<>();
    }

    /**
     * Método que ordena las tareas según su prioridad.
     */
    public void tareasPrioritarias() {
        Collections.sort(listaTareas, Comparator.comparingInt(Tarea::getPrioridad));
    }

    /**
     * Actualiza el horario cuando una tarea ha sido modificada o añadida.
     * @param tareaModificada La tarea que ha sido actualizada o añadida.
     */
    public void actualizarHorario(Tarea tareaModificada) {
        boolean tareaActualizada = false;
        for (Tarea tarea : listaTareas) {
            if (tarea.getNombre().equals(tareaModificada.getNombre())) {
                tarea.setPrioridad(tareaModificada.getPrioridad());
                tarea.setDuracion(tareaModificada.getDuracion());
                tarea.setCompletado(tareaModificada.isCompletado());
                tareaActualizada = true;
            }
        }

        if (!tareaActualizada) {
            listaTareas.add(tareaModificada); // Añadir si no existe
        }

        tareasPrioritarias();  // Reordenar las tareas
    }

    /**
     * Muestra las tareas en orden de prioridad.
     */
    public void mostrarHorario() {
        System.out.println("Horario de tareas:");
        for (Tarea tarea : listaTareas) {
            System.out.println(tarea.getNombre() + " - Prioridad: " + tarea.getPrioridad());
        }
    }
}
