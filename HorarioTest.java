import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

/**
 * Pruebas unitarias para la clase Horario.
 */
public class HorarioTest {

    /**
     * Verifica que las tareas se ordenen correctamente por prioridad.
     */
    @Test
    public void testTareasPrioritarias() {
        ArrayList<Tarea> tareas = new ArrayList<>();
        tareas.add(new Tarea("Tarea 1", 2, 1.0, false, "Descripción 1"));
        tareas.add(new Tarea("Tarea 2", 1, 1.5, false, "Descripción 2"));

        Horario horario = new Horario(tareas);
        horario.tareasPrioritarias();

        assertEquals(1, horario.getListaTareas().get(0).getPrioridad());
    }
}
