import java.util.List;

public class Horario {
    private List<Tarea> listaTareas;

    public Horario(List<Tarea> listaTareas) {
        this.listaTareas = listaTareas;
    }

    public Horario(){
        
    }

    public List<Tarea> getListaTareas() {
        return listaTareas;
    }

    public void setListaTareas(List<Tarea> listaTareas) {
        this.listaTareas = listaTareas;
    }
}