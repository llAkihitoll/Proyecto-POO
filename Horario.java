import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa un Horario.
 * El Horario contiene una lista de tareas.
 */
public class Horario {
    /**
     * Lista de tareas en el horario.
     */
    private List<Tarea> listaTareas;

    /**
     * Constructor que inicializa el horario con una lista vacía de tareas.
     */
    public Horario() {
        this.listaTareas = new ArrayList<>();
    }

    /**
     * Obtiene la lista de tareas en el horario.
     * 
     * @return Lista de tareas en el horario.
     */
    public List<Tarea> getListaTareas() {
        return listaTareas;
    }

    /**
     * Establece la lista de tareas para el horario.
     * 
     * @param listaTareas Lista de tareas para el horario.
     */
    public void setListaTareas(List<Tarea> listaTareas) {
        this.listaTareas = listaTareas;
    }

    /**
     * Agrega una tarea al horario si no está completada.
     * 
     * @param tarea Tarea que se va a agregar.
     */
    public void agregarTarea(Tarea tarea) {
        if (!tarea.getCompletado()) { // Solo agregar tareas no completadas
            listaTareas.add(tarea);
        }
    }

    /**
     * Genera un horario basado en la lista de tareas del usuario.
     * Se agregan solo tareas no completadas y se ordenan por prioridad.
     * 
     * @param usuario Usuario cuyas tareas se usarán para generar el horario.
     */
    public void generarHorario(Usuario usuario) {
        // Limpiar la lista actual de tareas en el horario
        listaTareas.clear();

        // Agregar solo las tareas no completadas del usuario y ordenarlas por prioridad
        for (Tarea tarea : usuario.getTareas()) {
            if (!tarea.getCompletado()) {
                listaTareas.add(tarea);
            }
        }

        // Ordenar las tareas por prioridad (de menor a mayor prioridad)
        listaTareas.sort((t1, t2) -> Integer.compare(t1.getPrioridad(), t2.getPrioridad()));
    }

    /**
     * Muestra el horario en la consola, listando las tareas pendientes.
     */
    public void mostrarHorario() {
        if (listaTareas.isEmpty()) {
            System.out.println("No hay tareas pendientes en el horario.");
        } else {
            System.out.println("Tareas pendientes en el horario:");
            for (Tarea tarea : listaTareas) {
                System.out.println("Tarea: " + tarea.getNombreTarea() +
                                   " | Prioridad: " + tarea.getPrioridad() +
                                   " | Duración: " + tarea.getDuracion() + " minutos" +
                                   " | Detalles: " + tarea.getDetalles());
            }
        }
    }
}
