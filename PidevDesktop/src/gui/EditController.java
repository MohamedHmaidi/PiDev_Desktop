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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
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
    @FXML
    private ImageView backbtn;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        
Circle clip = new Circle();
clip.setCenterX(pdp.getFitWidth() / 2);
clip.setCenterY(pdp.getFitHeight() / 2);
clip.setRadius(Math.min(pdp.getFitWidth(), pdp.getFitHeight()) / 2);


pdp.setClip(clip);


pdp.fitWidthProperty().bind(clip.radiusProperty().multiply(2));
pdp.fitHeightProperty().bind(clip.radiusProperty().multiply(2));
        
        if (LoginController.UserConnected.getRole().equals("Admin")){
        
        backbtn.setVisible(true);
        
        }
    }  
    
    
     void senduser(User u) {
        
        user=u;
        nom.setText(user.getNom());
        prenom.setText(user.getPrenom());
        email.setText(user.getEmail());
        tel.setText(Integer.toString(user.getTel()));
  
       mdp.setText(user.getMdp().replaceAll(".", "*"));
        role.setText(user.getRole());
         ByteArrayInputStream inputStream = new ByteArrayInputStream(user.getImage());
       Image image = new Image(inputStream);
       pdp.setImage(image);
        
    }

    @FXML
    private void delete(ActionEvent event) throws IOException  {
         try {
            us.supprimer(user);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
       
       alert.setHeaderText(null);
       alert.setContentText("Compte supprimé!");
       alert.show();
       if(!(LoginController.UserConnected.getRole().equals("Admin"))){
       
       
       FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
            Parent root = loader.load();
      
        
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();
       
       }
       
            
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

    @FXML
    private void back(MouseEvent event) throws IOException {
       
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AfficheUser.fxml"));
            Parent root = loader.load();
      
        
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Affiche Users");
        stage.setScene(scene);
        stage.show();
        
        
        
        
        
        
        
        
        
    }
    
    
    
    
    
}
