/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import entities.Commande;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
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
    
    public void ajouterCommande(Commande c) throws SQLException {
    String req = "INSERT INTO commande (id_user, date_commande, rue, ville, adresse, code_postal, tel, nom, prenom) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = cnx.prepareStatement(req)) {
            ps.setInt(1, c.getCommande_id());
            ps.setInt(2, c.getUser_id());
//            ps.setDate(3, c.getDate_commande());
            ps.setDouble(4, c.getPrix());
            ps.executeUpdate();
        }
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
