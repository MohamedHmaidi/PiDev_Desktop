/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Theto
 */
public class NotificationController implements Initializable {

    @FXML
    private Label recId;
    @FXML
    private Label RepNbr;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    void setReclamationId(int rec_id) {
        recId.setText(String.valueOf(rec_id));
    }

    void setNumReponses(int numReponses) {
        RepNbr.setText(String.valueOf(numReponses));
        
        } 
            
    }
