
/*
 * Clase que representa una tarea.
 * Cada tarea tiene: nombre, prioridad, duración, estado, detalles.
 * 
 * @author Javier Chávez
 */
public class Tarea {
    /**
     * Nombre de la tarea
     */
        private String nombreTarea; 
    /**
     * Nombre de la tarea
     */
        private int prioridad;          
    /**
     * la duracion de la tarea en minutos
     */
        private double duracion;        
    /**
     * Estado de la tarea, si es verdadero la tarea está completada, si es falso no está completada
     */
        private boolean completado;     
    /**
     * Descripción o comentarios sobre la tarea.
     */
        private String detalles;        
    
    /**
     * Crea una tarea sin nombre, prioridad, duracion ni detalles, que no está completada.
     */
    public Tarea() {

    }
    /**
     * Crea una tarea con nombre, prioridad, duracion, estado y detalles
     * @param nombreTarea
     * @param prioridad
     * @param duracion
     * @param completado
     * @param detalles
     */
        public Tarea(String nombreTarea, int prioridad,  double duracion, String detalles) {
    
            this.nombreTarea = nombreTarea;
            this.prioridad = prioridad;
            this.duracion = duracion;
            this.completado = false;
            this.detalles = detalles;
        }

    //Set&Get
    /**
     * Establece el nombre de la tarea
     * 
     * @param nombreTarea
     */
        public void setNombreTarea(String nombreTarea) {
            this.nombreTarea = nombreTarea;
        }
    /**
     * Obtiene el nombre de la tarea
     * @return nombreTarea
     */
        public String getNombreTarea() {
            return nombreTarea;
        }
    /**
     *  Establece la prioridad de la tarea
     * 
     * @param prioridad
     */
        public void setPrioridad(int prioridad) {
            this.prioridad = prioridad;
        }
    /**
     * Obtiene la prioridad de la tarea
     * @return prioridad
     */
        public int getPrioridad() {
            return prioridad;
        }
    /**
     *  Establece la duración de la tarea
     * 
     * @param duracion
     */
        public void setDuracion(double duracion) {
            this.duracion = duracion;
        }
    /**
     * Obtiene la duración de la tarea
     * @return duracion
     */
        public double getDuracion() {
            return duracion;
        }
    /**
     *   Establece el estado de la tarea
     * 
     * @param completado
     */
        public void setCompletado(boolean completado) {
            this.completado = completado;
        }
    /**
     * Obtiene el estado de la tarea
     * @return completado
     */
        public boolean getCompletado(){
            return completado;
        }
    /**
     *  Obtiene la descripción de la tarea
     * 
     * @param detalles
     */
        public void setDetalles(String detalles) {
            this.detalles = detalles;
        }
    /**
     * Obtiene los detalles de la tarea
     * @return detalles
     */
        public String getDetalles() {
            return detalles;
        }
    }