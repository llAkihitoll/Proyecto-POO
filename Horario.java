import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa el Horario.
 * Un horario tiene una lista de tareas.
 * 
 * @autor Diego Reyes
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
     * Constructor que inicializa el horario con una lista de tareas dada.
     * 
     * @param listaTareas Lista de tareas para el horario.
     */
    public Horario(List<Tarea> listaTareas) {
        this.listaTareas = listaTareas;
    }
    /**
     * Obtiene la lista de tareas en el horario.
     * 
     * @return Lista de tareas.
     */
    public List<Tarea> getListaTareas() {
        return listaTareas;
    }
    /**
     * Establece la lista de tareas del horario.
     * 
     * @param listaTareas Lista de tareas a asignar al horario.
     */
    public void setListaTareas(List<Tarea> listaTareas) {
        this.listaTareas = listaTareas;
    }
    /**
     * Agrega una tarea al horario.
     * 
     * @param tarea Tarea que se desea agregar al horario.
     */
    public void agregarTarea(Tarea tarea) {
        listaTareas.add(tarea);
    }

    public void agregarTarea(Tarea tarea) {
        if (!tarea.getCompletado()) { // Solo agregar tareas que no están completadas
            listaTareas.add(tarea);
        }
    }
    /**
     * Genera un horario basado en la lista de tareas del usuario.
     * 
     * @param usuario Usuario cuyas tareas se utilizarán para generar el horario.
     */
    public void generarHorario(Usuario usuario) {
        listaTareas.clear();
    }

}

