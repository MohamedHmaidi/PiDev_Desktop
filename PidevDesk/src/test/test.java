/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import entities.Commande;
import entities.Panier;
import entities.SMSSender;
import entities.produit;
import utils.MyDB;
import java.sql.SQLException;
import java.util.List;
import static javafx.scene.input.KeyCode.S;
import services.CommandeService;
import services.PanierService;
//import services.ProduitService;
/**
 *
 * @author ashre
 */
public class test {
    public static void main(String[] args) throws SQLException {
        
        PanierService SS =new PanierService();
        SS.recupererlastPanier(4);
        System.out.println(SS.toString());
        
      
        }  
    }

