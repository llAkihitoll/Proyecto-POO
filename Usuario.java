/** Librerias adicionales necesarias 
 * 
*/
import java.util.ArrayList;
import java.util.List;
/*
 * Clase que representa un Usuario.
 * Cada usuario tiene: Nombre, número de días de racha, una lista de tareas y una lista de badges.
 * 
 * @author Javier Chávez / modificado por Rodrigo Ajmac
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
    private List<ArrayList<Tarea>> tareas; 
    /**
     * Lista de longitud indefinida con los badges del usuario.
     */
    private ArrayList<Badges>badges; 

/**
 * Crea un usuario sin nombre ni dias de racha.
 */
public Usuario() {
    List<ArrayList<Tarea>> lista = new ArrayList<>();
    for (int i = 0; i < 31; i++) {
        lista.add(new ArrayList<Tarea>());
    }
    this.rachaDeDias = 0;
    this.tareas = lista;
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
 * Obtiene la lista de tareas del usuario
 * @return <Tarea>
 */
    public List<ArrayList<Tarea>> getTareas() {
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

    public List<ArrayList<String>> nomyprioridad(){
        List<ArrayList<String>> nombreyprioridad = new ArrayList<>();
        for (int j = 0; j < 31; j++) {
            nombreyprioridad.add(new ArrayList<>());
        }
        int j=0;
        for(ArrayList<Tarea> i : tareas){
            for(Tarea k : i){
                String info = k.getNombreTarea() + " " + k.getPrioridad();
                nombreyprioridad.get(j).add(info);
            }
            j = j + 1;
        }

        return nombreyprioridad;
    } 

    public void agregartarea(int pos, Tarea tarea){
        tareas.get(pos).add(tarea);
    }

    public ArrayList<String> tareasprox(){
        ArrayList<String> lista = new ArrayList<>();
        for(ArrayList<Tarea> i :  tareas){
            for(Tarea k : i){
                if((k.getPrioridad() == 3) && (k.getCompletado() == false)){
                    String mensaje = k.getNombreTarea() + " " + k.getPrioridad();
                    lista.add(mensaje);
                }
            }
        }
        return lista;
    }
}
