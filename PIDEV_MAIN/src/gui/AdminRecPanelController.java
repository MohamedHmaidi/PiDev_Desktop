/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import entities.Reclamation;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import services.ReclamationService;

/**
 * FXML Controller class
 *
 * @author Theto
 */

    
public class AdminRecPanelController implements Initializable {
    
    

    @FXML
    //fxid FlowPane
    private FlowPane AllRecFlow;
    
    //initiation Service Reclamation
    private ReclamationService rs = new ReclamationService();
    @FXML
    private Label AdminId;

    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // Recuperer toutes les reclam
            List<Reclamation> reclamations = rs.recuperer();          
            //Créez une nouvelle instance de ReclamationController pour chaque récupération et ajoutez-la au FlowPane
            for (Reclamation r : reclamations) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("ReclamationAdmin.fxml"));
                Pane reclamationNode = loader.load();
                // Récupérer le contrôleur ReclamationController
                ReclamationAdminController recAdController = loader.getController();
                
                String AdminIdentificateur = AdminId.getText().substring(11);
                System.out.println( AdminIdentificateur); //debugging
                
                // Définir les données de la réclamation, recid, admin_id dans le contrôleur
                recAdController.SetReclamation(r, r.getRec_id(),Integer.parseInt(AdminIdentificateur));
                
                // Ajouter le nœud de réclamation à FlowPane
                AllRecFlow.getChildren().add(reclamationNode);
            }
        } catch (IOException ex) {
            System.err.println("erreur: " + ex.getMessage());

        } catch (SQLException ex) {
            System.err.println("erreur BD: " + ex.getMessage());
        }

    }     
    
}
