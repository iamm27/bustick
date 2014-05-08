/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

/**
 *
 * @author Iamm
 */
public class Kondektur {
    private model.Kondektur model;
    private view.FrmKondektur view;
    
    public Kondektur(model.Kondektur model, view.FrmKondektur view){
        this.model=model;
        this.view=view;
        this.view.setClosable(true);
        this.view.setMaximizable(true);
        this.view.setVisible(true);
        this.refreshTable();
    }
    
    public void refreshTable(){
        String q="SELECT * FROM tbsopir";
        this.getView().setGridDataModel(getModel().getData(q));
    }

    public model.Kondektur getModel() {
        return model;
    }

    public void setModel(model.Kondektur model) {
        this.model = model;
    }

    public view.FrmKondektur getView() {
        return view;
    }

    public void setView(view.FrmKondektur view) {
        this.view = view;
    }
}
