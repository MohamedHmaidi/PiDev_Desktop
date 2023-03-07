/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author WHITE SHARK
 */
public class SidebarController implements Initializable {

    @FXML
    private Button eventListBtn;
    private MainContainerController mcc;
    @FXML
    private Button homeBtn;
    @FXML
    private Button produitsBtn;
    @FXML
    private Button reclamationsBtn;
    @FXML
    private Button commandeBtn;
    @FXML
    private Button LocationBtn;
    @FXML
    private Button utilisateursBtn;
    /**
     * Initializes the controller class.
     */
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    
    
    

    @FXML
    private void eventListPage(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AfficherListeEvent.fxml"));
            Parent root = loader.load();
            MCCSaver.mcc.setContent(root);
            AfficherListeEventController controller = loader.getController();
          
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void homePage(ActionEvent event) {
    }

    @FXML
    private void produitsPage(ActionEvent event) {
    }

    @FXML
    private void reclamationPage(ActionEvent event) {
    }

    @FXML
    private void commandePage(ActionEvent event) {
    }

    @FXML
    private void locationPage(ActionEvent event) {
    }

    @FXML
    private void utilisateursPage(ActionEvent event) {
    }
    
}
