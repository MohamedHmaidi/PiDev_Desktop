package gui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import entities.Reclamation;
import entities.Reponses;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import services.ReclamationService;
import services.ReponsesService;

public class NotifPanelUserController implements Initializable {
    
     // Private static instance variable
    public static NotifPanelUserController instance;
    @FXML
    private Label NoNewNotif;
    
    // Private constructor
    public NotifPanelUserController() {}
    
    public static NotifPanelUserController getInstance() {
    if (instance == null) {
        instance = new NotifPanelUserController();
    }
    return instance;
}

    
    public static Set<Integer> viewedReclamations = new HashSet<>();

    
    
    

    @FXML
    private ImageView GoBackBtn;
    @FXML
    private Label NotifNbr;
    @FXML
    private FlowPane NotifContainer;

    private int userId;
    
    private ReclamationService recService = new ReclamationService();
    private ReponsesService repService = new ReponsesService();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    private void updateNotifNbr() {
        int nbrNotifs = NotifContainer.getChildren().size();
        NotifNbr.setText(Integer.toString(nbrNotifs));
    }
   

    void setNewUserId(int userId) throws SQLException, IOException {
        this.userId = userId;
        System.out.println("NotifPanelUserController msg : " + userId);

        // Set notification counter to 0
        NotifNbr.setText("0");

        // Retrieve reclamations for the user
        List<Reclamation> reclamations = recService.recupererParUtilisateur(userId);

        // Loop through the reclamations and create a notification for each
        for (Reclamation reclamation : reclamations) {
            // Check if any responses were not viewed
            List<Reponses> responses = repService.recupererParRecId(reclamation.getRec_id());
            boolean hasNewResponse = false;
            for (Reponses response : responses) {
                if (!viewedReclamations.contains(response.getRep_id())) {
                    hasNewResponse = true;
                    break;
                }
            }
            if (!hasNewResponse) {
                continue; // Skip this reclamation
            }

            // Create notifications for new responses
            for (Reponses response : responses) {
                if (!viewedReclamations.contains(response.getRep_id())) {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("Notification.fxml"));
                    AnchorPane pane = loader.load();
                    NotificationController controller = loader.getController();
                    controller.setReclamationId(reclamation.getRec_id());
                    controller.setNumReponses(1);
                    NotifContainer.getChildren().add(pane);
                    viewedReclamations.add(response.getRep_id()); // Add response to viewed set
                }
            }
            updateNotifNbr(); // Update notification counter
        }

        // Show alert if there are no new notifications
        if (NotifContainer.getChildren().isEmpty()) {
            NoNewNotif.setVisible(true);
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("pas de nouvelles notifications");
            alert.setHeaderText(null);
            alert.setContentText("Aucune nouvelle notification à afficher");
            alert.showAndWait();
        } else {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Nouvelles notifications");
        alert.setHeaderText(null);
        alert.setContentText("Vous avez de nouvelles réponses sur vos Réclamations !");
        alert.showAndWait();
        }
    }













    @FXML
    private void GoBk(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ChoisirReclamationType.fxml"));
            Parent root = loader.load();

            // Set the root of the current scene to the new FXML file
            GoBackBtn.getScene().setRoot(root);
    }



}
