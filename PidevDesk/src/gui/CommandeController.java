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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import services.CommandeService;
import test.testfx;

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
    private Button suivCommande;

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
        String prenom=prenomft.getText();
        String nom=nomft.getText();
        String tel=numtelft.getText();
        String rue=rueft.getText();
        String ville=villeft.getText();
        String codepostal=codeposft.getText();
        
        
        if (!prenom.matches("[a-zA-Z]+")) {
       Alert alert = new Alert(AlertType.INFORMATION);
       alert.setTitle("Information Dialog");
       alert.setHeaderText(null);
       alert.setContentText("format prenom non valide!");
       alert.show();  }
        
       else if (!nom.matches("[a-zA-Z]+")) {
       Alert alert = new Alert(AlertType.INFORMATION);
       alert.setTitle("Information Dialog");
       alert.setHeaderText(null);
       alert.setContentText("format nom non valide!");
       alert.show();  }
       
       else if (!tel.matches("\\d{8}")) {
    Alert alert = new Alert(AlertType.INFORMATION);
    alert.setTitle("Information Dialog");
    alert.setHeaderText(null);
    alert.setContentText("Format numéro de téléphone non valide !");
    alert.show();
}
       else if (!rue.matches("[a-zA-Z0-9]+")) {
       Alert alert = new Alert(AlertType.INFORMATION);
       alert.setTitle("Information Dialog");
       alert.setHeaderText(null);
       alert.setContentText("format rue non valide!");
       alert.show();  
       }
        
       else if (!ville.matches("[a-zA-Z]+")) {
       Alert alert = new Alert(AlertType.INFORMATION);
       alert.setTitle("Information Dialog");
       alert.setHeaderText(null);
       alert.setContentText("format ville non valide!");
       alert.show();  
       }
        
        else if (!codepostal.matches("[0-9]+")) {
       Alert alert = new Alert(AlertType.INFORMATION);
       alert.setTitle("Information Dialog");
       alert.setHeaderText(null);
       alert.setContentText("format Code Postal non valide!");
       alert.show();  
        }
        
        else  { 
           try {
        Commande p = new Commande(); 
        p.setPrenom(prenomft.getText());
        p.setNom(nomft.getText());
        p.setTel(numtelft.getText());
        p.setRue(rueft.getText());
        p.setVille(villeft.getText());
        p.setCode_postal(codeposft.getText());
        p.setUser_id(4);
        PS.ajouterCommande(p);
        
        
          Alert alert = new Alert(AlertType.INFORMATION);
       alert.setTitle("Information Dialog");
       alert.setHeaderText(null);
       alert.setContentText("Commande passer");
       alert.show();    
        }
        
        catch (SQLException ex) {
            System.out.println("error" + ex.getMessage());
        }
        
       }
    }
        
        
    }
    

