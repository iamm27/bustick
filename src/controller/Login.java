/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author Iamm
 */
public class Login implements ActionListener{
    private model.Login model;
    private view.FrmLogin view;
    
    public Login(model.Login model, view.FrmLogin view){
        this.model=model;
        this.view=view;
        
        view.addListener((ActionListener)this);
        view.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            JButton s=(JButton)e.getSource();
            
            if(s.getName().equals("btLogin")){
                model.Main mMain=new model.Main();
                view.FrmMain vMain=new view.FrmMain();
                controller.Main cMain=new controller.Main(mMain, vMain);
                
                getView().dispose();
            }
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public model.Login getModel() {
        return model;
    }

    public void setModel(model.Login model) {
        this.model = model;
    }

    public view.FrmLogin getView() {
        return view;
    }

    public void setView(view.FrmLogin view) {
        this.view = view;
    }
}
