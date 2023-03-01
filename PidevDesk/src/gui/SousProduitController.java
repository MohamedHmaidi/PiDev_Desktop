/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import entities.produit;
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
import javafx.scene.control.Alert;
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
public class SousProduitController implements Initializable {

    @FXML
    private Label codeNom;
    @FXML
    private Label produitprix;
    @FXML
    private TextField caltotal;
    private Panier pp=new Panier();
    PanierService ps =new PanierService();
    
    private produit po=new produit();
    
    private Label sstotal;
    @FXML
    private Button ajoutprod;
    @FXML
    private Button supprod;
    @FXML
    private AnchorPane anchorpane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    void setProd(produit p) {
      codeNom.setText(p.getCodeProduit());
        produitprix.setText(Float.toString(p.getPrixUnite()));
        caltotal.setText(Integer.toString(pp.getQuantite()));
        pp.setId_produit(p.getId());
        pp.setId_user(4);
    }
    
//    private void calculsom(KeyEvent event) throws SQLException {
//       int q = Integer.parseInt(caltotal.getText()) ; 
//        System.out.println(q);
//        int p = Integer.parseInt(produitprix.getText());
//        int s = p*q ; 
//        sstotal.setText(String.valueOf(s));
//        pp.setQuantite(q);
//      
//    }
    
    private void sstotal(int t) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Panier.fxml"));
        AnchorPane pane = loader.load();
        PanierController controller = loader.getController();
        controller.calstotal(t);
    }

    @FXML
    private void ajoutProd(ActionEvent event) {
        if (ps.productExist(pp, 4)) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
       alert.setTitle("Information Dialog");
       alert.setHeaderText(null);
       alert.setContentText("Le produit existe déjà dans le panier!");
       alert.show();
        }
        else  ps.ajouterPanier(pp);
    }

    @FXML
    private void suppProd(ActionEvent event) {
        anchorpane.getChildren().clear();
        ps.supprimerProduitParId(1);
    }
    
}


