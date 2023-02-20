/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import entities.User;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.sql.SQLException;

import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import services.UserService;

/**
 * FXML Controller class
 *
 * @author Mohamed
 */
public class InscriptionUserController implements Initializable {

    @FXML
    private ChoiceBox<String> choices;
    @FXML
    private TextField nomtf;
    @FXML
    private TextField prenomtf;
    @FXML
    private TextField emailtf;
    @FXML
    private TextField teltf;
    @FXML
    private PasswordField mdptf;
    @FXML
    private Button ajouter;
    
   UserService us= new UserService();
    @FXML
    private Button annuler;
    @FXML
    private Button uploadImgBtn;
    
    private byte[] imageData;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        choices.getItems().add("Artiste");
        choices.getItems().add("simple utilisateur");
        choices.getSelectionModel().select("Artiste");
        
        
    }    

    @FXML
    private void ajouter(ActionEvent event) throws SQLException {
        
       
       String email=emailtf.getText();
       String tel= teltf.getText();
      
       
       if (!email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
     Alert alert = new Alert(AlertType.INFORMATION);
       alert.setTitle("Information Dialog");
       alert.setHeaderText(null);
       alert.setContentText("format email non valide!");
       alert.show();  }
       
        else if  (us.existemail(email)==true){
           
           
           
           Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Cet email est déjà enregistré!");
                alert.show();
           }
       
       
       
       
       
       else if (!tel.matches("\\d{8}")){
               
               Alert alert = new Alert(AlertType.INFORMATION);
       alert.setTitle("Information Dialog");
       alert.setHeaderText(null);
       alert.setContentText("format tel non valide!");
       alert.show();    
                
}
       
      
    
       else  { 
           
           
           
           
           try {
               
       
        User p = new User(); 
        p.setNom(nomtf.getText());
        p.setPrenom(prenomtf.getText());
        p.setTel(Integer.parseInt(teltf.getText()));
        p.setRole(choices.getValue());
        p.setEmail(emailtf.getText());
        p.setMdp(mdptf.getText()); 
        p.setImage(imageData);
        us.ajouter(p);
        
        
        
          Alert alert = new Alert(AlertType.INFORMATION);
       alert.setTitle("Information Dialog");
       alert.setHeaderText(null);
       alert.setContentText("utilisateur ajouté!");
       alert.show();    
        }
        
        catch (SQLException ex) {
            System.out.println("error" + ex.getMessage());
        }
        
       }
    }

    @FXML
    private void annuler(ActionEvent event) {
        
        
        nomtf.setText("");
        prenomtf.setText("");
        emailtf.setText("");
        teltf.setText("");
        mdptf.setText("");
    }

    @FXML
   private void onUploadButtonClick(ActionEvent event) {
        
         FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Image File");
        fileChooser.getExtensionFilters().addAll(
        new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));
        File selectedFile = fileChooser.showOpenDialog(null);
        if (selectedFile != null) {
            try {
                imageData = Files.readAllBytes(selectedFile.toPath());
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
        
        
        
        
        
        
    }
    
}
