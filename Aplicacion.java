public class Aplicacion {
    private Usuario usuarioactual;
    private Horario horario;
    private Pomodoro pomodoro;
    private Tarea nuevatarea;
    static private Badges nuevarecompensa;

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
        IniciarPomodoro(pomodoro.getIntervaloTrabajo());
        IniciarDescanso(pomodoro.getIntervaloDescanso());
    }

    public void MarcarCompletado(String nombredetarea){
        String nom = nombredetarea.toLowerCase();
        for(Tarea i : usuarioactual.getTareas()){
            String nom1 = i.getNombreTarea().toLowerCase();
            if(nom1.equals(nom)){
                i.setCompletado(true);
            }
        }
    }

    public String obtenerDetalles(String nombredetarea){
        String mensaje = "";
        String nom = nombredetarea.toLowerCase();
        for(Tarea i : usuarioactual.getTareas()){
            String nom1 = i.getNombreTarea().toLowerCase();
            if(nom1.equals(nom)){
                mensaje = i.getDetalles();
            }
        }
        return mensaje;
    }

    public Horario MostrarHorario(){

    }

    public void VerificarRecompensa(){

    }

    public Badges MostrarRecompensa(){

    }


}
