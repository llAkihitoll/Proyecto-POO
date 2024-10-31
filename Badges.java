import java.util.ArrayList;
import java.util.List;

// Clase que almacena las recompensas
public class Badges {
    private List<String> recompensas;
    private List<String> recompensasAdquiridas;

    // Constructor que inicializa las listas de recompensas y recompensas adquiridas
    public Badges() {
        this.recompensas = new ArrayList<>();
        this.recompensasAdquiridas = new ArrayList<>();
        inicializarRecompensas();
    }

    // Método para devolver la lista de recompensas
    public List<String> getRecompensas() {
        return recompensas;
    }

    // Método para devolver la lista de recompensas adquiridas
    public List<String> getRecompensasAdquiridas() {
        return recompensasAdquiridas;
    }

    // Método para agregar una nueva recompensa a la lista de recompensas
    public void agregarRecompensa(String recompensa) {
        recompensas.add(recompensa);
    }

    // Método para inicializar la lista de recompensas con logros predeterminados
    private void inicializarRecompensas() {
        recompensas.add("Primer Paso" + "\n --Completa una tarea o evento en el calendario--");
        recompensas.add("Racha Semanal" + "\n --Mantén una racha de 7 días consecutivos--");
        recompensas.add("Racha Mensual" + "\n --Mantén una racha de 30 días consecutivos--");
        recompensas.add("Racha de Productividad" + "\n --Completa tareas sin faltar durante 3 meses--");
        recompensas.add("Organización Impecable" + "\n --Planifica al menos una tarea diaria durante una semana completa--");
        recompensas.add("Fiel a tus Objetivos" + "\n --Mantén una racha de al menos 60 días sin interrupciones--");
        recompensas.add("Planificación Anual" + "\n --Usa el calendario durante un año completo con tareas al menos una vez al mes--");
        recompensas.add("Mejora Continua" + "\n --Completa un objetivo semanal, mensual o anual de crecimiento--");
        recompensas.add("Maestro de las Rachas" + "\n --Completa una racha de 100 días--");
        recompensas.add("Organizador Experto" + "\n --Completa 500 tareas--");
        recompensas.add("Amante del Orden" + "\n --Completa tareas sin saltarte ningún día en dos semanas consecutivas--");
        recompensas.add("Racha Interrumpible" + "\n --Mantén una racha de 10 días consecutivos--");
        recompensas.add("Planeación Anticipada" + "\n --Planifica todas las tareas de un mes completo con al menos una semana de anticipación--");
        recompensas.add("Balance de Vida" + "\n --Completa 5 días de racha consecutivos para objetivos de trabajo, salud y vida personal--");
        recompensas.add("Eficiencia" + "\n --Completa al menos una tarea diaria en menos de una hora cada día, durante una semana--");
        recompensas.add("Estrella de la Racha" + "\n --Mantén una racha de 365 días consecutivos--");
    }

    // Método para marcar una recompensa como completada
    public void completarRecompensa(String recompensa) {
        if (recompensas.contains(recompensa)) {
            recompensas.remove(recompensa);
            recompensasAdquiridas.add(recompensa);
            System.out.println("Logro obtenido: " + recompensa);
        } else {
            System.out.println("El logro ya fue completado.");
        }
    }
}

