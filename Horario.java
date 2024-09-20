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
     * Actualiza una tarea existente en el horario. Si la tarea no existe, la
     * agrega a la lista. Luego ordena la lista según la prioridad.
     * 
     * @param tareaModificada La tarea que se ha modificado o añadido.
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
}
