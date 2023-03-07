/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import Entities.User;
import java.io.ByteArrayInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utils.Mybd;

/**
 *
 * @author Administrateur
 */
public class UserService {
    
    
     
    Connection cnx;
public UserService() {
        cnx = Mybd.getInstance().getcnx();
    }    

  
    public void ajouter(User t) throws SQLException {
        
            String req = "INSERT INTO user (nom,prenom,email,mdp,tel,image,role) VALUES(?,?,?,?,?,?,?)" ;
         PreparedStatement stmt = cnx.prepareStatement(req);
         stmt.setString(1, t.getNom());
            stmt.setString(2, t.getPrenom());
             stmt.setString(3, t.getEmail());
            stmt.setString(4, t.getMdp());
             stmt.setInt(5, t.getTel());
              stmt.setBinaryStream(6, new ByteArrayInputStream(t.getImage()), t.getImage().length);

               stmt.setString(7, t.getRole());
            int result=stmt.executeUpdate();
        
        
        System.out.println(result + " enregistrement ajouté.");
        
    }
    
    
   public boolean existemail(String email) throws SQLException {
    boolean exist = false;
    String query = "SELECT * FROM user WHERE email = ?";
    PreparedStatement ps = cnx.prepareStatement(query);
    ps.setString(1, email);
    ResultSet rs = ps.executeQuery();
    if (rs.next()) {
        exist = true;
        
    }
    return exist;
}
    

   
    public void modifier(User t) throws SQLException {
      String req="Update user set nom=?, prenom=?, email=?, mdp=?, tel=?, image=?, role=? where id_user=?";
        PreparedStatement stmt = cnx.prepareStatement(req);
         stmt.setString(1, t.getNom());
            stmt.setString(2, t.getPrenom());
             stmt.setString(3, t.getEmail());
            stmt.setString(4, t.getMdp());
             stmt.setInt(5, t.getTel());
              stmt.setBinaryStream(6, new ByteArrayInputStream(t.getImage()), t.getImage().length);
               stmt.setString(7, t.getRole());
         stmt.setInt(8, t.getId());
         
         stmt.executeUpdate();
    }

    
    
    
    
    
    
    
   
    public void supprimer(User t) throws SQLException {
        String req="Delete from user where id_user=?";
        PreparedStatement stmt = cnx.prepareStatement(req);
        stmt.setInt(1, t.getId());
        stmt.executeUpdate();
    }


    
    public List<User> rechercherParNom(String nom) throws SQLException {
     List<User> users = new ArrayList<>();
      String req = "SELECT * FROM user WHERE (role='Artiste' OR role='simple utilisateur') AND nom LIKE '%" + nom + "%'";
     Statement stm = cnx.createStatement();
    ResultSet rs = stm.executeQuery(req);
    
    while(rs.next()){
   User p = new User();
   p.setId(rs.getInt("id_user"));
   p.setTel(rs.getInt("tel"));
   p.setEmail(rs.getString("email"));
   p.setNom(rs.getString("nom"));
   p.setPrenom(rs.getString("prenom"));
   p.setRole(rs.getString("role"));
  // p.setImage(rs.getString("image"));
  
   byte[] ImageBytes = rs.getBlob("image").getBytes(1l, (int)rs.getBlob("image").length());
            p.setImage(ImageBytes);
  
  
   p.setMdp(rs.getString("mdp"));
   
   users.add(p);
   
   
   }
   
   
        
        
        return users;
    }
    
    
    public void ModifMDP(String email, String mdp) throws SQLException{
    
    String req="Update user set mdp=? where email=?";
    PreparedStatement stmt = cnx.prepareStatement(req);
    stmt.setString(1, mdp);
    stmt.setString(2, email);
    stmt.executeUpdate();
    }

   
    public List<User> recuperer() throws SQLException  {
    List<User> users = new ArrayList<>();      
   String req="select * from user";
   Statement st = cnx.createStatement();
   ResultSet rs =  st.executeQuery(req);
   while(rs.next()){
   User p = new User();
   p.setId(rs.getInt("id_user"));
   p.setTel(rs.getInt("tel"));
   p.setEmail(rs.getString("email"));
   p.setNom(rs.getString("nom"));
   p.setPrenom(rs.getString("prenom"));
   p.setRole(rs.getString("role"));
  // p.setImage(rs.getString("image"));
  
   byte[] ImageBytes = rs.getBlob("image").getBytes(1l, (int)rs.getBlob("image").length());
            p.setImage(ImageBytes);
  
  
   p.setMdp(rs.getString("mdp"));
   
   users.add(p);
   
   
   }
   
   
        
        
        return users;
    }  
    
    
    
    
    
    
    public List<User> recupererAdmin() throws SQLException  {
    
     List<User> personnes = new ArrayList<>();
        String req = "select * from user where user=admin";
        Statement cs = cnx.createStatement();  
        ResultSet rs =  cs.executeQuery(req); 
        while(rs.next()){
            User p = new User();
           
            p.setId(rs.getInt("id_user"));
          
            personnes.add(p);
                  


        }
        return personnes;
    }
    
    
    
    
}   

