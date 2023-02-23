/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import entites.produit;
import java.io.File;
import javafx.scene.image.Image;

/**
 * FXML Controller class
 *
 * @author Monta
 */
public class ProduitController implements Initializable {

    @FXML
    private Label nomProduirLabel;
    @FXML
    private Label QunatiteLabel;
    @FXML
    private Label descriptionLabel;
    @FXML
    private Button participerEventButton;
    @FXML
    private Label prixlabel;
    @FXML
    private ImageView imageview;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void participerEvent(MouseEvent event) {
    }
    
      public void setProduit(produit e) {
        
        nomProduirLabel.setText(e.getCodeProduit());
        QunatiteLabel.setText(String.valueOf(e.getQteStock()));
        descriptionLabel.setText(e.getDesgination());
        prixlabel.setText(String.valueOf(e.getPrixUnite()));
         String path = e.getImage();
               File file=new File(path);
              Image img = new Image(file.toURI().toString());
                imageview.setImage(img);
       

    }
    
}
