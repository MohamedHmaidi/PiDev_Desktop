/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import entities.Event;
import entities.Location;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.sql.SQLException;
import java.util.List;
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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import services.EventService;
import services.LocationService;

/**
 * FXML Controller class
 *
 * @author WHITE SHARK
 */
public class ModifierEventController implements Initializable {

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
    private ChoiceBox<String> statusCBox;
    @FXML
    private Button updateBtn;
    
    private Event eventInfo;
    
    private byte[] imageData;
    
    EventService es = new EventService();
    LocationService locS = new LocationService();
    @FXML
    private ImageView imagePreview;
    @FXML
    private Button cancelBtn;
    @FXML
    private ChoiceBox<String> locationCBox;
    private String selectedLoc;
    private int selectedLocId;
    @FXML
    private TextField ticketPriceTf;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Set status choice box values
        statusCBox.setValue("ongoing");
        statusCBox.getItems().addAll("ongoing", "pending", "ended");
        statusCBox.setOnAction(event -> {
            String selected = statusCBox.getValue();
        });
        
        //Set location choice box values
        try {
            List<Location> locations = locS.recuperer();
            locationCBox.setValue(locations.get(0).getLieu_loc());
            for (int i = 0; i < locations.size(); i++){
                locationCBox.getItems().add(locations.get(i).getLieu_loc());
            }
            locationCBox.setOnAction(event -> {
                selectedLoc = locationCBox.getValue();
                for (Location location : locations) {
                    if (location.getLieu_loc().equals(selectedLoc)) {
                        selectedLocId = location.getId_loc();
                        break;
                    }
                }
            });
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    void eventReceiver(Event eventInfoStore) {
        try {
            eventInfo = eventInfoStore;
            titleTf.setText(eventInfoStore.getTitle());
            typeTf.setText(eventInfoStore.getType());
            descTa.setText(eventInfoStore.getDescription());
            startDateDp.setValue((eventInfoStore.getStartDate()).toLocalDate());
            endDateDp.setValue((eventInfoStore.getEndDate()).toLocalDate());
            ticketCountTf.setText(String.valueOf(eventInfoStore.getTicketCount()));
            imageData = eventInfoStore.getAffiche();
            statusCBox.setValue(eventInfoStore.getStatus());
            locationCBox.setValue(locS.getLieu(eventInfoStore.getLocation_id()));
            ticketPriceTf.setText(Float.toString(eventInfoStore.getTicketPrice()));
            
            //Convert byte[] to InputStream then show it
            ByteArrayInputStream inputStream = new ByteArrayInputStream(eventInfoStore.getAffiche());
            Image image = new Image(inputStream);
            imagePreview.setImage(image);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
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
                //Convert byte[] to InputStream then show it
                ByteArrayInputStream inputStream = new ByteArrayInputStream(imageData);
                Image image = new Image(inputStream);
                imagePreview.setImage(image);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    @FXML
    private void updateEvent(ActionEvent event) {
        try {
            Event e = new Event();
            e.setEvent_id(eventInfo.getEvent_id());
            e.setTitle(titleTf.getText());
            e.setType(typeTf.getText());
            e.setDescription(descTa.getText());
            e.setStartDate(java.sql.Date.valueOf(startDateDp.getValue())); //Gives a local date so I converted to Date
            e.setEndDate(java.sql.Date.valueOf(endDateDp.getValue()));
            e.setTicketCount(Integer.parseInt(ticketCountTf.getText()));
            e.setLocation_id(selectedLocId);
            e.setAffiche(imageData);
            e.setStatus(statusCBox.getValue());
            e.setTicketPrice(Float.parseFloat(ticketPriceTf.getText()));
            es.modifier(e);
            eventInfo = e;
            //Redirect back to event info page
            FXMLLoader loader = new FXMLLoader(getClass().getResource("EventInfo.fxml"));
            Parent root = loader.load();
            MCCSaver.mcc.setContent(root);
            EventInfoController controller = loader.getController();
            controller.sendEvent(eventInfo);
        } catch (SQLException | IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void cancel(ActionEvent event) {
        try {
            //Redirect back to event info page
            FXMLLoader loader = new FXMLLoader(getClass().getResource("EventInfo.fxml"));
            Parent root = loader.load();
            MCCSaver.mcc.setContent(root);
            EventInfoController controller = loader.getController();
            controller.sendEvent(eventInfo);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    
    
}
