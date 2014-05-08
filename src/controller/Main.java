/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import javax.swing.JButton;

/**
 *
 * @author Iamm
 */
public class Main implements ActionListener, Interface{
    private view.FrmMain view;
    private model.Main model;
    
    public Main(model.Main model, view.FrmMain view){
        this.model=model;
        this.view=view;
        //view.addListener((ActionListener) this);
        view.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e) {
        try{            
            JButton s=(JButton)e.getSource();
            
            if(s.getName().equals("btBus")){
                
                
            }
        }
        catch(Exception ex){
            
        }
    }

    public view.FrmMain getView() {
        return view;
    }

    public void setView(view.FrmMain view) {
        this.view = view;
    }
    
}
