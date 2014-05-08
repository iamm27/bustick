/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/**
 *
 * @author iammaziz
 */
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {
    private Connection conn = null;
    private Statement stat = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    
    public void connect(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            this.conn = DriverManager.getConnection("jdbc:mysql://localhost/dbBus","root","");
            this.stat=this.conn.createStatement();
        }
        catch(ClassNotFoundException | SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    public void disconnect(){
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ResultSet readQuery(String q){
        try{
            rs=stat.executeQuery(q);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return rs;
    }
}
