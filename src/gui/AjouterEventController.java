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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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
 * @author Aymen
 */
public class AjouterEventController implements Initializable {

    @FXML
    private TextField titleTf;
    @FXML
    private ChoiceBox<String> typeTf;
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
    
    @FXML
    private Button eventListBtn;
    
    private String imagePath;
    private String selectedLoc;
    private int selectedLocId;
    
    EventService es = new EventService();
    LocationService locS = new LocationService();
    
    @FXML
    private ImageView imagePreview;
    @FXML
    private ChoiceBox<String> locationCBox;
    @FXML
    private TextField ticketPriceTf;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            
            //Location choice Box
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
            
            //Event Type choice box
            typeTf.setValue("Plein air");
            typeTf.getItems().addAll("Plein air", "A l'intérieur", "Cérémonie");
            typeTf.setOnAction(event -> {
                String selected = typeTf.getValue();
            });
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
            String imageName = selectedFile.getName();
            imagePath = "src/assets/images/affiches/"+imageName;
            File imageFile = new File(imagePath);
            Image image = new Image(imageFile.toURI().toString());
            imagePreview.setImage(image);
        }
    }

    @FXML
    private void addEvent(ActionEvent event) {
        try {
            String verifTicketCount = ticketCountTf.getText();
            String verifTicketPrice = ticketPriceTf.getText();
            if (!verifTicketCount.matches("\\d+")){
                Alert warn = new Alert(AlertType.INFORMATION);
                warn.setTitle("Invalid Input");
                warn.setContentText("The ticket count value is not valid.");
                warn.setHeaderText(null);
                warn.showAndWait();
            } else if (!verifTicketPrice.matches("\\d+(\\.\\d+)?")) {
                Alert warn = new Alert(AlertType.INFORMATION);
                warn.setTitle("Invalid Input");
                warn.setContentText("The ticket price value is not valid.");
                warn.setHeaderText(null);
                warn.showAndWait();
            } else if (titleTf.getText().isEmpty() || typeTf.getValue().isEmpty() || descTa.getText().isEmpty() || startDateDp.getValue()==null || endDateDp.getValue()==null) {
                Alert warn = new Alert(AlertType.INFORMATION);
                warn.setTitle("Invalid Input");
                warn.setContentText("Please enter values in all fields.");
                warn.setHeaderText(null);
                warn.showAndWait();
            } else if (endDateDp.getValue().isBefore(startDateDp.getValue())) {
                Alert warn = new Alert(AlertType.INFORMATION);
                warn.setTitle("Invalid Input");
                warn.setContentText("End date cannot be before start date.");
                warn.setHeaderText(null);
                warn.showAndWait();
            } else {
                Event e = new Event();
                e.setTitle(titleTf.getText());
                e.setType(typeTf.getValue());
                e.setDescription(descTa.getText());
                e.setStartDate(java.sql.Date.valueOf(startDateDp.getValue())); //Gives a local date so I converted to Date
                e.setEndDate(java.sql.Date.valueOf(endDateDp.getValue()));
                e.setTicketCount(Integer.parseInt(ticketCountTf.getText()));
                e.setHost_id(LoginController.UserConnected.getId());
                e.setLocation_id(selectedLocId);
                e.setAffiche(imagePath);
                e.setTicketPrice(Float.parseFloat(ticketPriceTf.getText()));
                es.ajouter(e);
                FXMLLoader loader = new FXMLLoader(getClass().getResource("AfficherListeEvent.fxml"));
                Parent root = loader.load();
                MCCSaver.mcc.setContent(root); 
            }
            
        } catch (SQLException | IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void eventList(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AfficherListeEvent.fxml"));
            Parent root = loader.load();
            MCCSaver.mcc.setContent(root); 
        } catch (IOException ex) {
            System.out.println("error" + ex.getMessage());
        }
    }

    
    
}
