/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import entities.Event;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author WHITE SHARK
 */
public class SingleEventController implements Initializable {

    @FXML
    private ImageView afficheIv;
    @FXML
    private Text titleText;
    @FXML
    private Text descText;
    @FXML
    private Text startDateText;
    @FXML
    private Button moreInfoBtn;
    
    private Event eventInfo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void setData(Event e){
        titleText.setText(e.getTitle());
        descText.setText(e.getDescription());
        startDateText.setText(String.valueOf(e.getStartDate()));
        
        //Convert byte[] to InputStream then read it
        ByteArrayInputStream inputStream = new ByteArrayInputStream(e.getAffiche());
        Image image = new Image(inputStream);
        afficheIv.setImage(image);
        
        //Save event Id:
        eventInfo = e;
    }

    @FXML
    private void afficherMoreInfo(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("EventInfo.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("Event Info");
            stage.show();
            EventInfoController controller = loader.getController();
            controller.sendEvent(eventInfo);
            
        } catch (IOException ex) {
            System.out.println("error" + ex.getMessage());
        }
    }
    
}
