/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.controller;

import gui.model.GuiModel;
import gui.view.GuiView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.text.View;

/**
 *
 * @author work
 */
public class GuiController {
        
    private GuiModel model;
    private GuiView view;
    private ActionListener actionListener;
    
    public GuiController(GuiModel model, GuiView view){
        this.model = model;
        this.view = view;
                          
    }
    
    public void contol(){        
        actionListener = (ActionEvent actionEvent) -> {
            linkBtnAndLabel();
        };                
        view.getButton().addActionListener(actionListener);   
    }
    
    private void linkBtnAndLabel(){
        model.incX();                
        view.setText(Integer.toString(model.getX()));
    }  
}
