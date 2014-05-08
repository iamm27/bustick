/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.awt.Dialog;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import view.BusModalTambah;

/**
 *
 * @author Iamm
 */
public class Bus implements J_Controller, MouseListener{
    private view.FrmBus view;
    private model.Bus model;

    public Bus(model.Bus model, view.FrmBus view){
        this.model=model;
        this.view=view;
        view.setMaximizable(true);
        view.setClosable(true);
        view.addListener((MouseListener)this);
        this.refreshTable();
    }
    
    public void refreshTable(){
        String q="SELECT platNo AS 'No. Plat',merk AS 'Merk',kelas AS 'Kelas'  FROM tbbus";
        this.view.setGridDataModel(model.getData(q));
    }
    
    public void getSopirKondektur(ResultSet rs){
        String namaSopir="";
        String namaKondektur="";
        String idSopir=null;
        String idKondek=null;
                
        try {
            rs.first();
            idSopir=rs.getString(4);
            idKondek=rs.getString(5);
            
            if(idSopir != null){
                ResultSet rsSopir=model.getData("SELECT namaSopir FROM tbSopir WHERE idSopir='"+idSopir+"'");
                rsSopir.first();
            
                namaSopir=rsSopir.getString(1);
            }
            else{
                namaSopir="";
            }
            
            if(idKondek!=null){
                ResultSet rsKondek=model.getData("SELECT namaKondektur FROM tbKondektur WHERE idKondektur='"+idKondek+"'");
                rsKondek.first();
                namaKondektur=rsKondek.getString(1);
            }
            else{
                namaKondektur="";
            }
            
            this.view.setTxtSopir(namaSopir);
            this.view.setTxtKondektur(namaKondektur);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public view.FrmBus getView() {
        return view;
    }

    public void setView(view.FrmBus view) {
        this.view = view;
    }

    public model.Bus getModel() {
        return model;
    }

    public void setModel(model.Bus model) {
        this.model = model;
    }
    
    @Override
    public void mouseClicked(MouseEvent e){
        try{
            if(e.getSource().equals(view.gridData)){
                String idBus=view.gridData.getValueAt(view.gridData.getSelectedRow(), 0).toString();
                this.getSopirKondektur(this.getDataByID(idBus));
            }
            else if(e.getSource().equals(view.btTambah)){
                
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

    @Override
    public ResultSet getDataByID(String id) {
        ResultSet temp=null;
        String q="SELECT * FROM tbBus WHERE platNo='"+id+"'";
        temp=this.model.getData(q);
        return temp;
        
    }
}
