/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import entities.Event;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.text.Text;
import javafx.stage.Stage;
import services.EventService;

/**
 * FXML Controller class
 *
 * @author WHITE SHARK
 */
public class EventInfoController implements Initializable {

    @FXML
    private Text eventIdText;
    
    private Event eventInfoStore;
    
    EventService es = new EventService();
    @FXML
    private Text titleText;
    @FXML
    private Text startDateText;
    @FXML
    private Button deleteBtn;
    @FXML
    private Button updateBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
    }    

    void sendEvent(Event eventInfo) {
        eventInfoStore = eventInfo;
        eventIdText.setText(String.valueOf(eventInfoStore.getEvent_id()));
        titleText.setText(eventInfoStore.getTitle());
        startDateText.setText(String.valueOf(eventInfoStore.getStartDate()));
        
    }

    @FXML
    private void deleteEvent(ActionEvent event) {
        try {
            es.supprimer(eventInfoStore);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AfficherListeEvent.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("Event List");
            stage.show();
        } catch (SQLException | IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void updateEvent(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AjouterEvent.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("Update Event");
            stage.show();
            AjouterEventController controller = loader.getController();
            controller.eventReceiver(eventInfoStore);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
