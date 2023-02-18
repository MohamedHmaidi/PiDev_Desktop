/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import entities.User;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author Mohamed
 */
public class UserController implements Initializable {

    private Label noml;
    private Label prenoml;
    private Label emaillb;
    @FXML
    private Label user;
    @FXML
    private Label email;
    @FXML
    private Label role;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO  
    }  
    
     public void setUser(User p){
        
            user.setText(p.getNom()+" "+p.getPrenom());
            email.setText(p.getEmail());
            role.setText(p.getRole());
            
        
        
        }
    
    
    
}
