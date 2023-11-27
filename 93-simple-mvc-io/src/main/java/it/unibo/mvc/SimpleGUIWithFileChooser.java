package it.unibo.mvc;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {

    private final JFrame frame = new JFrame();
    private Controller controller;

    public SimpleGUIWithFileChooser(Controller c){
        controller = c;
        JPanel canvas = new JPanel();
        JPanel subcanvas = new JPanel();
        JTextField tf = new JTextField("Browse");
        JButton browse = new JButton();

        canvas.setLayout(new BorderLayout());
        subcanvas.setLayout(new BorderLayout());
        subcanvas.add(tf, BorderLayout.CENTER);
        subcanvas.add(browse, BorderLayout.LINE_END);
        canvas.add(subcanvas, BorderLayout.NORTH);

        tf.setEditable(false);
        tf.setText("The current file is: " + controller.getCurrentFile());

        browse.addActionListener(new ActionListener(){
            public void actionPerformed(final ActionEvent e){
                JFileChooser jfc = new JFileChooser();
        });
    }
}
