import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Vista  extends JFrame{
    Usuario nuevoUsuario = new Usuario();
    ArrayList<String> proxtar = new ArrayList<>();
    Aplicacion app = new Aplicacion();
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
        JFrame inicio_sesion = new JFrame();
        inicio_sesion.setTitle("App manejo del tiempo - Inicio sesión");
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
        JPasswordField ing_contrasena = new JPasswordField(20);

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
                nuevoUsuario = app.buscarUsuario(Nombre);
            }
        });

        /**
         * Agregar el panel y boton de confirmacion a la ventana
         */
        inicio_sesion.add(interaccion_inicio_sesion, BorderLayout.CENTER);
        inicio_sesion.add(confirmacion, BorderLayout.SOUTH);

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
        JPasswordField ing_contrasena = new JPasswordField(20);
        JPasswordField ing_confirm_contrasena = new JPasswordField(20);
        

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
         * Crear una accion para que la informacion se guarde luego de precionar el boton 
         */
        /**
         * Agregar el panel y el boton de confirmacion a la ventana
         */
        registro.add(interaccion_registro, BorderLayout.CENTER);
        registro.add(confirmacion, BorderLayout.SOUTH);

        confirmacion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                
                ventana_principal();
                registro.dispose();
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
                    JPanel lista_tareas = new JPanel();

                    /**
                     * Crear la componente del panel que será una lista
                     */
                    String[] tareas = nuevoUsuario.nomyprioridad().get(k).toArray(new String[0]);
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
                                    nuevoUsuario.agregartarea(k, nuevoTarea);

                                    proxtar = nuevoUsuario.tareasprox();
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
                    ///////
                }
            });
            dias.add(botondia);
        }

        /**
         * Crear otro panel para poder tener la lista de tareas proximas, medallas y el boton de medallas
         */
        JPanel listas = new JPanel();
        listas.setLayout(new GridLayout(3,1));

        String[] tareas2 = nuevoUsuario.tareasprox().toArray(new String[0]);
        JList<String> lista_tareas2 = new JList<>(tareas2);
        JScrollPane scrollPane2 = new JScrollPane(lista_tareas2);

        String[] medallas = nuevoUsuario.getBadges().toArray(new String[0]);
        JList<String> lista_medallas = new JList<>(medallas);
        JScrollPane scrollPane3 = new JScrollPane(lista_medallas);

        JButton bmedallas = new JButton("Medallas");

        /**
         * Agregar las componentes al panel
         */
        listas.add(scrollPane2);
        listas.add(scrollPane3);
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
