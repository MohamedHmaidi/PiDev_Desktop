/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import entities.Produit;
import entities.Panier;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import services.PanierService;

/**
 * FXML Controller class
 *
 * @author ashre
 */
public class ProdController implements Initializable {

    @FXML
    private Label code;
    @FXML
    private Label prx;
    @FXML
    private TextField qte;
    @FXML
    private Label calcultotal;
    private Panier pp=new Panier();
    PanierService ps =new PanierService();
    @FXML
    private Button ins;
    Date d = new Date();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void setProd(Produit p) { 
        code.setText(p.getCodeProduit());
        prx.setText(Integer.toString(p.getPrixUnitaire() ));
        
        pp.setProduit_id(p.getId());
        pp.setDate("1");
    }

    @FXML
    private void calculsom(KeyEvent event) throws SQLException {
       int q = Integer.parseInt(qte.getText()) ; 
        System.out.println(q);
        int p = Integer.parseInt(prx.getText());
        int s = p*q ; 
        calcultotal.setText(String.valueOf(s));
        pp.setQuantite(q);
      
    }
    private void calcultotal(int t) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Panier.fxml"));
        AnchorPane pane = loader.load();
        PanierController controller = loader.getController();
        controller.caltotal(t);
    }

    @FXML
    private void insert(ActionEvent event) throws SQLException {
          System.out.println(pp.toString());
        ps.ajouter(pp);
    }
}
//    private void insert(ActionEvent event) throws SQLException {
//        
//        //INSERT INTO panier (produit_id, quantite, date, panier_id) VALUES (?, ?, ?, ?)""
//        
//        
//    }

  