package it.unibo.mvc;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.Dimension;
import java.awt.Toolkit;


/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {

    private final JFrame frame = new JFrame();
    private final int PROPORTION = 5;
    private Controller controller;

    public SimpleGUIWithFileChooser(Controller c){
        controller = c;
        JPanel canvas = new JPanel();
        JPanel subcanvas = new JPanel();
        JTextField currentFileField = new JTextField();
        JTextArea textArea = new JTextArea();
        JButton browse = new JButton("Browse");
        JButton save = new JButton("Save");

        canvas.setLayout(new BorderLayout());
        subcanvas.setLayout(new BorderLayout());

        subcanvas.add(currentFileField, BorderLayout.CENTER);
        subcanvas.add(browse, BorderLayout.LINE_END);

        canvas.add(textArea, BorderLayout.CENTER);
        canvas.add(subcanvas, BorderLayout.NORTH);
        canvas.add(save, BorderLayout.SOUTH);

        frame.setContentPane(canvas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        currentFileField.setEditable(false);
        currentFileField.setText("The current file is: " + controller.getCurrentFile());

        browse.addActionListener(new ActionListener(){
            public void actionPerformed(final ActionEvent e){
                JFileChooser jfc = new JFileChooser();
                switch (jfc.showSaveDialog(canvas)) {
                    case JFileChooser.APPROVE_OPTION:
                        controller.setCurrentFile(jfc.getSelectedFile());
                        currentFileField.setText("The current file is: " + jfc.getSelectedFile().getAbsolutePath());;
                        break;
                    case JFileChooser.CANCEL_OPTION:
                        break;
                    default:
                        break;
                }
            }
        });
        
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
        SimpleGUIWithFileChooser sg = new SimpleGUIWithFileChooser(new Controller());
        sg.display();
    }
}
