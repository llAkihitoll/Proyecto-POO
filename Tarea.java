
//Clase que representa las tareas asignadas del usuario.

import java.util.ArrayList;

public class Tarea {
//Atributos
    private String nombreTarea;     //El nombre de la tarea
    private int prioridad;          //la prioridad de la tarea
    private double duracion;        //la duracion de la tarea en minutos
    private boolean completado;     //Si es verdadero la tarea está completada, si es falso no está completada
    private String detalles;        //Descripción o comentarios sobre la tarea.
    
//Constructor para Tarea
    public Tarea(String nombreTarea, int prioridad,  double duracion, boolean completado, String detalles) {

        this.nombreTarea = nombreTarea;
        this.prioridad = prioridad;
        this.duracion = duracion;
        this.completado = completado;
        this.detalles = detalles;
    }
//metodos

}
