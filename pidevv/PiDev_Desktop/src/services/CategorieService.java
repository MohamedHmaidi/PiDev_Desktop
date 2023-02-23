/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import entites.Categorie;
import entites.produit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.MyDB;


/**
 *
 * @author Monta
 */
public  class CategorieService implements ICategorieService<Categorie> {
    
         Connection cnx;
           public Statement ste;
           public PreparedStatement pst;
 

     {
        cnx = MyDB.getInstance().getCnx();

}

    @Override
    public void ajouterCat(Categorie t) throws SQLException {
        String requete = "INSERT INTO categorie (`libcategorie`)"
                + "VALUES (?);";

           try {
            Categorie c = new Categorie() ;
            pst = (PreparedStatement) cnx.prepareStatement(requete);
            
            pst.setString(1,t.getLibCat());
                    
            pst.executeUpdate();
            System.out.println("Categorie " + c.getLibCat() + " added successfully");
        } catch (SQLException ex) {
            Logger.getLogger(ProduitService.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
 @Override
    public void modifierCat(Categorie t) throws SQLException {
        String req = "UPDATE categorie SET libCategorie = ? where idCategorie = ?";
        PreparedStatement ps = cnx.prepareStatement(req);
         ps.setInt(1, t.getId());
        ps.setString(2, t.getLibCat());
        ps.executeUpdate();
          System.out.println("produit " + t.getLibCat() + " modified successfully");
    }
     @Override

    public void supprimerCat(Categorie t) throws SQLException {
       
         String req = "delete from categorie where idCategorie = ?";
        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setInt(1, t.getId());
        ps.executeUpdate();
        System.out.println("event with id= " + t.getId() + "  is deleted successfully");
        
    }
    
     @Override

    public List recupererCat() throws SQLException {
             List<Categorie> Categorie = new ArrayList<>();    
       String s = "select * from categorie";
        Statement st = cnx.createStatement();
        ResultSet rs =  st.executeQuery(s);
         while(rs.next()){
            Categorie p = new Categorie();
            //  p.setId(rs.getInt("idCategorie"));
            p.setLibCat(rs.getString("libCategorie"));
          
            Categorie.add(p);
            
        }
        return Categorie;
    }
}
