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

    //setData depuis AffichReclamOneController, pour passer le user ID lieé au reponse
    void setData(Reponses rep) {
       Rep.setText(rep.getRep_desc());
       RepOwn.setText("Utilisateur avec ID " + Integer.toString(rep.getUser_id()) + ": ");
    }
    
    //setAdminData depuis AfficherReclamOneAdminController TODEBUG
    void setAdminData(Reponses rep, int adminID) {
        if (rep.getAdmin_id()== adminID) {
            RepOwn.setText("Admin avec ID " + Integer.toString(adminID) + ": ");
        } else {
            RepOwn.setText("Utilisateur avec ID " + Integer.toString(rep.getUser_id()) + ": ");
        }
    }

}
