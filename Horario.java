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

    
}

