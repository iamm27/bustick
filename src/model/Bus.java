/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.sql.ResultSet;

/**
 *
 * @author Iamm
 */
public class Bus{
    private String platNo;
    private String merk;
    private String kelas;
    private Sopir sopir;
    private model.Database db;
    
    public Bus(){
        db=new model.Database();
    }
    
    public ResultSet getData(String q){
        db.connect();
        ResultSet temp=db.readQuery(q);
        return temp;
    }

    public String getPlatNo() {
        return platNo;
    }

    public void setPlatNo(String platNo) {
        this.platNo = platNo;
    }

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public Sopir getSopir() {
        return sopir;
    }

    public void setSopir(Sopir sopir) {
        this.sopir = sopir;
    }
}
