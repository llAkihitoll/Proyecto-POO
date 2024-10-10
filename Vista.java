import javax.swing.*;
public class Vista extends JFrame{
    //ejemplo basico de un gui utilizando swing
    //probando con herencia

    public Vista(){
        super("ejemplo");
        //titulo con el que aparecerá la ventana

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //se establece que se vea la ventana y que cuando esta se cierre se terminé el programa

    }

    public static void main(String[] args) {
        Vista prueba = new Vista();
    }
}
