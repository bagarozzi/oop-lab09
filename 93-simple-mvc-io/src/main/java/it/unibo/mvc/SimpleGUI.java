package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.Toolkit;


/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private final JFrame frame = new JFrame("Exercise 2");
    private final int PROPORTION = 5;
    private final Controller controller;

    public SimpleGUI(Controller c){
        controller = c;

        JPanel canvas = new JPanel();
        JTextArea textArea = new JTextArea();
        JButton save = new JButton("Save");

        canvas.setLayout(new BorderLayout());
        canvas.add(textArea, BorderLayout.CENTER);
        canvas.add(save, BorderLayout.SOUTH);
        frame.setContentPane(canvas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        save.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{
                    controller.saveContentToFile(textArea.getText());
                } catch(IOException e1){
                    System.out.println("There was a problem saving the content or the content passed is null");
                }
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
        SimpleGUI sg = new SimpleGUI(new Controller());
        sg.display();
    }
}
