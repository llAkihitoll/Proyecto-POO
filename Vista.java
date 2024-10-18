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

           iniciar_sesion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                ventana_inicio_sesion();
            }
           });

           registrarse.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ventana_registro();
            }
           });

    }

    /**
     * 
     */
    public void ventana_inicio_sesion(){
        /**
         * Crear una nueva ventana para llevar a cabo el incio de sesión 
         */
        JFrame inicio_sesion = new JFrame();
        inicio_sesion.setTitle("App menajo del tiempo - Inicio sesión");
        inicio_sesion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        inicio_sesion.setSize(500, 250);
        inicio_sesion.setVisible(true);

        /**
         * Crear panel para agregar los componentes de la ventana
         */
        JPanel interaccion_inicio_sesion = new JPanel();
        interaccion_inicio_sesion.setLayout(new GridLayout(2,2));

        /**
         * Crear las componentes del panel: etiquetas de texto para indicar que se debe ingresar en cada campo de texto y dichos campos de texto
         */
        JLabel nom_usuario = new JLabel("Ingrese nombre de usuario");
        JLabel contrasena = new JLabel("Ingrese contraseña");

        JTextField ing_nom_usuario = new JTextField(20);
        JTextField ing_contrasena = new JTextField(20);

        /**
         * Agregar las componentes al panel
         */
        interaccion_inicio_sesion.add(nom_usuario); // se agrega a la fila 1 columna 1
        interaccion_inicio_sesion.add(ing_nom_usuario); //se agrega a la fila 1 columna 2
        interaccion_inicio_sesion.add(contrasena); //se agrega a la fila 2 columna 1
        interaccion_inicio_sesion.add(ing_contrasena); //se agrega a la fila 2 columna 2

        /**
         * Crear un botón de confirmacion 
         */
        JButton confirmacion = new JButton("Aceptar");
        confirmacion.setSize(200,100);

        /**
         * Agregar el panel y boton de confirmacion a la ventana
         */
        inicio_sesion.add(interaccion_inicio_sesion, BorderLayout.CENTER);
        inicio_sesion.add(confirmacion, BorderLayout.SOUTH);

        confirmacion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                ventana_principal();
            }
        });

    }

    /**
     * metodo para abrir una nueva ventana y poder realizar el registro de un nuevo usuario cuando ese boton sea oprimido en la ventana inicial
     */
    public void ventana_registro(){
        /**
         * Crear una nueva ventana para poder llevar a cabo el registro
         */
        JFrame registro = new JFrame();
        registro.setTitle("App manejo del tiempo - Registro");
        registro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        registro.setSize(500, 250);
        registro.setVisible(true);

        /**
         * Crear panel para agregar los componentes de la ventana
         */
        JPanel interaccion_registro = new JPanel();
        interaccion_registro.setLayout(new GridLayout(3,2));

        /**
         * Crear las componentes del panel: etiquetas de texto para indicar que se debe ingresar en cada campo de texto y dichos campos de texto
         */
        JLabel nom_usuario = new JLabel("Ingrese su nombre de usuario");
        JLabel contrasena = new JLabel("Ingrese su contraseña");
        JLabel confirm_contrasena = new JLabel("Confirme su contraseña");

        JTextField ing_nom_usuario = new JTextField(20);
        JTextField ing_contrasena = new JTextField(20);
        JTextField ing_confirm_contrasena = new JTextField(20);
        
         /**
         * Usar la informacion para poder pasarla a String y que el programa lo entienda
         */
        String Nombre = ing_nom_usuario.getText();
        String Clave = ing_contrasena.getText();
          /**
         * Guardar los componentes del usuario 
         */
        Usuario nuevoUsuario = new Usuario( Nombre , Clave , 0);

        /**
         * Agregar las componentes al panel
         */
        interaccion_registro.add(nom_usuario); //se agrega a la primera fila primera columna
        interaccion_registro.add(ing_nom_usuario); //se agrega a la primera fila segunda columna
        interaccion_registro.add(contrasena); //se agrega a la segunda fila primera columna
        interaccion_registro.add(ing_contrasena); //se agrega a la segunda fila segunda columna
        interaccion_registro.add(confirm_contrasena); //se agrega a la tercera fila primera columna
        interaccion_registro.add(ing_confirm_contrasena); //se agrega a la tercera fila segunda columna

        /**
         * Crear un botón de confirmacion 
         */
        JButton confirmacion = new JButton("Aceptar");
        confirmacion.setSize(200,100);

        /**
         * Agregar el panel y el boton de confirmacion a la ventana
         */
        registro.add(interaccion_registro, BorderLayout.CENTER);
        registro.add(confirmacion, BorderLayout.SOUTH);

        confirmacion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                ventana_principal();
            }
        });
    }

    public void ventana_principal(){
        /**
         * Crear una nueva ventana para poder llevar a cabo el registro
         */
        JFrame principal = new JFrame();
        principal.setTitle("App manejo del tiempo - Principal");
        principal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        principal.setSize(800, 500);
        principal.setVisible(true);

        /**
         * Crear un nuevo panel para poder agregar el calendario
         */
        JPanel dias = new JPanel();
        dias.setLayout(new GridLayout(6, 7));

        /**
         * Crear las etiquetas de texto del panel
         */
        JLabel lunes = new JLabel("LU");
        JLabel martes = new JLabel("MA");
        JLabel miercoles = new JLabel("MI");
        JLabel jueves = new JLabel("JU");
        JLabel viernes = new JLabel("VI");
        JLabel sabado = new JLabel("SA");
        JLabel domingo = new JLabel("DO");

        /**
         * Agregar las etiquetas de texto al panel
         */
        dias.add(domingo);
        dias.add(lunes);
        dias.add(martes);
        dias.add(miercoles);
        dias.add(jueves);
        dias.add(viernes);
        dias.add(sabado);

        /**
         * Crear y agregar los botones de días al panel
         */
        for (int i = 0; i<2; i++){
            JButton botonvacio = new JButton("");
            dias.add(botonvacio);
        }
        for(int i = 0; i<31; i++){
            JButton botondia = new JButton("Octubre " + (i+1));
            botondia.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    ventana_dia();
                }
            });
            dias.add(botondia);
        }
        for (int i = 0; i<2; i++){
            JButton botonvacio = new JButton("");
            dias.add(botonvacio);
        }

        /**
         * Crear otro panel para poder tener la lista de tareas proximas, medallas y el boton de medallas
         */
        JPanel listas = new JPanel();
        listas.setLayout(new GridLayout(3,1));

        /**
         * Crear las componentes del nuevo panel (listas y boton)
         */
        String[] tareas = {"Tarea 1", "Tarea 2", "Tarea 3"};
        JList<String> lista_tareas = new JList<>(tareas);
        JScrollPane scrollPane1 = new JScrollPane(lista_tareas);

        String[] medallas = {"Medalla 1", "Medalla 2", "Medalla 3"};
        JList<String> lista_medallas = new JList<>(medallas);
        JScrollPane scrollPane2 = new JScrollPane(lista_medallas);

        JButton bmedallas = new JButton("Medallas");

        /**
         * Agregar las componentes al panel
         */
        listas.add(scrollPane1);
        listas.add(scrollPane2);
        listas.add(bmedallas);

        /**
         * Crear un boton para salir
         */
        JButton salir = new JButton("Salir");

        /**
         * Agregar los paneles y el boton a la ventana
         */
        principal.add(dias,BorderLayout.CENTER);
        principal.add(listas, BorderLayout.EAST);
        principal.add(salir, BorderLayout.SOUTH);
        
    }

    public void ventana_dia(){
        /**
         * Crear ventana para mostrar las tareas del día y poder agregar nuevas tareas o iniciar un pomodoro
         */
        JFrame ventanadia = new JFrame();
        ventanadia.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventanadia.setSize(300, 200);
        ventanadia.setVisible(true);

        /**
         * Crear un panel para colocar las tareas del día en un scrollpane
         */
        JPanel lista_tareas = new JPanel();

        /**
         * Crear la componente del panel que será una lista
         */
        String[] tareas = {"Tarea 1", "Tarea 2", "Tarea 3"};
        JList<String> usuario_tareas = new JList<>(tareas);
        JScrollPane scrollPane1 = new JScrollPane(usuario_tareas);

        /**
         * Agregar la lista al panel
         */
        lista_tareas.add(scrollPane1);

        /**
         * Crear un nuevo panel para colocar los botones para agregar tarea e iniciar un nuevo pomodoro
         */
        JPanel opciones = new JPanel();
        opciones.setLayout(new GridLayout(2, 1));

        /**
         * Crear las componentes del panel
         */
        JButton agregar_tarea = new JButton("Agregar tarea");
        JButton pomodoro =  new JButton("Pomodoro");

        /**
         * Agregar los botones al panel
         */
        opciones.add(agregar_tarea);
        opciones.add(pomodoro);
        
        /**
         * Crear un boton para salir
         */
        JButton salir = new JButton("Salir");

        /**
         * Agregar los paneles y el boton de salir a la ventana
         */
        ventanadia.add(lista_tareas, BorderLayout.CENTER);
        ventanadia.add(opciones, BorderLayout.EAST);
        ventanadia.add(salir, BorderLayout.SOUTH);

        pomodoro.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                ventana_pomodoro();
            }
        });
        agregar_tarea.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                ventana_anadir_tarea();
            }
        });
    }

    public void ventana_pomodoro(){
        /**
         * Crear una nueva ventana
         */
        Aplicacion app = new Aplicacion();
        JFrame ventanapomodoro = new JFrame();
        ventanapomodoro.setTitle("Pomodoro");
        ventanapomodoro.setSize(350, 200);
        ventanapomodoro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventanapomodoro.setVisible(true);

        /**
         * Crear un nuevo panel para colocar la informacion sobre el pomodoro
         */
        JPanel mostrar = new JPanel();
        mostrar.setLayout(new GridLayout(2,1));

        /**
         * Crear el texto que aparecerá en el panel, implementando un metodo de la clase Aplicacion
         */
        JLabel texto1 = new JLabel(app.IniciarPomodoro(1));

        /**
         * Agregar el texto al panel
         */
        mostrar.add(texto1);

        /**
         * Agregar el panel a la ventana
         */
        ventanapomodoro.add(mostrar);
        
    }

    public void ventana_anadir_tarea(){
        /**
         * Crear un nueva ventana
         */
        JFrame anadir_tarea = new JFrame();
        anadir_tarea.setTitle("Añadir tarea");
        anadir_tarea.setSize(600, 300);
        anadir_tarea.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        anadir_tarea.setVisible(true);

        /**
         * Crear un nuevo panel para colocar las etiquetas y los campos de texto
         */
        JPanel info_tarea = new JPanel();
        info_tarea.setLayout(new GridLayout(5,2));
        /**
         * Crear las componentes del panel (etiquetas y campos de texto)
         */
        JLabel nombre = new JLabel("Ingrese el nombre de la tarea");
        JLabel prioridad = new JLabel("Ingrese la prioridad de la tarea");
        JLabel duracion = new JLabel("Ingrese la duracion de la tarea");
        JLabel detalles = new JLabel("Ingrese los detalles de la tarea");

        JTextField ing_nombre = new JTextField(20);
        JTextField ing_prioridad = new JTextField(20);
        JTextField ing_duracion = new JTextField(20);
        JTextField ing_detalles = new JTextField(20);

        /**
         * Añadir las componentes al panel
         */
        info_tarea.add(nombre);
        info_tarea.add(ing_nombre);
        info_tarea.add(prioridad);
        info_tarea.add(ing_prioridad);
        info_tarea.add(duracion);
        info_tarea.add(ing_duracion);
        info_tarea.add(detalles);
        info_tarea.add(ing_detalles);


        /**
         * Crear un boton para salir
         */
        JButton salir = new JButton("Salir");

        /**
         * Añadir el panel y el boton a la ventana
         */
        anadir_tarea.add(info_tarea, BorderLayout.CENTER);
        anadir_tarea.add(salir, BorderLayout.SOUTH);


    }

    public static void main(String[] args) {
        Vista prueba = new Vista();
    }
}
