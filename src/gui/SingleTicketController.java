/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import entities.Event;
import entities.Ticket;
import java.io.File;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import services.EventService;

/**
 * FXML Controller class
 *
 * @author WHITE SHARK
 */
public class SingleTicketController implements Initializable {

    @FXML
    private Text ticketPriceText;
    @FXML
    private Text eventNameText;
    @FXML
    private Text eventStartDateText;
    @FXML
    private Text eventEndDateText;
    @FXML
    private ImageView qrCodeDisplay;
    
    EventService es = new EventService();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    void setData(Ticket t) {
        try {
            Event event = es.getEvent(t.getEvent_id());
            ticketPriceText.setText(String.valueOf(t.getPrice()));
            eventNameText.setText(String.valueOf(t.getEvent_id()));
            eventStartDateText.setText(String.valueOf(event.getStartDate()));
            eventEndDateText.setText(String.valueOf(event.getEndDate()));
            
            //show QR Code:
            File imageFile = new File(t.getQrCodeImg());
            Image image = new Image(imageFile.toURI().toString());
            qrCodeDisplay.setImage(image);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    
}
