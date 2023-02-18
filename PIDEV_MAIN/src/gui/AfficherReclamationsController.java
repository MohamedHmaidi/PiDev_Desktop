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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import services.ReclamationService;

public class AfficherReclamationsController implements Initializable {

    @FXML
    private FlowPane flpRec;

    ReclamationService rs = new ReclamationService();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            List<Reclamation> reclamations = rs.recuperer();
            for (Reclamation reclamation : reclamations) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Reclamation.fxml"));
                AnchorPane pane = loader.load();

                ReclamationController controller = loader.getController();
                controller.SetReclamation(reclamation);

                flpRec.getChildren().add(pane);
            }
        } catch (SQLException | IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
