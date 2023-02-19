/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import entities.Reclamation;
import entities.Reponses;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import services.ReclamationService;
import services.ReponsesService;

/**
 * FXML Controller class
 *
 * @author Theto
 */
public class AffichReclamOneController implements Initializable {

    @FXML
    private Label TitreRec;
    @FXML
    private Label TypeRec;
    @FXML
    private Label DescRec;
    @FXML
    private Label DateCreation;
    @FXML
    private Label StatusRec;

    private ReclamationService rs = new ReclamationService();
    private ReponsesService Reps = new ReponsesService();

    private int rec_id;
    @FXML
    private TextArea RepText;
    @FXML
    private Button AddRep;
    @FXML
    private ImageView GoBckBtn;
    private int userId;
    @FXML
    private Label DescRep;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void setUserId(int userId) {
    this.userId = userId;
}


    public void setRecId(int rec_id) throws SQLException {
    this.rec_id = rec_id;

    // Get the reclamation with the specified ID from the database
    Reclamation r = rs.recupererParId(rec_id);
    List<Reponses> reponses = Reps.recupererParRecId(rec_id);

    // Set the labels to display the reclamation data
    DescRep.setText("");
    for (Reponses rep : reponses) {
        DescRep.setText(DescRep.getText() + rep.getRep_desc() + "\n");
    }
    TypeRec.setText("Type de Reclamation: " +r.getType());
    TitreRec.setText(r.getTitre_rec());
    DescRec.setText(r.getDescription());
    DateCreation.setText(r.getDate_creation().toString());
    StatusRec.setText("Status: " +r.getStatus());
}


    @FXML
    private void AjoutRep(ActionEvent event) throws SQLException {
        // Get the response description from the text area
        String repDesc = RepText.getText();

        // Create a new Reponses object with the rec_id, user_id, and response description
        Reponses rep = new Reponses();
        rep.setRec_id(rec_id);
        rep.setUser_id(userId);
        rep.setRep_desc(repDesc);
        rep.setDate_rep(new Date());

        // Call the ajouter method of ReponsesService and pass the new Reponses object to it
        Reps.ajouter(rep);

}


    @FXML
private void GoBck(MouseEvent event) throws IOException {
    // Load the new FXML file
    FXMLLoader loader = new FXMLLoader(getClass().getResource("AfficherReclamations.fxml"));
    Parent root = loader.load();

    // Set the root of the current scene to the new FXML file
    AfficherReclamationsController controller = loader.getController();
    controller.setNewUserId(userId);

    GoBckBtn.getScene().setRoot(root);
}

}
