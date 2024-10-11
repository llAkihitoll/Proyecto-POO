import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

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

        dias.setSize(250, 230);
        add(dias,BorderLayout.CENTER);

        JPanel medalla = new JPanel();
        JButton medallas = new JButton("Medallas");
        medallas.addActionListener(new aparecer());
        medalla.add(medallas);

        String[] pruebalista = {"hola", "soy", "rodrigo"} ;
        JPanel lista = new JPanel();
        JList<String> tareas = new JList<>(pruebalista);
        lista.add(tareas, BorderLayout.NORTH);
        lista.add(medallas, BorderLayout.CENTER);
        add(lista, BorderLayout.EAST);
    }

    class aparecer implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            System.out.println("Aquí se desplegarán las medallas con las que cuenta el usario");
            }
    }

    public static void main(String[] args) {
        Vista prueba = new Vista();
    }
}