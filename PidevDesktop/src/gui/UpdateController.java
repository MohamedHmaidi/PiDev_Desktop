/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import entities.User;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import services.UserService;

/**
 * FXML Controller class
 *
 * @author Mohamed
 */
public class UpdateController implements Initializable {

    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private TextField email;
    @FXML
    private TextField Tel;
    @FXML
    private TextField mdp;
    @FXML
    private ChoiceBox<String> role;
    @FXML
    private Button modb;
    @FXML
    private Button annb;
private User user;
UserService us = new UserService();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         role.getItems().add("Artiste");
        role.getItems().add("simple utilisateur");
        role.getSelectionModel().select("Artiste");
    }    

    
    public void senduser(User p){
    
    user=p;
    
    }
    
    
    
    
    @FXML
    private void modifier(ActionEvent event) throws SQLException , NumberFormatException {
        
        
                
                
        if (!email.getText().isEmpty()) {
    user.setEmail(email.getText());
} 

if (!nom.getText().isEmpty()) {
    user.setNom(nom.getText());
} 

if (!prenom.getText().isEmpty()) {
    user.setPrenom(prenom.getText());
}

if (!Tel.getText().isEmpty()) {
    
        user.setTel(Integer.parseInt(Tel.getText()));
    

}

if (!mdp.getText().isEmpty()) {
    user.setMdp(mdp.getText());
}

if (role.getValue() != null) {
    user.setRole(role.getValue());
} 

        
        
        us.modifier(user);
        
        
    }

    @FXML
    private void reset(ActionEvent event) {
    }
    
}
