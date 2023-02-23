/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import entities.Commande;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import services.CommandeService;

/**
 * FXML Controller class
 *
 * @author ashre
 */
public class CommandeController implements Initializable {

    @FXML
    private ImageView gobackft;
    @FXML
    private TextField prenomft;
    @FXML
    private TextField nomft;
    @FXML
    private TextField numtelft;
    @FXML
    private TextField rueft;
    @FXML
    private TextField villeft;
    @FXML
    private TextField codeposft;
    
    CommandeService PS = new CommandeService(); 
    @FXML
    private Button suivant;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void gobackClick(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Panier.fxml"));
            Parent root = loader.load();

            gobackft.getScene().setRoot(root);
        
    }

    @FXML
    private void insereCommande(ActionEvent event) throws SQLException {
        Commande p = new Commande();
        p.setPrenom(prenomft.getText());
        p.setNom(nomft.getText());
        p.setTel(numtelft.getText());
        p.setRue(rueft.getText());
        p.setVille(villeft.getText());
        p.setCode_postal((codeposft.getText()));
        PS.ajouter(p);
        
        Alert alert = new Alert(Alert.AlertType.ERROR);
       alert.setTitle("Email non valide");
       alert.setHeaderText(null);
       alert.setContentText("format email non valide!");
       alert.show();
    }
    
    
}
    

