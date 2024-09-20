import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

/**
 * Pruebas unitarias para la clase Horario.
 */
public class HorarioTest {

    /**
     * Verifica que el método mostrarHorario() funcione sin errores.
     */
    @Test
    public void testMostrarHorario() {
        ArrayList<Tarea> tareas = new ArrayList<>();
        tareas.add(new Tarea("Tarea 1", 2, 1.0, false, "Descripción 1"));
        tareas.add(new Tarea("Tarea 2", 1, 1.5, false, "Descripción 2"));

        Horario horario = new Horario(tareas);
        horario.mostrarHorario();

        assertTrue(true);  // Este test simplemente verifica que el método se ejecuta sin errores
    }
}
