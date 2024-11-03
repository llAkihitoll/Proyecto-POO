/** Librerias adicionales necesarias 
 * 
*/
import java.util.ArrayList;
/*
 * Clase que representa un Usuario.
 * Cada usuario tiene: Nombre, número de días de racha, una lista de tareas y una lista de badges.
 * 
 * @author Javier Chávez
 */
public class Usuario {
//Atributos
    /**
     * Nombre de usuario
     */
    private String nombreUsuario; 
    /**
     * Contraseña  de usuario
     */
    private String claveusuario;
    /**
     * Numero de dias consecutivos que el usuario ha completado sus tareas asignadas.
     */
    private int rachaDeDias; 
    /**
     * Lista de longitud indefinida con las tareas asignadas.
     */
    private ArrayList<Tarea>[] tareas; 
    /**
     * Lista de longitud indefinida con los badges del usuario.
     */
    private ArrayList<Badges>badges; 

/**
 * Crea un usuario sin nombre ni dias de racha.
 */
public Usuario() {
    this.nombreUsuario = "";
    this.claveusuario = "";
    this.rachaDeDias = 0;
    this.tareas = new ArrayList<Tarea>[31];
    this.badges = new ArrayList<>();
}
/**
 *  Crea un usuario con nombre y dias de racha.
 * 
 * @param nombreUsuario
 * @param rachaDeDias
 */
    public Usuario(String nombreUsuario,String claveusuario, int rachaDeDias) {
        this.nombreUsuario = nombreUsuario;
        this.claveusuario = claveusuario;
        this.rachaDeDias = rachaDeDias;
        this.badges = new ArrayList<>();
    }
/**
 * Establece el nombre del usuario
 * @param nombreUsuario
 */
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
/**
 *  Obtiene el nombre del usuario
 *
 * @return ClaveUsuario
 */
    public String getNombreUsuario() {
        return nombreUsuario;
    }
    /**
 * Establece la calve del usuario
 * @param nombreUsuario
 */
    public void setClaveUsuario(String claveusuario) {
        this.claveusuario = claveusuario;
    }
/**
 *  Obtiene la clave del usuario
 *
 * @return claveusuario
 */
    public String getClaveUsuario() {
        return claveusuario;
    }
    
/**
 *  Establece los dias de racha que tiene el usuario.
 *
 * @param rachaDeDias
 */
    public void setRachaDeDias(int rachaDeDias) {
        this.rachaDeDias = rachaDeDias;
    }
    
/**
 * Obtiene los dias de racha que tiene el usuario.
 * 
 * @return rachaDeDias
 */
    public int getRachaDeDias() {
        return rachaDeDias;
    }
/**
 * Establece la lista de tareas del usuario
 * 
 * @param tareas
 */
    public void setTareas(ArrayList<Tarea>[] tareas) {
        this.tareas = tareas;
    }
/**
 * Obtiene la lista de tareas del usuario
 * @return <Tarea>
 */
    public ArrayList<Tarea>[] getTareas() {
        return tareas;
    }
/**
 *  Establece la lista de tareas completadas del usuario
 * 
 * @param badges
 */
    public void setBadges(ArrayList<Badges> badges) {
        this.badges = badges;
    }
/**
 * Obtiene los badges del usuario
 * @return <badges>
 */
    public ArrayList<Badges> getBadges() {
        return badges;
    }
}
