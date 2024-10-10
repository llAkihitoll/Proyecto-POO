import javax.swing.*;
public class Vista {
    private JButton boton;
    //ejemplo basico de un gui utilizando swing
    //probando con herencia, habría que poner public class Vista extends JFrame

    //public Vista(){
    //    super("Ejemplo 1");
        //titulo con el que aparecerá la ventana

    //    setVisible(true);
    //    setDefaultCloseOperation(EXIT_ON_CLOSE);
        //se establece que se vea la ventana y que cuando esta se cierre se terminé el programa

    //}


    //forma 2 de realizar la ventana, esta vez sin herencia
    public Vista(){
        JFrame frame = new JFrame("Ejemplo 2");
        
        //en este caso hay que referirse al objeto para extablecer los componentes
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //se crea un nuevo boton, este dirá hola y por el momento no hará nada
        boton = new JButton("hola");
        //se agregá el botón a la ventana
        frame.add(boton);
        //se establece el tamaño de la ventana
        frame.setSize(200, 200);
    }

    public static void main(String[] args) {
        Vista prueba = new Vista();
    }
}
