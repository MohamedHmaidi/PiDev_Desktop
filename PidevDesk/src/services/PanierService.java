/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import entities.Panier;
import entities.produit;
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
 * @author ashre
 */
public class PanierService implements IService<Panier> {

    Connection cnx;
    public PanierService() {
        cnx = MyDB.getInstance().getCnx();
    }

    public void ajouterPanier(Panier p) {

        try {
            String req = "INSERT INTO panier (id_produit,id_user,quantite) VALUES (?,?,?)";
            PreparedStatement pst = cnx.prepareStatement(req);
            /*pst.setInt(1,t.getIdp());
            pst.setInt(2, t.getCategory_id());*/
            pst.setInt(1, p.getProduit_id());
            pst.setInt(2, p.getId_user());
            pst.setInt(3, p.getQuantite());

            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }
    
    
    public void supprimerPanier(int id_user) {
        try {
            
            String req = "DELETE FROM panier WHERE id_user=? " ;
            PreparedStatement pst = cnx.prepareStatement(req);

            
            pst.setInt(1, id_user);

            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
 public void supprimerProduitParId(int id_produit) {
        try {
            
            String req = "DELETE FROM panier WHERE id_produit=? " ;
            PreparedStatement pst = cnx.prepareStatement(req);

            
            pst.setInt(1, id_produit);

            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

 public List<produit> afficherPanier(int id_user) {
        List<produit> list = new ArrayList<>();
        try {
            String req = "SELECT * FROM panier where id_user=" + id_user;
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                produit p;
                p = this.recupererProduitParId(rs.getInt(1));
                list.add(p);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }



public produit recupererProduitParId(int id_produit) {
        produit p = new produit();

        try {
            Statement st = cnx.createStatement();
            String query = "select * FROM produit WHERE id=" + id_produit ;
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {

                p.setId(rs.getInt(1));
                p.setCodeProduit(rs.getString(2));
                p.setDesgination(rs.getString(3));
                p.setQteStock(rs.getInt(4));
                p.setQteMin(rs.getInt(5));
                p.setPrixUnite(rs.getInt(6));
                p.setIdUnite(rs.getInt(7));
                p.setImage(rs.getString(8));
                p.setIdCat(rs.getInt(9));
            }

        } catch (SQLException ex) {
            System.out.println("erreur get IdOBJ pour suivi");
            System.out.println(ex);
        }

        return p;

    }


 public Boolean productExist(Panier p, int id_user) {
        System.out.println(p.getId_produit()+"user:"+id_user);

        try {
            Statement st = cnx.createStatement();
            String query = "SELECT * FROM panier WHERE id_produit="+p.getId_produit()+" and id_user="+id_user ;
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {

              return true;

            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return false;

    }
    

    @Override
    public void modifier(Panier t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Panier> Consulter(Panier t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Panier afficherParId(int panier_id) throws SQLException {
       
        return null;
       
    }

    @Override
    public void supprimer(Panier t) throws SQLException {
      
    }

    @Override
    public void ajouter(Panier t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }



}