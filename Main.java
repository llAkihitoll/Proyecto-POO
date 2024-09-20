import java.util.Scanner;

public class Main { 
// creacion de la clase principal en la que se usara 

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.println("Bienvenido a la aplicación de gestión de tareas."); 
// dar la bienvenida al programa 

        System.out.print("Ingrese su nombre de usuario: ");
// falta confirmacion de informacion 

        String nombreUsuario = scanner.nextLine();

        Aplicacion app = new Aplicacion(nombreUsuario);
// Creación de la aplicación con el nombre de usuario


        while (true){
//Cracion del menu con las opciones disponibles 

            System.out.println("\Menu Principal:");
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
                 app.AddTarea();
                case "2":
                  app.MarcarCompletado();
                case "3":
                   app.MostrarHorario();
                case "4":
                   app.IniciarPomodoro();
                case "5":
                   app.VerificarRecompensa();
                case "6":
                   app.MostrarRecompensa();
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