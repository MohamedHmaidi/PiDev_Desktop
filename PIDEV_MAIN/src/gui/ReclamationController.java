/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import entities.Reclamation;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Theto
 */
public class ReclamationController implements Initializable {

    @FXML
    private Label TypRec;
    @FXML
    private Label StatusRec;
    @FXML
    private Button BtnOpnRec;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void SetReclamation(Reclamation r) {
        TypRec.setText(r.getType());
        StatusRec.setText(r.getStatus());
    }

    @FXML
    private void OpenRec(ActionEvent event) {
    }
    
}
