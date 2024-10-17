import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Vista  extends JFrame{
    public Vista(){
        /**
         * Crear la ventana que se desplegará cuando el ususario inicie la aplicación
         * En esta se le preguntará si desea registrarse o iniciar sesión
         */
        JFrame ingreso = new JFrame();
        ingreso.setTitle("App manejo de tiempo");
        ingreso.setVisible(true);
        ingreso.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ingreso.setSize(400,300);

        /**
         * Crear un nuevo panel para poder agregar el texto para comunicarse con el usuario y los botones para que decida que hacer
         */
        JPanel interaccion_ingreso = new JPanel();
        interaccion_ingreso.setLayout(new GridLayout(3,1)); 

        /**
         * Crear la etiqueta de texto para informarle al usuario que esta es la ventana de ingreso
         */

         JLabel info = new JLabel("Bienvenido al programa de manejo de tiempo");

         /**
          * Crear botones para que el usuario elija si desea iniciar sesión o registrarse
          * Es decir, si ya tiene usuario o quiere crear uno
          */

          JButton iniciar_sesion = new JButton("Iniciar sesión");
          JButton registrarse = new JButton("Registrarse");

          /**
           * Agregar las componentes al panel (importa el orden)
           */
           interaccion_ingreso.add(info); //se agrega a la primera fila
           interaccion_ingreso.add(iniciar_sesion); // se agrega a la segunda fila
           interaccion_ingreso.add(registrarse); // se agrega a la tercera fila

           /**
            * Agregar el panel la ventana
            */
           ingreso.add(interaccion_ingreso);

    }

    public static void ventana_inicio_sesion(){
        JFrame inicio_de_sesion = new JFrame();
        inicio_de_sesion.setTitle("App manejo de tiempo - Iniciar sesión");
        inicio_de_sesion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        inicio_de_sesion.setSize(350, 250);
        inicio_de_sesion.setVisible(true);

        
    }

    public static void main(String[] args) {
        Vista prueba = new Vista();
    }
}