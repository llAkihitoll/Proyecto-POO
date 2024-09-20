//Librerias adicionales necesarias
import java.util.ArrayList;
//Clase que representa usuario para los perfiles
public class Usuario {
//Atributos
    private String nombreUsuario; //nombre de usuario
    private int rachaDeDias; //Numero de dias  consecutivos que el usuario ha completado sus tareas asignadas.
    private ArrayList<Tarea>tareas; //Lista de longitud indefinida con las tareas asignadas.
    private ArrayList<Badges>badges; //Lista de longitud indefinida con los badges del usuario.
    
//Constructor por defecto
public Usuario() {
    this.nombreUsuario = "";
    this.rachaDeDias = 0;
    this.tareas = new ArrayList<>();
    this.badges = new ArrayList<>();
}


//constructor para usuarios
    public Usuario(String nombreUsuario, int rachaDeDias) {
        this.nombreUsuario = nombreUsuario;
        this.rachaDeDias = rachaDeDias;
        this.tareas = new ArrayList<>();
        this.badges = new ArrayList<>();
    }

//Metodos
    //Set&get
    //nombreUsuario
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
    public String getNombreUsuario() {
        return nombreUsuario;
    }
    //rachaDeDias
    public void setRachaDeDias(int rachaDeDias) {
        this.rachaDeDias = rachaDeDias;
    }
    public int getRachaDeDias() {
        return rachaDeDias;
    }
    //tareas
    public void setTareas(ArrayList<Tarea> tareas) {
        this.tareas = tareas;
    }
    public ArrayList<Tarea> getTareas() {
        return tareas;
    }
    //badges
    public void setBadges(ArrayList<Badges> badges) {
        this.badges = badges;
    }
    public ArrayList<Badges> getBadges() {
        return badges;
    }

}