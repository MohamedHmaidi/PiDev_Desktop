package gui;

import entities.Reponses;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class ReponseController implements Initializable {

    @FXML
    private Label RepOwn;
    @FXML
    private Label Rep;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }


    void setData(Reponses rep) {
       Rep.setText(rep.getRep_desc());
       RepOwn.setText("Utilisateur avec ID " + Integer.toString(rep.getUser_id()) + ": ");

      
    }

}
