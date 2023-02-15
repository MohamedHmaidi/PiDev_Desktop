/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import entities.Commentaire;
import entities.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utils.MyDB;

/**
 *
 * @author Mohamed
 */
public class CommentaireService implements IService<Commentaire>{
Connection cnx;
    
public CommentaireService() {
        cnx = MyDB.getInstance().getCnx();
    }    

@Override
    public void ajouter(Commentaire t) throws SQLException {
        
        String req="insert into commentaire(id_user,id_event,commentaire) values (?,?,?)";
        PreparedStatement stmt = cnx.prepareStatement(req);
        stmt.setInt(1, t.getId_user());
        stmt.setInt(2, t.getId_event());
        stmt.setString(3, t.getCommentaire());
        stmt.executeUpdate();
        
        
    }

    @Override
    public void modifier(Commentaire t) throws SQLException {
    String req="update Commentaire set commentaire =?";
    PreparedStatement stmt = cnx.prepareStatement(req);
     stmt.setString(1, t.getCommentaire());
      stmt.executeUpdate();
    }

    @Override
    public void supprimer(Commentaire t) throws SQLException {
         String req="Delete from commentaire where id_com=?";
        PreparedStatement stmt = cnx.prepareStatement(req);
        stmt.setInt(1, t.getId_com());
        stmt.executeUpdate();
        
        
    }

    @Override
    public List<Commentaire> recuperer(Commentaire t) throws SQLException {
        List<Commentaire> commentaires = new ArrayList<>(); 
        String req="select * from Commentaire";
   Statement st = cnx.createStatement();
   ResultSet rs =  st.executeQuery(req);
      while(rs.next()){
   Commentaire c= new Commentaire();
   c.setId_com(rs.getInt("id_com"));
   c.setId_event(rs.getInt("id_event"));
   c.setId_user(rs.getInt("id_user"));
   c.setCommentaire(rs.getString("commentaire"));
       commentaires.add(c);
      }
 
   return commentaires;
    }
    
}
