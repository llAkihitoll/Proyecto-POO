public class Horario {
    private List<Tarea> listaTareas;

    public Horario(List<Tarea> listaTareas) {
        this.listaTareas = listaTareas;
    }

    // Constructor por defecto
    public Horario() {
        this.listaTareas = new ArrayList<>();
    }
}
