/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.view;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author work
 */
public class GuiView {
        
    private JFrame frame;
    private JLabel label;
    private JButton button;

    
    public GuiView(String text){
        frame = new JFrame("View");                                    
        frame.getContentPane().setLayout(new BorderLayout());                                          
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);           
        frame.setSize(200,200);        
        frame.setVisible(true);
        
        label = new JLabel(text);
        frame.getContentPane().add(label, BorderLayout.CENTER);
        
        button = new JButton("Button");        
        frame.getContentPane().add(button, BorderLayout.SOUTH);        
    }
        
    public JButton getButton(){
        return button;
    }
    
    public void setText(String text){
        label.setText(text);
    }
}
