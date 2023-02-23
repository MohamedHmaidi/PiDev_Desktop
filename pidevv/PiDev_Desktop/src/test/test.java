/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;


import entites.Categorie;
import entites.produit;
import java.sql.SQLException;
import services.CategorieService;
import services.ProduitService;
import utils.MyDB;

/**
 *
 * @author Monta
 */
public class test {
    
    
       public static void main(String[] args) {
                     Categorie c = new Categorie() ;
       
        try {
            produit p = new produit("s","dvdsqvf",2,3,2,2,"dv");
            produit pp = new produit(1,"dvdsqvf","aa","xx",6,3,2,2,7);
             produit p2 = new produit(2);
      
            ProduitService ps = new ProduitService();
            
            CategorieService ps1 = new CategorieService();
        //  ps.ajouter(pp);
            //ps.supprimer(pp);
      //   ps.modifier( p);
           System.out.println(ps1.recupererCat());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
