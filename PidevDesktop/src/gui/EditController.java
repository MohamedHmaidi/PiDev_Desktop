/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import entities.User;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import services.UserService;

/**
 * FXML Controller class
 *
 * @author Mohamed
 */
public class EditController implements Initializable {

    @FXML
    private Label nom;
    @FXML
    private Label prenom;
    @FXML
    private Label email;
    @FXML
    private Label tel;
    @FXML
    private Label mdp;
    @FXML
    private Label role;
    @FXML
    private Button delb;
    @FXML
    private Button modb;

    private User user;
    
    private UserService  us=new UserService();
    @FXML
    private ImageView pdp;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }  
    
    
     void senduser(User u) {
        
        user=u;
        nom.setText(user.getNom());
        prenom.setText(user.getPrenom());
        email.setText(user.getEmail());
        tel.setText(Integer.toString(user.getTel()));
        mdp.setText(user.getMdp());
        role.setText(user.getRole());
         ByteArrayInputStream inputStream = new ByteArrayInputStream(user.getImage());
       Image image = new Image(inputStream);
       pdp.setImage(image);
        
    }

    @FXML
    private void delete(ActionEvent event)  {
         try {
            us.supprimer(user);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        
        
        
        
        
    }

    @FXML
    private void modifier(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("Update.fxml"));
            Parent root = loader.load();
        
        
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Profile");
        stage.setScene(scene);
        stage.show();
        
       UpdateController controller = loader.getController();
        controller.senduser(user);
        
        
        
    }
    
    
    
    
    
}
