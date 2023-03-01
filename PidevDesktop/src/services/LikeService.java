/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import entities.Like;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.MyDB;

/**
 *
 * @author Mohamed
 */
public class LikeService {
    
    Connection cnx;
    
public LikeService() {
        cnx = MyDB.getInstance().getCnx();
    }    
    
    
    public void ajouter (Like l) throws SQLException{
    
    String req="insert into like_comment(id_user,id_com,etat) values (?,?,?)";
    PreparedStatement stmt = cnx.prepareStatement(req);
    stmt.setInt(1, l.getId_user());
    stmt.setInt(2, l.getId_com());
    stmt.setBoolean(3, l.getEtat());
      stmt.executeUpdate();
    
    }
    
    
    
    public Boolean verif_like(int idu,int idc) throws SQLException{
        Boolean i = false;
     List<Like> likes = new ArrayList<>();
     String req = "select etat from like_comment where id_com=? and id_user=?"; 
      PreparedStatement ps = cnx.prepareStatement(req);
    ps.setInt(1, idc);
    ps.setInt(2, idu);
    
    ResultSet rs = ps.executeQuery();
    
    
       while(rs.next()) {
       
       i=rs.getBoolean("etat");
       
       }
    
    return i;
    
    
    }
    
    
    
    
}
