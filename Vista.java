import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Vista  extends JFrame{
    private Aplicacion app ;
    private JFrame ingreso, inicio_sesion, registro;
    private JPanel interaccion_ingreso, interaccion_inicio_sesion, interaccion_registro;
    private JButton iniciar_sesion, registrarse;
    private DefaultListModel<String> modelolista, modelolista2;
    public Vista(){
        app = new Aplicacion();
        /**
         * Crear la ventana que se desplegará cuando el ususario inicie la aplicación
         * En esta se le preguntará si desea registrarse o iniciar sesión
         */
        ingreso = new JFrame();
        ingreso.getContentPane().setBackground(Color.WHITE);
        ingreso.setTitle("App manejo de tiempo");
        ingreso.setVisible(true);
        ingreso.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ingreso.setSize(450,600);

        /**
         * Crear un nuevo panel para poder agregar el texto para comunicarse con el usuario y los botones para que decida que hacer
         */
        interaccion_ingreso = new JPanel();
        ingreso.getContentPane().setBackground(new Color(36, 123, 160)); // Cambiar el color del fondo 
        interaccion_ingreso.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); 

        ImageIcon icono = new ImageIcon("tomate.png");
        JLabel imagen = new JLabel(icono);
        gbc.gridx=0;
        gbc.gridy=0;
        gbc.gridwidth=2;
        interaccion_ingreso.add(imagen, gbc);
        interaccion_ingreso.setBackground(new Color(194,194,209));// Fondo de pantalla inicial 
        
        /**
         * Crear la etiqueta de texto para informarle al usuario que esta es la ventana de ingreso
         */
         JLabel info = new JLabel("Bienvenido a Tomate tu tiempo");
         info.setFont(new Font("Arial", Font.PLAIN, 18)); // Cabiar el tama;o y el font de el mensaje de inicio 
         gbc.gridx = 0;
         gbc.gridy = 1;
         gbc.gridwidth = 2;
         interaccion_ingreso.add(info, gbc); //se agrega a la primera fila


         /**
          * Crear botones para que el usuario elija si desea iniciar sesión o registrarse
          * Es decir, si ya tiene usuario o quiere crear uno
          */

          iniciar_sesion = new JButton("Iniciar sesión");
          iniciar_sesion.setBackground(new Color(36, 123, 160));// Cambiar el color del boton 
          iniciar_sesion.setForeground(Color.WHITE); // Cambiar el color de la letra a blanco 
          gbc.gridx = 0;
          gbc.gridy = 2;
          gbc.gridwidth = 2;
          interaccion_ingreso.setPreferredSize(new Dimension(150,50));
          interaccion_ingreso.add(iniciar_sesion, gbc); // se agrega a la segunda fila
          
          registrarse = new JButton("Registrarse");
          registrarse.setBackground(new Color(36, 123, 160));// Cambiar el color del boton 
          registrarse.setForeground(Color.WHITE);// Cambiar el color de la letra a blanco 
          gbc.gridx = 0;
          gbc.gridy = 3;
          gbc.gridwidth = 2;
          registrarse.setPreferredSize(new Dimension(115,27));
          interaccion_ingreso.add(registrarse, gbc); // se agrega a la tercera fila

           /**
            * Agregar el panel la ventana
            */
           ingreso.add(interaccion_ingreso);

           iniciar_sesion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                ventana_inicio_sesion();
                ingreso.dispose();
            }
           });

           registrarse.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ventana_registro();
                ingreso.dispose();
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
        inicio_sesion = new JFrame();
        inicio_sesion.setTitle("App manejo del tiempo - Inicio sesión");
        inicio_sesion.setBackground(new Color(246, 221, 176));
        inicio_sesion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        inicio_sesion.setSize(500, 250);
        inicio_sesion.setVisible(true);

        /**
         * Crear panel para agregar los componentes de la ventana
         */
        interaccion_inicio_sesion = new JPanel();
        interaccion_inicio_sesion.setBackground(new Color(246, 221, 176));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        interaccion_inicio_sesion.setLayout(new GridBagLayout());

        /**
         * Crear las componentes del panel: etiquetas de texto para indicar que se debe ingresar en cada campo de texto y dichos campos de texto
         */
        JLabel nom_usuario = new JLabel("Ingrese nombre de usuario: ");
        gbc.gridx = 0;
        gbc.gridy=0;
        interaccion_inicio_sesion.add(nom_usuario, gbc);

        JLabel contrasena = new JLabel("Ingrese contraseña: ");
        gbc.gridx = 0;
        gbc.gridy=1;
        interaccion_inicio_sesion.add(contrasena, gbc);

        JTextField ing_nom_usuario = new JTextField(20);
        ing_nom_usuario.setBackground(new Color(123, 197, 105));// Cambiar fondo del area de usuario
        gbc.gridx = 1;
        gbc.gridy=0;
        interaccion_inicio_sesion.add(ing_nom_usuario, gbc);

        JPasswordField ing_contrasena = new JPasswordField(20);
        ing_contrasena.setBackground(new Color(123, 197, 105));// cambiar fondo de el area de contrase;a 
        gbc.gridx = 1;
        gbc.gridy = 1;
        interaccion_inicio_sesion.add(ing_contrasena, gbc); //se agrega a la fila 2 columna 2

        /**
         * Crear un botón de confirmacion 
         */
        JButton confirmacion = new JButton("Aceptar");
        confirmacion.setPreferredSize(new Dimension(100,25));
        confirmacion.setBackground(new Color(36, 123, 160));//Cambiar el color del boton 
        confirmacion.setForeground(Color.WHITE);// Poner las letras de color blanco 
        gbc.gridx = 0;
        gbc.gridy=2;
        gbc.gridwidth = 2;
        interaccion_inicio_sesion.add(confirmacion, gbc);

         /**
         * Crear una accion para que la informacion se guarde luego de precionar el boton 
         */
        confirmacion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                 /**
                 * Usar la informacion del inicio de sesion  para poder pasarla a String y que el programa lo entienda
                 */
                String Nombre = ing_nom_usuario.getText();// obtener la informacion sacada de la interfaz (Nombre del usuario )
                //String Clave = ing_contrasena.getText();// obtener la informacion sacada de la interfaz (Clave del usuario )
                  /**
                 * Falta verificacion del usuario 
                 */
                app.buscarUsuario(Nombre);
            }
        });

        /**
         * Agregar el panel y boton de confirmacion a la ventana
         */
        inicio_sesion.add(interaccion_inicio_sesion, BorderLayout.CENTER);

        confirmacion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                ventana_principal();
                inicio_sesion.dispose();
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
        registro = new JFrame();
        registro.setTitle("App manejo del tiempo - Registro");
        registro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        registro.setBackground(new Color(246, 221, 176));
        registro.setSize(500, 250);
        registro.setVisible(true);

        /**
         * Crear panel para agregar los componentes de la ventana
         */
        interaccion_registro = new JPanel();
        interaccion_registro.setBackground(new Color(246, 221, 176));
        interaccion_registro.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        /**
         * Crear las componentes del panel: etiquetas de texto para indicar que se debe ingresar en cada campo de texto y dichos campos de texto
         */
        JLabel nom_usuario = new JLabel("Ingrese su nombre de usuario: ");
        gbc.gridx = 0;
        gbc.gridy=0;
        interaccion_registro.add(nom_usuario, gbc);

        JLabel contrasena = new JLabel("Ingrese su contraseña: ");
        gbc.gridx = 0;
        gbc.gridy=1;
        interaccion_registro.add(contrasena, gbc);

        JLabel confirm_contrasena = new JLabel("Confirme su contraseña");
        gbc.gridx = 0;
        gbc.gridy=2;
        interaccion_registro.add(confirm_contrasena, gbc);

        JTextField ing_nom_usuario = new JTextField(20);
        ing_nom_usuario.setBackground(new Color(123, 197, 105));
        ing_nom_usuario.setForeground(Color.black);
        gbc.gridx = 1;
        gbc.gridy=0;
        interaccion_registro.add(ing_nom_usuario, gbc);

        JPasswordField ing_contrasena = new JPasswordField(20);
        ing_contrasena.setBackground(new Color(123, 197, 105));
        ing_contrasena.setForeground(Color.black);
        gbc.gridx = 1;
        gbc.gridy=1;
        interaccion_registro.add(ing_contrasena, gbc);

        JPasswordField ing_confirm_contrasena = new JPasswordField(20);
        ing_confirm_contrasena.setBackground(new Color(123, 197, 105));
        ing_confirm_contrasena.setForeground(Color.black);
        gbc.gridx = 1;
        gbc.gridy=2;
        interaccion_registro.add(ing_confirm_contrasena, gbc);
        

        /**
         * Crear un botón de confirmacion 
         */
        JButton confirmacion = new JButton("Aceptar");
        confirmacion.setBackground(new Color(36, 123, 160));
        confirmacion.setForeground(Color.WHITE);
        gbc.gridx=0;
        gbc.gridy=3;
        gbc.gridwidth=2;
        interaccion_registro.add(confirmacion, gbc);

        /**
         * Crear una accion para que la informacion se guarde luego de precionar el boton 
         */
        /**
         * Agregar el panel y el boton de confirmacion a la ventana
         */
        registro.add(interaccion_registro);

        confirmacion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                
                ventana_principal();
                registro.dispose();
                app.AgregarUsuario(ing_nom_usuario.getText());
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
        principal.setSize(1000, 500);
        principal.setVisible(true);

        String[] tareas2 = app.getUsuario().tareasprox().toArray(new String[0]);
        modelolista = new DefaultListModel<>();
        modelolista.addElement("Tareas no completadas de alta prioridad");
        for(String i : tareas2){
            modelolista.addElement(i);
        }

        String[] medallas = app.getUsuario().getBadges().toArray(new String[0]);
        modelolista2 = new DefaultListModel<>();
        modelolista2.addElement("Medallas");
        for(String k : medallas){
            modelolista2.addElement(k);
        }

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
        for (int i = 0; i<5; i++){
            JButton botonvacio = new JButton("");
            dias.add(botonvacio);
        }
        for(int i = 0; i<30; i++){
            JButton botondia = new JButton("NOV " + (i+1));
            int k = i;
            botondia.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
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
                    JPanel lista_tareas = new JPanel(new GridBagLayout());
                    GridBagConstraints gbc = new GridBagConstraints();
                    gbc.insets = new Insets(5, 5, 5, 5); // Márgenes entre componentes

                    /**
                     * Crear la componente del panel que será una lista
                     */
                    String[] tareas = app.getUsuario().nomyprioridad().get(k).toArray(new String[0]);
                    JList<String> usuario_tareas = new JList<>(tareas);
                    JScrollPane scrollPane1 = new JScrollPane(usuario_tareas);
                    scrollPane1.setPreferredSize(new Dimension(90,120));

                    /**
                     * Agregar la lista al panel
                     */
                    lista_tareas.add(scrollPane1);

                    /**
                     * Crear un nuevo panel para colocar los botones para agregar tarea e iniciar un nuevo pomodoro
                     */
                    JPanel opciones = new JPanel(new GridBagLayout());

                    /**
                     * Crear las componentes del panel
                     */
                    JButton agregar_tarea = new JButton("Agregar tarea");
                    gbc.gridx = 0;
                    gbc.gridy = 0;
                    agregar_tarea.setPreferredSize(new Dimension(100,25));
                    opciones.add(agregar_tarea, gbc);

                    JButton pomodoro =  new JButton("Pomodoro");
                    gbc.gridx = 0;
                    gbc.gridy = 1;
                    pomodoro.setPreferredSize(new Dimension(100,25));
                    opciones.add(pomodoro, gbc);
                    
                    /**
                     * Crear un boton para salir
                     */
                    JButton salir = new JButton("Salir");
                    gbc.gridx = 0;
                    gbc.gridy = 2;
                    salir.setPreferredSize(new Dimension(100,25));
                    opciones.add(salir, gbc);

                    /**
                     * Agregar los paneles y el boton de salir a la ventana
                     */
                    ventanadia.add(lista_tareas, BorderLayout.CENTER);
                    ventanadia.add(opciones, BorderLayout.EAST);

                    pomodoro.addActionListener(new ActionListener(){
                        public void actionPerformed(ActionEvent e){
                            ventana_pomodoro();
                        }
                    });
                    agregar_tarea.addActionListener(new ActionListener(){
                        public void actionPerformed(ActionEvent e){
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
                            info_tarea.setLayout(new GridBagLayout());
                            GridBagConstraints gbc = new GridBagConstraints();
                            gbc.insets = new Insets(5, 5, 5, 5); // Márgenes entre componentes
                            /**
                             * Crear las componentes del panel (etiquetas y campos de texto)
                             */
                            JLabel nombre = new JLabel("Ingrese el nombre de la tarea");
                            gbc.gridx = 0;
                            gbc.gridy = 0;
                            info_tarea.add(nombre, gbc);
                            JLabel prioridad = new JLabel("Ingrese la prioridad de la tarea (Del 1 al 3 siendo el maximo)");
                            gbc.gridx = 0;
                            gbc.gridy = 1;
                            info_tarea.add(prioridad, gbc);
                            JLabel duracion = new JLabel("Ingrese la duracion de la tarea");
                            gbc.gridx = 0;
                            gbc.gridy = 2;
                            info_tarea.add(duracion, gbc);
                            JLabel detalles = new JLabel("Ingrese los detalles de la tarea");
                            gbc.gridx = 0;
                            gbc.gridy = 3;
                            info_tarea.add(detalles, gbc);

                            JTextField ing_nombre = new JTextField(20);
                            gbc.gridx = 1;
                            gbc.gridy = 0;
                            info_tarea.add(ing_nombre, gbc);
                            JTextField ing_prioridad = new JTextField(20);
                            gbc.gridx = 1;
                            gbc.gridy = 1;
                            info_tarea.add(ing_prioridad, gbc);
                            JTextField ing_duracion = new JTextField(20);
                            gbc.gridx = 1;
                            gbc.gridy = 2;
                            info_tarea.add(ing_duracion, gbc);
                            JTextField ing_detalles = new JTextField(20);
                            gbc.gridx = 1;
                            gbc.gridy = 3;
                            info_tarea.add(ing_detalles, gbc);


                            /**
                             * Crear un boton para salir
                             */
                            JButton salir = new JButton("Agregar");
                            gbc.gridx = 0;
                            gbc.gridy=4;
                            gbc.gridwidth = 2;
                            info_tarea.add(salir, gbc);
                            /**
                             * Crear un evento para poder guardar la informacion de las tareas al salir de la ventana 
                             */
                            salir.addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent e) {
                                    /**
                                     * Usar la informacion para poder pasarla a String y que el programa lo entienda
                                     */
                                    String Tarea = ing_nombre.getText();//Transformar la informacion par poder utilizarla (Nombre de la tarea )
                                    int prioridad = Integer.parseInt(ing_prioridad.getText());//Transformar la informacion par poder utilizarla (Prioridad de la tarea en numeros enteros  )
                                    double  tiempo = Double.parseDouble(ing_duracion.getText());//Transformar la informacion par poder utilizarla (Tiempo estimado de la tarea en double )
                                    String detalle = ing_detalles.getText();//Transformar la informacion par poder utilizarla (Detalles de la tarea )
                                    /**
                                     * Guardar los componentes del usuario 
                                     */
                                    Tarea nuevoTarea = new Tarea();
                                    nuevoTarea.setNombreTarea(Tarea);// Guardar la informacion para poder usarlo en el codigo (Nombre de la tarea )
                                    nuevoTarea.setPrioridad(prioridad);// Guardar la informacion para poder usarlo en el codigo(Prioridad de la tarea en numeros enteros  )
                                    nuevoTarea.setDuracion(tiempo);// Guardar la informacion para poder usarlo en el codigo (Tiempo estimado de la tarea en double )
                                    nuevoTarea.setDetalles(detalle);// Guardar la informacion para poder usarlo en el codigo(Detalles de la tarea )
                                    app.AddTarea(Tarea, prioridad, tiempo, detalle, k);

                                    if(!Tarea.isEmpty() && prioridad == 3){
                                        modelolista.addElement(Tarea);
                                    }

                                    anadir_tarea.dispose();
                                }
                            });

                            /**
                             * Añadir el panel y el boton a la ventana
                             */
                            anadir_tarea.add(info_tarea, BorderLayout.CENTER);
                            //
                        }
                    });

                    salir.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e){
                            ventanadia.dispose();
                        }
                    });
                    ///////
                }
            });
            dias.add(botondia);
        }

        /**
         * Crear otro panel para poder tener la lista de tareas proximas, medallas y el boton de medallas
         */
        JPanel listas = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Márgenes entre componentes
        
        JList<String> lista_tareas2 = new JList<>(modelolista);
        JScrollPane scrollPane2 = new JScrollPane(lista_tareas2);
        gbc.gridx = 0;
        gbc.gridy = 0;
        scrollPane2.setPreferredSize(new Dimension(250, 150));
        listas.add(scrollPane2, gbc);

        JList<String> lista_medallas = new JList<>(modelolista2);
        JScrollPane scrollPane3 = new JScrollPane(lista_medallas);
        gbc.gridx = 0;
        gbc.gridy = 1;
        scrollPane3.setPreferredSize(new Dimension(250, 150));
        listas.add(scrollPane3, gbc);

        JButton bmedallas = new JButton("Medallas");
        gbc.gridx = 0;
        gbc.gridy = 2;
        bmedallas.setPreferredSize(new Dimension(100, 25));
        listas.add(bmedallas, gbc);

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

        bmedallas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                ventana_medallas();
            }
        });

        salir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                principal.dispose();
            }
        });
        
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
        DefaultListModel<String> tareas = new DefaultListModel<>();
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
                JLabel prioridad = new JLabel("Ingrese la prioridad de la tarea (Del 1 al 3 siendo el maximo)");
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
                JButton salir = new JButton("Agregar");
                /**
                 * Crear un evento para poder guardar la informacion de las tareas al salir de la ventana 
                 */
                salir.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        /**
                         * Usar la informacion para poder pasarla a String y que el programa lo entienda
                         */
                        String Tarea = ing_nombre.getText();//Transformar la informacion par poder utilizarla (Nombre de la tarea )
                        int prioridad = Integer.parseInt(ing_prioridad.getText());//Transformar la informacion par poder utilizarla (Prioridad de la tarea en numeros enteros  )
                        double  tiempo = Double.parseDouble(ing_duracion.getText());//Transformar la informacion par poder utilizarla (Tiempo estimado de la tarea en double )
                        String detalle = ing_detalles.getText();//Transformar la informacion par poder utilizarla (Detalles de la tarea )
                        /**
                         * Guardar los componentes del usuario 
                         */
                        Tarea nuevoTarea = new Tarea();
                        nuevoTarea.setNombreTarea(Tarea);// Guardar la informacion para poder usarlo en el codigo (Nombre de la tarea )
                        nuevoTarea.setPrioridad(prioridad);// Guardar la informacion para poder usarlo en el codigo(Prioridad de la tarea en numeros enteros  )
                        nuevoTarea.setDuracion(tiempo);// Guardar la informacion para poder usarlo en el codigo (Tiempo estimado de la tarea en double )
                        nuevoTarea.setDetalles(detalle);// Guardar la informacion para poder usarlo en el codigo(Detalles de la tarea )

                        anadir_tarea.dispose();
                    }
                });

                /**
                 * Añadir el panel y el boton a la ventana
                 */
                anadir_tarea.add(info_tarea, BorderLayout.CENTER);
                anadir_tarea.add(salir, BorderLayout.SOUTH);
                //
            }
        });

        salir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                ventanadia.dispose();
            }
        });

        
    }

    public void ventana_pomodoro(){
        /** 
         * Crear una nueva ventana 
         */
        JFrame ventanapomodoro = new JFrame();
        ventanapomodoro.setTitle("Pomodoro");
        ventanapomodoro.setSize(350, 200);
        ventanapomodoro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventanapomodoro.setVisible(true);
    
        /** 
         * Crear un nuevo panel para colocar la información sobre el pomodoro 
         */
        JPanel mostrar = new JPanel();
        mostrar.setLayout(new GridLayout(4, 1)); // Cambiar a 4 filas
    
        /** 
         * Crear un campo de texto para que el usuario ingrese el tiempo 
         */
        JLabel tiempoLabel = new JLabel("Ingrese el tiempo en minutos:");
        JTextField tiempoField = new JTextField("25"); // Valor por defecto de 25 minutos
    
        /** 
         * Agregar el texto y el campo de entrada al panel 
         */
        mostrar.add(tiempoLabel);
        mostrar.add(tiempoField);
          /** 
         * Agregar los ajustes de la barra de progreso 
         */
        JProgressBar barraProgreso = new JProgressBar(0, 100);
        barraProgreso.setValue(0);
        barraProgreso.setStringPainted(true);
        mostrar.add(barraProgreso);
    
        JButton iniciarButton = new JButton("Iniciar Pomodoro");
        mostrar.add(iniciarButton);
    
        iniciarButton.addActionListener(new ActionListener() {
             // lógica  implementada en la barra de progreso 
            @Override
            public void actionPerformed(ActionEvent e) {
                int tiempo = Integer.parseInt(tiempoField.getText()); // Obtener el tiempo ingresado
                int duracionPomodoro = tiempo * 60;// Convertir minutos a segundos

                Timer timer = new Timer(1000, new ActionListener() {
                    int tiempoTranscurrido = 0;

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        tiempoTranscurrido++;
                        int progreso = (int) (((double) tiempoTranscurrido / duracionPomodoro) * 100);
                        barraProgreso.setValue(progreso);

                        if (progreso >= 100) {
                            ((Timer) e.getSource()).stop();
                            JOptionPane.showMessageDialog(ventanapomodoro, "¡Pomodoro completado!");
                    
                        }
                    }
                });
                timer.start();
            }
        });
    
        /** 
         * Agregar el panel a la ventana 
         */
        ventanapomodoro.add(mostrar);
        
    }

    public void ventana_medallas() {
        // Crear la ventana
        JFrame ventanaMedallas = new JFrame("Medallas de Racha");
        ventanaMedallas.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventanaMedallas.setSize(400, 300);
        ventanaMedallas.setLayout(new BorderLayout());

        // Crear un panel para la lista de medallas
        JPanel panelMedallas = new JPanel();
        panelMedallas.setLayout(new BoxLayout(panelMedallas, BoxLayout.Y_AXIS));

        // Crear etiquetas con nombres creativos de medallas y añadirlas al panel
        JLabel medalla1 = new JLabel("🥉 Novato Consistente - 3 días de racha");
        JLabel medalla2 = new JLabel("🥈 Guerrero de la Constancia - 7 días de racha");
        JLabel medalla3 = new JLabel("🏅 Maestro de la Rutina - 14 días de racha");
        JLabel medalla4 = new JLabel("🥇 Leyenda de la Productividad - 30 días de racha");
        JLabel medalla5 = new JLabel("🌟 Héroe Imparable - 60 días de racha");
        JLabel medalla6 = new JLabel("🔥 Titán del Tiempo - 100 días de racha");

        // Añadir las etiquetas al panel
        panelMedallas.add(medalla1);
        panelMedallas.add(medalla2);
        panelMedallas.add(medalla3);
        panelMedallas.add(medalla4);
        panelMedallas.add(medalla5);
        panelMedallas.add(medalla6);

        // Añadir el panel a la ventana
        ventanaMedallas.add(new JScrollPane(panelMedallas), BorderLayout.CENTER);

        JButton botonSalir = new JButton("Salir");
        botonSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ventanaMedallas.dispose(); 
            }
        });

        // Añadir el botón "Salir" a la parte inferior de la ventana
        ventanaMedallas.add(botonSalir, BorderLayout.SOUTH);

        // Mostrar la ventana
        ventanaMedallas.setVisible(true);
    }



    public static void main(String[] args) {
        Vista prueba = new Vista();
    }
}
