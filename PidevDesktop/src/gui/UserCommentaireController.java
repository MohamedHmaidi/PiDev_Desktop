/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import entities.Commentaire;
import entities.User;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import services.CommentaireService;

/**
 * FXML Controller class
 *
 * @author Mohamed
 */
public class UserCommentaireController implements Initializable {

    @FXML
    private Label user;
    @FXML
    private Label role;
    @FXML
    private Label comment;
  User UserConnected = LoginController.UserConnected;
    @FXML
    private Button modb1;
    @FXML
    private Button suppb;
    @FXML
    private Button modbt2;
    @FXML
    private TextField zone;
    private Commentaire c2=new Commentaire();
    CommentaireService cs = new CommentaireService();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
    
    
    
    public void setcmnt(Commentaire c){
        
        user.setText(UserConnected.getNom());
       role.setText(UserConnected.getRole());
       comment.setText(c.getCommentaire());
    c2=c;
    
    
    }
    
    
    public void setidcmnt(int id){
        c2.setId_com(id);
    
    }

    @FXML
    private void modifier(ActionEvent event) {
        comment.setVisible(false);
        zone.setText(comment.getText());
        zone.setVisible(true);
        modbt2.setVisible(true);
        modb1.setVisible(false);
        
    }

    @FXML
    private void supprimer(ActionEvent event) throws SQLException {
        
       cs.supprimer(c2);
        System.out.println(c2);
        
        
    }

    @FXML
    private void modif2(ActionEvent event) throws SQLException {
        
        c2.setCommentaire(zone.getText());
        cs.modifier(c2);
        zone.setVisible(false);
        comment.setText(c2.getCommentaire());
        modbt2.setVisible(false);
        modb1.setVisible(true);
        comment.setVisible(true);
        
        
        
    }
    
    
    
    
    
}
