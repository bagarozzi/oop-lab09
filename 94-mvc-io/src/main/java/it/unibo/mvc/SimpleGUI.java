package it.unibo.mvc;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private final JFrame frame = new JFrame();
    private final SimpleController controller;
    private final int PROPORTION = 5;

    public SimpleGUI(final SimpleController c){
        controller = c;

        JPanel canvas = new JPanel();
        JPanel lowerButtons = new JPanel();
        JTextField jtf = new JTextField();
        JTextArea textArea = new JTextArea();
        JButton print = new JButton("Print");
        JButton showHistory = new JButton("Show history");

        canvas.setLayout(new BorderLayout());
        canvas.add(jtf, BorderLayout.NORTH);
        canvas.add(textArea, BorderLayout.CENTER);
        canvas.add(lowerButtons, BorderLayout.SOUTH);
        lowerButtons.setLayout(new BorderLayout());
        lowerButtons.add(print, BorderLayout.LINE_END);
        lowerButtons.add(showHistory, BorderLayout.LINE_START);

        frame.setContentPane(canvas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        print.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{
                    controller.setNextString(textArea.getText());
                } catch(Exception e1){
                    System.out.println("A null string has been passed");
                }
                controller.print();
            }
        });
    }

    public void display(){
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);

        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args){
        SimpleGUI sg = new SimpleGUI(new SimpleController());
        sg.display();
    }
}
