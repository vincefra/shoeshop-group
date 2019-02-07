/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.model;

/**
 *
 * @author work
 */
public class GuiModel 
{
    private int x;
    
    public GuiModel(){
        x = 0;
    }
    
    public GuiModel(int x){
        this.x = x;
    }
    
    public void incX(){
        x++;
    }
    
    public int getX(){
        return x;
    }
}
