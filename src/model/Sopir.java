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
public class Sopir {
    private String nama;
    private String tglLahir;
    private String alamat;
    private String kontak;
    private model.Database db;
    
    public Sopir(String nama,String tglLahir, String alamat, String kontak){
        this.nama=nama;
        this.tglLahir=tglLahir;
        this.alamat=alamat;
        this.kontak=kontak;
        db=new model.Database();
    }
    
    public Sopir(){
        db=new model.Database();
    }
    
    public ResultSet getData(String q){
        db.connect();
        return db.readQuery(q);
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTglLahir() {
        return tglLahir;
    }

    public void setTglLahir(String tglLahir) {
        this.tglLahir = tglLahir;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getKontak() {
        return kontak;
    }

    public void setKontak(String kontak) {
        this.kontak = kontak;
    }
}
