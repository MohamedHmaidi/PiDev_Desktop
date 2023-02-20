/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import entities.Event;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import services.EventService;

/**
 * FXML Controller class
 *
 * @author WHITE SHARK
 */
public class AjouterEventController implements Initializable {

    @FXML
    private TextField titleTf;
    @FXML
    private TextField typeTf;
    @FXML
    private TextArea descTa;
    @FXML
    private DatePicker startDateDp;
    @FXML
    private DatePicker endDateDp;
    @FXML
    private TextField ticketCountTf;
    @FXML
    private Button uploadImgBtn;
    @FXML
    private Button addBtn;
    
    private Button eventListBtn;
    
    private byte[] imageData;
    
    private Event eventInfo;
    
    
    
    EventService es = new EventService();
    @FXML
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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

    @FXML
    private void addEvent(ActionEvent event) {
        try {
            Event e = new Event();
            e.setTitle(titleTf.getText());
            e.setType(typeTf.getText());
            e.setDescription(descTa.getText());
            e.setStartDate(java.sql.Date.valueOf(startDateDp.getValue())); //Gives a local date so I converted to Date
            e.setEndDate(java.sql.Date.valueOf(endDateDp.getValue()));
            e.setTicketCount(Integer.parseInt(ticketCountTf.getText()));
            e.setHost_id(1);
            e.setLocation_id(1);
            e.setAffiche(imageData);
            es.ajouter(e);
            System.out.println("event ajouté avec succes");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void eventList(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AfficherListeEvent.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("Event List");
            stage.show();
            
            
        } catch (IOException ex) {
            System.out.println("error" + ex.getMessage());
        }
    }

    void eventReceiver(Event eventInfoStore) {
        eventInfo = eventInfoStore;
        addBtn.setText("Update");
    }
    
}
