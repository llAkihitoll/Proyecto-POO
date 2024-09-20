public class Aplicacion {
    Usuario usuarioactual;
    Horario horario;
    Pomodoro pomodoro;
    Tarea nuevatarea;

    public Aplicacion(){
        usuarioactual = new Usuario();
    }

    public String IniciarPomodoro(int intervaloTrabajo){
        String mensaje = "";
        pomodoro = new Pomodoro();
        pomodoro.setIntervaloTrabajo(intervaloTrabajo);
        long minutosNano = intervaloTrabajo * 60 * 1_000_000_000L;
        long inicio = System.nanoTime();
        long fin = inicio + minutosNano;

        while (System.nanoTime() < fin) {
            mensaje = "El pomodoro esta en marcha";
        }
        
        mensaje = "El pomodoro ha terminado";
        return mensaje;
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
