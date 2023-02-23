/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import entities.Panier;
import entities.Produit;
import utils.MyDB;
import java.sql.SQLException;
import services.PanierService;
import services.ProduitService;
/**
 *
 * @author ashre
 */
public class test {
    public static void main(String[] args) {
        
        MyDB db = new MyDB();
        try {
        Panier p = new Panier(5,1,10); 
        PanierService PS = new PanierService() ;
        ProduitService ProdS = new ProduitService();
        Produit p1 = new Produit();
         p1 = ProdS.recupererProduitParId(1);
        System.out.println(p1);
        Panier PA = PS.afficherParId(p.getPanier_id());
            System.out.println(PA.toString());
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        }  
    }

