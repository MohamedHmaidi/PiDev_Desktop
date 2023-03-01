/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import entities.Commande;
import entities.Panier;
import entities.produit;
import utils.MyDB;
import java.sql.SQLException;
import java.util.List;
import services.CommandeService;
import services.PanierService;
//import services.ProduitService;
/**
 *
 * @author ashre
 */
public class test {
    public static void main(String[] args) throws SQLException {
        
        MyDB db = new MyDB();
        Panier a = new Panier(2,1,4);
        Panier b = new Panier(3,1,4);
//        Panier c = new Panier(1,1);
//        Panier d = new Panier(11,1);
        PanierService PS = new PanierService() ;
//        PS.afficherPanier(1);
        
       CommandeService Z = new CommandeService();
       
     List<Commande> reclam = Z.recupererCommande();
     System.out.println("Liste des reclamations");
            for (Commande recl : reclam) {
                System.out.println(recl.toString());
            }


//        PS.ajouterPanier(a);
//        PS.ajouterPanier(b);
////        PS.ajouterPanier(c);
        
        }  
    }

