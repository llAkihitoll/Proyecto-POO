//Librerias de MYSQL
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/*
 * Clase de conexion de base de datos
 */
public class ConexionBaseDeDatos {

/*
 * Metodo de conexion
 */
    public static Connection conectar() {
        String url = "jdbc:mysql://localhost:3306/proyectopoo"; // URL de la base de datos
        String usuario = "root";  // Usuario de MYSQL
        String contrasena = "MYSQL_pass04132";  // password de MYSQL

        Connection conexion = null;
        try {
            // Establece la conexión
            conexion = DriverManager.getConnection(url, usuario, contrasena);
            System.out.println("Conexion exitosa a la base de datos.");
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        }
        return conexion;
    }
}
