/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import entities.Panier;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import utils.MyDB;
import java.time.LocalDateTime;
import java.sql.ResultSet;

/**
 *
 * @author ashre
 */
public class PanierService implements IService<Panier> {

    Connection cnx;
    public PanierService() {
        cnx = MyDB.getInstance().getCnx();
    }

    @Override
    public void ajouter(Panier p) throws SQLException {
      
        String req = "INSERT INTO panier (produit_id, quantite, panier_id) VALUES (?, ?, ?, ?)" ; 
       try (PreparedStatement ps = cnx.prepareStatement(req)){
        ps.setInt(1, p.getProduit_id()); // Remplacer produit.getId() par l'identifiant du produit à ajouter au panier
        ps.setInt(2, p.getQuantite()); // La quantité de produits à ajouter
        ps.setString(3, LocalDateTime.now().toString()); // La date actuelle
        ps.setInt(4, p.getPanier_id());
        ps.executeUpdate();
        ps.close();
        cnx.close();
       }  
      }
    
    @Override
    public void supprimer(Panier p) throws SQLException {
        String req = "DELETE FROM panier WHERE panier_id = ? and produit_id = ?";
        try (PreparedStatement ps = cnx.prepareStatement(req)){
        ps.setInt(1, p.getPanier_id());
        ps.setInt(2, p.getProduit_id());
        ps.executeUpdate();
        ps.close();
    }
    }

   
    
    
     public void updatePanier(Panier p , int quantite) throws SQLException {
    try {
        String req = "UPDATE panier SET quantite = ? WHERE panier_id = ?";
        try (PreparedStatement st = cnx.prepareStatement(req)) {
            st.setInt(1, quantite);
            st.setInt(2, p.getPanier_id());
            st.executeUpdate();
        }
    } catch (SQLException e) {
    }
}
    @Override
    public Panier afficherParId(int panierId) throws SQLException {
       String req = "SELECT * FROM panier WHERE panier_id=?";
       Panier p = new Panier();
      PreparedStatement pst = cnx.prepareStatement(req);
        pst.setInt(1, panierId);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            int produitId = rs.getInt("produit_id");
            int quantite = rs.getInt("quantite");
            String Date = rs.getString("date");
            p.setPanier_id(panierId); p.setProduit_id(produitId); p.setQuantite(quantite); p.setDate(Date);
        } 
    return p ; 

 
}

    @Override
    public void modifier(Panier t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Panier> Consulter(Panier t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }



}