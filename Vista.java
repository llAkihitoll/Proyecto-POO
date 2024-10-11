import java.awt.*;
import javax.swing.*;
public class Vista  extends JFrame{
    public Vista(){
        setTitle("App manejo del tiempo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setVisible(true);
        //setSize(500, 200);

        JPanel dias = new JPanel();
        dias.setLayout(new GridLayout(4, 7));
        for(int i = 0; i<28; i++){
            JButton botondia = new JButton("Día " + (i+1));
            dias.add(botondia);
        }

        //dias.setSize(250, 230);
        add(dias,BorderLayout.WEST);

        JPanel lista = new JPanel();
        JList<Tarea> tareas = new JList<>();
        lista.add(tareas);

        add(lista, BorderLayout.EAST);

        JPanel medallas = new JPanel();
        medallas.add(new JButton("Ver medallas"));
        add(medallas, BorderLayout.EAST);
        medallas.setSize(200, 200);

    }

    public static void main(String[] args) {
        Vista prueba = new Vista();
    }
}