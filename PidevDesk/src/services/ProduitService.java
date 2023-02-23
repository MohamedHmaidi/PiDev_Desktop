/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import entities.Produit;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.MyDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author ashre
 */
public class ProduitService implements PService<Produit> {
    
    PreparedStatement ps;
    Connection cnx;
    public ProduitService() {
        cnx = MyDB.getInstance().getCnx();
    }

    @Override
    public Produit recupererProduitParId(int id) throws SQLException {
        String req = "SELECT * FROM produit WHERE id = ?";
        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setInt(1, id);
        
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            // Retrieve data from the ResultSet
            String CodeProd = rs.getString("CodeProduit");
            String desig = rs.getString("designation");
            int qte = rs.getInt("QteStock");
            int qtemin = rs.getInt("QteMin");
            int prix = rs.getInt("PrixUnitaire");
            int idunite = rs.getInt("idUnite");
            String img = rs.getString("image");
            int idcat = rs.getInt("idcat");

            // Create a new Produit object with the retrieved data
            Produit produit = new Produit(id, CodeProd, desig, qte, qtemin, prix, idunite, img, idcat);

            return produit;
        } else {
            return null;
        }
    }
}