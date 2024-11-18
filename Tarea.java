
/*
 * Clase que representa una tarea.
 * Cada tarea tiene: nombre, prioridad, duración, estado, detalles.
 * 
 * @author Javier Chávez
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
    /**
     * Guarda la tarea en la base de datos.
     *
     * @param idUsuario ID del usuario al que pertenece la tarea.
     * @return true si la tarea se guardó correctamente, false en caso contrario.
     */
    public boolean guardarTarea(int idUsuario) {
        String sql = "INSERT INTO tareas (id_usuario, descripcion, estado, fecha_inicio, fecha_fin) " +
                     "VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = ConexionBaseDeDatos.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, idUsuario); // ID del usuario
            pstmt.setString(2, this.nombreTarea); // Descripción de la tarea (puedes combinar nombre y detalles si lo prefieres)
            pstmt.setString(3, this.completado ? "completada" : "pendiente"); // Estado de la tarea
            pstmt.setTimestamp(4, java.sql.Timestamp.valueOf(java.time.LocalDateTime.now())); // Fecha de inicio
            pstmt.setTimestamp(5, null); // Fecha de fin, por defecto null

            pstmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    }