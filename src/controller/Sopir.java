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
public class Sopir {
    private model.Sopir model;
    private view.FrmSopir view;
    
    public Sopir(model.Sopir model, view.FrmSopir view){
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

    public model.Sopir getModel() {
        return model;
    }

    public void setModel(model.Sopir model) {
        this.model = model;
    }

    public view.FrmSopir getView() {
        return view;
    }

    public void setView(view.FrmSopir view) {
        this.view = view;
    }
}
