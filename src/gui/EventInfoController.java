/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import entities.Event;
import entities.Ticket;
import java.io.ByteArrayInputStream;
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
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import services.EventService;
import services.LocationService;
import services.TicketService;
import services.UserService;

/**
 * FXML Controller class
 *
 * @author WHITE SHARK
 */
public class EventInfoController implements Initializable {

    private Text eventIdText;
    
    private Event eventInfoStore;
    
    EventService es = new EventService();
    UserService us = new UserService();
    LocationService locS = new LocationService();
    TicketService ts = new TicketService();
    
    @FXML
    private Text titleText;
    @FXML
    private Text startDateText;
    @FXML
    private Button deleteBtn;
    @FXML
    private Button updateBtn;
    @FXML
    private Button backBtn;
    @FXML
    private ImageView afficheIv;
    @FXML
    private Text typeText;
    @FXML
    private Text statusText;
    @FXML
    private Text endDateText;
    @FXML
    private Text locationAddressText;
    @FXML
    private Text descText;
    @FXML
    private Text hostNameText;
    @FXML
    private Text ticketCountText;
    @FXML
    private ScrollPane sPane;
    @FXML
    private Button buyBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
    }    

    void sendEvent(Event eventInfo) {
        try {
            eventInfoStore = eventInfo;
            titleText.setText(eventInfo.getTitle());
            typeText.setText(eventInfo.getType());
            statusText.setText(eventInfo.getStatus());
            startDateText.setText(String.valueOf(eventInfo.getStartDate()));
            endDateText.setText(String.valueOf(eventInfo.getEndDate()));
            locationAddressText.setText(locS.getLieu(eventInfo.getLocation_id()));
            hostNameText.setText(us.getNom(eventInfo.getHost_id()));
            ticketCountText.setText(String.valueOf(eventInfo.getTicketCount()));
            descText.setText(eventInfo.getDescription());
            ByteArrayInputStream inputStream = new ByteArrayInputStream(eventInfo.getAffiche());
            Image image = new Image(inputStream);
            afficheIv.setImage(image);
            buyBtn.setText("Get your ticket! "+eventInfo.getTicketPrice()+" dt.");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void deleteEvent(ActionEvent event) {
        try {
            es.supprimer(eventInfoStore);
            //Redirect back to event list
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AfficherListeEvent.fxml"));
            Parent root = loader.load();
            MCCSaver.mcc.setContent(root);
        } catch (SQLException | IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void updateEvent(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifierEvent.fxml"));
            Parent root = loader.load();
            MCCSaver.mcc.setContent(root);
            ModifierEventController controller = loader.getController();
            controller.eventReceiver(eventInfoStore);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void goBackToList(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AfficherListeEvent.fxml"));
            Parent root = loader.load();
            MCCSaver.mcc.setContent(root);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void buyTicket(ActionEvent event) {
        try {
            Ticket t = new Ticket();
            t.setEvent_id(eventInfoStore.getEvent_id());
            t.setPrice(eventInfoStore.getTicketPrice());
            t.setUser_id(LoginController.UserConnected.getId());
            ts.ajouter(t);
            int newTicketCount = (eventInfoStore.getTicketCount())-1;
            eventInfoStore.setTicketCount(newTicketCount);
            es.modifier(eventInfoStore);
            
            //Extra: Refresh content pane
            FXMLLoader loader = new FXMLLoader(getClass().getResource("EventInfo.fxml"));
            Parent root = loader.load();
            MCCSaver.mcc.setContent(root);
            EventInfoController controller = loader.getController();
            controller.sendEvent(eventInfoStore);
        } catch (SQLException | IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
