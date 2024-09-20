public class Aplicacion {
    Usuario usuarioactual;
    Horario horario;
    Pomodoro pomodoro;
    Tarea nuevatarea;

    public Aplicacion(){
        usuarioactual = new Usuario();
    }

    public void IniciarPomodoro(){
        pomodoro = new Pomodoro();

    }

    public void IniciarDescanso(){

    }

    public void AddTarea(String nombreTarea, int prioridad,  double duracion, String detalles){
        nuevatarea = new Tarea();
        nuevatarea.setNombreTarea(nombreTarea);
        nuevatarea.setPrioridad(prioridad);
        nuevatarea.setDuracion(duracion);
        nuevatarea.setDetalles(detalles);
        usuarioactual.getTareas().add(nuevatarea);
    }

    public void ReiniciarPomodoro(){

    }

    public void MarcarCompletado(){

    }

    public String obtenerDetalles(){

    }

    public Horario MostrarHorario(){

    }

    public void VerificarRecompensa(){

    }

    public Badges MostrarRecompensa(){

    }


}
