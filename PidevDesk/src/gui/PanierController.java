/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import entities.produit;
import entities.Panier;
import java.sql.SQLException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import services.PanierService;
//import services.ProduitService;

/**
 * FXML Controller class
 *
 * @author ashre
 */
public class PanierController implements Initializable {

    
    PanierService PS = new PanierService() ;
    
    @FXML
    private Button suivant;
    @FXML
    private FlowPane flowp;
    @FXML
    private Button viderPanier;
    @FXML
    private Label caltotale;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
    List<produit> produits = new ArrayList<>();
    produits.add(PS.recupererProduitParId(1));
    produits.add(PS.recupererProduitParId(2));
    produits.add(PS.recupererProduitParId(3));
//    produits.add(PS.recupererProduitParId(4));
//    produits.add(PS.recupererProduitParId(5));
//    produits.add(PS.recupererProduitParId(6));
//    produits.add(PS.recupererProduitParId(7));
   // Set the horizontal spacing between the AnchorPanes
flowp.setHgap(10.0);

// Set the preferred wrap length to a large value to avoid wrapping
flowp.setPrefWrapLength(Double.MAX_VALUE);

// Iterate over the produits and add them to the FlowPane
for (produit produit : produits) {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("SousProduit.fxml"));
    AnchorPane pane = loader.load();

    SousProduitController controller = loader.getController();
    controller.setProd(produit);

    flowp.getChildren().add(pane);
}
} catch (IOException ex) {
    System.out.println("Erreur d'entrée/sortie : " + ex.getMessage());
}
    }    
  
    void calstotal(int t) {
      List <Integer> l = new ArrayList() ; 
    int p=0 ; 
    p = p+t;
    l.add(p);
      System.out.println(l);
//      totals.setText(String.valueOf(p));
  }  
    
    void caltotale(int tot){
        
       
       }
    
    

    @FXML
    private void supPanier(ActionEvent event) {
        flowp.getChildren().clear(); //supprimer les produits de l'affichage
        PS.supprimerPanier(4);
    }

    @FXML
    private void nextCommande(ActionEvent event) {
        try {
        // Charger la nouvelle vue depuis le fichier FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Commande.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        
        // Récupérer la scène actuelle à partir de l'événement
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        
        // Définir la nouvelle scène et l'afficher
        stage.setScene(scene);
        stage.show();
    } catch (IOException e) {
        e.printStackTrace();
    }
    }
}
