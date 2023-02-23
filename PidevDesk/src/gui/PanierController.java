/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import entities.Produit;
import java.sql.SQLException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import services.ProduitService;

/**
 * FXML Controller class
 *
 * @author ashre
 */
public class PanierController implements Initializable {

    @FXML
    private VBox prixft;
    
    
    
    ProduitService PS = new ProduitService() ;
    @FXML
    private FlowPane flowp;
    @FXML
    private Button gonext;
    @FXML
    private Label totals;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
           try {
    List<Produit> produits = new ArrayList<>();
    produits.add(PS.recupererProduitParId(1));
    produits.add(PS.recupererProduitParId(2));
    produits.add(PS.recupererProduitParId(3));
    produits.add(PS.recupererProduitParId(4));
    produits.add(PS.recupererProduitParId(5));
    produits.add(PS.recupererProduitParId(6));
    produits.add(PS.recupererProduitParId(7));
   // Set the horizontal spacing between the AnchorPanes
flowp.setHgap(10.0);

// Set the preferred wrap length to a large value to avoid wrapping
flowp.setPrefWrapLength(Double.MAX_VALUE);

// Iterate over the produits and add them to the FlowPane
for (Produit produit : produits) {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("Prod.fxml"));
    AnchorPane pane = loader.load();

    ProdController controller = loader.getController();
    controller.setProd(produit);

    flowp.getChildren().add(pane);
}
} catch (SQLException ex) {
    System.out.println("Erreur SQL : " + ex.getMessage());
} catch (IOException ex) {
    System.out.println("Erreur d'entrée/sortie : " + ex.getMessage());
}
    }

   
    @FXML
    private void appliquerNext(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Commande.fxml"));
            Parent root = loader.load();

            gonext.getScene().setRoot(root);
    }


    void setPrice(int s) {
        totals.setText(String.valueOf(s));
    }
    
  void caltotal(int t) {
      List <Integer> l = new ArrayList() ; 
    int p=0 ; 
    p = p+t;
    l.add(p);
      System.out.println(l);
//      totals.setText(String.valueOf(p));
  }  

    @FXML
    private void nextPanier(ActionEvent event) {
        
    }
}
