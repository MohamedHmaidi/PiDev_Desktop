/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import entities.Commande;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author ashre
 */
public class SousAdminCommandeController implements Initializable {

    private Label nom;
    @FXML
    private Label commande_id;
    @FXML
    private Button details;
    @FXML
    private Button confirmer;
    @FXML
    private Button supprimer;
    @FXML
    private Label user_id;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    void SetCommande(Commande r) {
        
       user_id.setText(Integer.toString(r.getUser_id()) );
       commande_id.setText(Integer.toString(r.getCommande_id()));
       
        
//      datec.setText(r.getDate_commande());
    }
    
}
