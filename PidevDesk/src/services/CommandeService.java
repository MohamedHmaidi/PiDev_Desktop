/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import entities.Commande;
import java.security.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import utils.MyDB;

/**
 *
 * @author ashre
 */
public class CommandeService implements IService<Commande>  {
    Connection cnx ; 
    
    public CommandeService() { 
       cnx = MyDB.getInstance().getCnx(); 
    }
    
    
    
    public void ajouterCommande(Commande c , int id_user) throws SQLException {
        
       
    String req = "INSERT INTO commande (id_user, date_commande, rue, ville, code_postal, tel, nom, prenom) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = cnx.prepareStatement(req)) {
            ps.setInt(1, id_user);
            
            // Obtenir le timestamp actuel
        long timestamp = new Date().getTime();
        
        // Convertir le timestamp en une chaîne de caractères dans le format souhaité
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateCommande = dateFormat.format(new Date(timestamp));
            
            ps.setString(2, dateCommande);
            ps.setString(3, c.getRue());
            ps.setString(4, c.getVille());
            ps.setString(5, c.getCode_postal());
            ps.setString(6, c.getTel());
            ps.setString(7, c.getNom());
            ps.setString(8, c.getPrenom());
            
            ps.executeUpdate();
        }
}
    
   public List<Commande> recupererCommande() throws SQLException {
    List<Commande> CM = new ArrayList<>();
    String query = "SELECT * FROM commande";
    PreparedStatement pst = cnx.prepareStatement(query);
    ResultSet rs = pst.executeQuery();
    while (rs.next()) {
        int commande_id = rs.getInt(1); // 1 represents the first column
        int id_user = rs.getInt("id_user");
        String date_commande = rs.getString("date_commande");
        String rue = rs.getString("rue");
        String ville = rs.getString("ville");
        String code_postal = rs.getString("code_postal");
        String tel = rs.getString("tel");
        String nom = rs.getString("nom");
        String prenom = rs.getString("prenom");
        Commande c = new Commande(commande_id,id_user, date_commande, rue,ville,code_postal, tel, nom,prenom);
        CM.add(c);
    }
    return CM;
}
   
   
   
   
   public List<Commande> recupererCommandeOrderByDate() throws SQLException {
List<Commande> CM = new ArrayList<>();
String query = "SELECT * FROM commande ORDER BY date_commande";
PreparedStatement pst = cnx.prepareStatement(query);
ResultSet rs = pst.executeQuery();
while (rs.next()) {
int commande_id = rs.getInt(1); // 1 represents the first column
int id_user = rs.getInt("id_user");
String date_commande = rs.getString("date_commande");
String rue = rs.getString("rue");
String ville = rs.getString("ville");
String code_postal = rs.getString("code_postal");
String tel = rs.getString("tel");
String nom = rs.getString("nom");
String prenom = rs.getString("prenom");
Commande c = new Commande(commande_id,id_user, date_commande, rue,ville,code_postal, tel, nom,prenom);
CM.add(c);
}
return CM;
}

    @Override
    public void modifier (Commande c) throws SQLException {
        
    }

    @Override
    public void supprimer(Commande t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Commande> Consulter(Commande t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Commande afficherParId(int panier_id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Commande ajouterProduit(int produit_id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void ajouter(Commande t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
