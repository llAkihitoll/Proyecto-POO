import java.util.Scanner;

public class Main { 
// creacion de la clase principal en la que se usara 

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.println("Bienvenido a la aplicación de gestión de tareas."); 
// dar la bienvenida al programa 



        Aplicacion app = new Aplicacion();
// Creación de la aplicación con el nombre de usuario
        boolean autenticado = false;
        while (!autenticado) {
            System.out.print("Ingrese su nombre de usuario: ");
            String nombreUsuario = scanner.nextLine();
            System.out.print("Ingrese su contrasena: ");
            String contrasena = scanner.nextLine();

            autenticado = app.iniciarSesion(nombreUsuario, contrasena);
            if (!autenticado) {
                System.out.println("Intente nuevamente.");
            }
        }

        while (true){
//Cracion del menu con las opciones disponibles 

            System.out.println("Menu Principal:");
            System.out.println("1. Agregar Nueva tarea");
            System.out.println("2. Marcar tarea como completada");
            System.out.println("3. Mostrar horario");
            System.out.println("4. Metodo Pomodoro");
            System.out.println("5. Verificar recompensas");
            System.out.println("6. Mostrar recompensas");
            System.out.println("7. Salir");

            System.out.print("Seleccione una opción: ");
            String opcion = scanner.nextLine();
            switch (opcion) {
                case "1":
                    // Pedir los datos para la nueva tarea
                    System.out.print("Ingrese el nombre de la tarea: ");
                    String nombreTarea = scanner.nextLine();
                    
                    System.out.print("Ingrese la prioridad de la tarea (1 es prioridad maxima y 3 prioridad minima): ");
                    int prioridad = Integer.parseInt(scanner.nextLine());
                    
                    System.out.print("Ingrese la duración de la tarea (minutos): ");
                    double duracion = Double.parseDouble(scanner.nextLine());
                    
                    System.out.print("Ingrese los detalles de la tarea: ");
                    String detalles = scanner.nextLine();

                    // Llamada al método AddTarea pasando los valores como argumentos
                    app.AddTarea(nombreTarea, prioridad, duracion, detalles);
                    break;
                case "2":
                    // Pedir el nombre de la tarea a marcar como completada
                    System.out.print("Ingrese el nombre de la tarea que desea marcar como completada: ");
                    String nombreTareaCompletada = scanner.nextLine();
                    // Llamar a MarcarCompletado pasando el nombre de la tarea como argumento
                    app.MarcarCompletado(nombreTareaCompletada);
                    System.out.println("Su tarea fue marcada como completada");
                    break;
                case "3":
                    app.MostrarHorario();
                    
                break;
                   
                case "4":
                    // Pedir el tiempo para el Pomodoro (por ejemplo, en minutos)
                    System.out.print("Ingrese la duración del Pomodoro (en minutos): ");
                    int duracionPomodoro = Integer.parseInt(scanner.nextLine());
                    app.IniciarPomodoro(duracionPomodoro);
                break;

                case "5":
                   app.VerificarRecompensa();
               break;

                case "6":
                    System.out.println("No hay recompensas para mostrar por ahora");
                   //app.MostrarRecompensas(); falta completar el metodo
               break;

                case "7":
                    System.out.println("Gracias por usar nuestra aplicacion ");
                    System.out.println("Cerrando el programa ... ¡Hasta luego!");
                    scanner.close();
                    return;
                default:
                    System.out.println("La opcion que usted selecciono no es valida, porfavor intentar de nuevo ");
                    
            }
        }
    }
}
