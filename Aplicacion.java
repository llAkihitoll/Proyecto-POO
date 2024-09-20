public class Aplicacion {
    Usuario usuarioactual;
    Horario horario;
    Pomodoro pomodoro;
    Tarea nuevatarea;

    public Aplicacion(){
        usuarioactual = new Usuario();
        pomodoro = new Pomodoro();
    }

    public String IniciarPomodoro(int intervaloTrabajo){
        String mensaje = "";
        pomodoro.setIntervaloTrabajo(intervaloTrabajo);
        long minutosaNano = intervaloTrabajo * 60 * 1_000_000_000L;
        long inicio = System.nanoTime();
        long fin = inicio + minutosaNano;

        while (System.nanoTime() < fin) {
            mensaje = "El pomodoro esta en marcha";
        }
        
        mensaje = "El pomodoro ha terminado";
        return mensaje;
    }

    public String IniciarDescanso(int intervaloDescanso){
        String mensaje = "";
        pomodoro.setIntervaloDescanso(intervaloDescanso);
        long minutosaNano = intervaloDescanso * 60 * 1_000_000_000L;
        long inicio = System.nanoTime();
        long fin = inicio + minutosaNano;

        while (System.nanoTime() < fin) {
            mensaje = "El descanso esta en marcha";
        }
        
        mensaje = "El descanso ha terminado";
        return mensaje;
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
