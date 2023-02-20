/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import entities.Event;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import services.EventService;

/**
 * FXML Controller class
 *
 * @author WHITE SHARK
 */
public class AfficherListeEventController implements Initializable {

    @FXML
    private ScrollPane eListScrollPane;
    @FXML
    private GridPane eventListGP;
    
    EventService es = new EventService();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            List<Event> events = es.recuperer();
            int row = 0;
            int column = 0;
            for (int i = 0; i < events.size(); i++){
                FXMLLoader loader = new FXMLLoader(getClass().getResource("SingleEvent.fxml"));
                AnchorPane pane = loader.load();
                SingleEventController controller = loader.getController();
                controller.setData(events.get(i));
                
                
                eventListGP.add(pane, column, row);
                    row++;
                    if (column > 0) {
                        column = 0;
                        row++;
                    }
            }
            //eventListGP.prefHeightProperty().bind(eventListGP.prefHeightProperty());
        } catch (SQLException | IOException ex) {
            Logger.getLogger(AfficherListeEventController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
}
