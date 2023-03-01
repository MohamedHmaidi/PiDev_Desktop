/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Administrateur
 */
public class GestionlocauxController implements Initializable {

    @FXML
    private Button btngl;
    @FXML
    private Button btngc;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void gererlocaux(MouseEvent event) {
        
           try{
    Parent root=FXMLLoader.load(getClass().getResource("../gui/gererlaucax.fxml"));
    btngl.getScene().setRoot(root);
    } 
    catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    
    }

    @FXML
    private void gerecategorie(ActionEvent event) {
             try{
    Parent root=FXMLLoader.load(getClass().getResource("../gui/gerercategories.fxml"));
    btngl.getScene().setRoot(root);
    } 
    catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    
        
        
    }
    
}
