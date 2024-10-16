public class Aplicacion {
    /**
     * Atributos utilizados para el controlador del programa
     */
    private Usuario usuarioactual; //se utilizará para crear un nuevo usuario
    private Horario horario; //se utilizará para generar un nuevo horario según las tareas pendientes
    private Pomodoro pomodoro; //se utilizará para crear un nuevo pomodoro
    private Tarea nuevatarea; //se utilizará para crear una nueva tarea
    //static private Badges nuevarecompensa;

    /**
     * Metodo "constructor" de la clase, se utilizará para acceder a todos los métodos desde el main
     */
    public Aplicacion(){
        usuarioactual = new Usuario();
        pomodoro = new Pomodoro();
        horario = new Horario();

    }

    /**
     * Metodo para crear un nuevo usuario
     */
    public void AgregarUsuario(String nombreUsuario){
        usuarioactual.setNombreUsuario(nombreUsuario);
    }

    /**
     * Metodo para iniciar un nuevo pomodoro
     * 
     * @return un mensaje que indica cuando ha finalizado el pomodoro
     */
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

    /**
     * Metodo para iniciar un nuevo descanso
     * 
     * @return un mensaje que indica cuando ha finalizado el descanso
     */
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

    /**
     * Metodo para agregar una tarea
     */
    public void AddTarea(String nombreTarea, int prioridad,  double duracion, String detalles){
        nuevatarea = new Tarea();
        nuevatarea.setNombreTarea(nombreTarea);
        nuevatarea.setPrioridad(prioridad);
        nuevatarea.setDuracion(duracion);
        nuevatarea.setDetalles(detalles);
        usuarioactual.getTareas().add(nuevatarea);
    }

    /**
     * Metodo para reiniciar el pomodoro
     */
    public void ReiniciarPomodoro(){
        IniciarPomodoro(pomodoro.getIntervaloTrabajo());
        IniciarDescanso(pomodoro.getIntervaloDescanso());
    }

    /**
     * Metodo para marcar como completada una tarea
     */
    public void MarcarCompletado(String nombreTarea){
        String nom = nombreTarea.toLowerCase();
        for(Tarea i : usuarioactual.getTareas()){
            String nom1 = i.getNombreTarea().toLowerCase();
            if(nom1.equals(nom)){
                i.setCompletado(true);
            }
        }
    }

    /**
     * Metodo para obtener detalles de una tarea
     * 
     * @return detalles de la tarea 
     */
    public String obtenerDetalles(String nombreTarea){
        String mensaje = "";
        String nom = nombreTarea.toLowerCase();
        for(Tarea i : usuarioactual.getTareas()){
            String nom1 = i.getNombreTarea().toLowerCase();
            if(nom1.equals(nom)){
                mensaje = i.getDetalles();
            }
        }
        return mensaje;
    }

    /**
     * Metodo para generar un horario a partir de las tareas del usuario
     * 
     * @return horario generado
     */
    public Horario MostrarHorario(){
        for(Tarea i : usuarioactual.getTareas()){
            int cond = i.getPrioridad();
            if(cond==1 && (i.getCompletado() == false)){
                horario.getListaTareas().add(i);
            }
        }

        for(Tarea j : usuarioactual.getTareas()){
            int cond = j.getPrioridad();
            if(cond==2 && (j.getCompletado() == false)){
                horario.getListaTareas().add(j);
            }
        }

        for(Tarea k : usuarioactual.getTareas()){
            int cond = k.getPrioridad();
            if(cond==3 && (k.getCompletado() == false)){
                horario.getListaTareas().add(k);
            }
        }

        return horario;
    }

    public void VerificarRecompensa(){

    }
/* arreglar
    public void MostrarRecompensa(){
    
    }
*/

}
