/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;

/**
 *
 * @author Iamm
 */
public class Main implements MouseListener, Interface{
    public view.FrmDashboard view;
    public model.Main model;
    
    public Main(model.Main model, view.FrmDashboard view){
        this.model=model;
        this.view=view;
        this.view.addListener(this);
        this.view.setSize(new Dimension(1024, 576));
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.view.setLocation(dim.width/2-this.view.getSize().width/2, dim.height/2-this.view.getSize().height/2);
    }
    

    public view.FrmDashboard getView() {
        return view;
    }

    public void setView(view.FrmDashboard view) {
        this.view = view;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        try{
            if(e.getSource().equals(getView().btBus)){
                model.Bus mBus=new model.Bus();
                view.FrmBus vBus=new view.FrmBus();
                controller.Bus cBus=new controller.Bus(mBus, vBus);
                cBus.getView().setVisible(true);
                this.getView().dispose();
            }
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void main(String[] args) {
        model.Main mMain=new model.Main();
        view.FrmDashboard vMain=new view.FrmDashboard();
        controller.Main cMain=new controller.Main(mMain, vMain);
        cMain.getView().setVisible(true);
    }

    public model.Main getModel() {
        return model;
    }

    public void setModel(model.Main model) {
        this.model = model;
    }
}
