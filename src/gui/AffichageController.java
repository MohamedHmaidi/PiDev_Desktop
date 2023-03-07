/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import Entities.Local;
import java.awt.Insets;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import services.LocalService;

/**
 * FXML Controller class
 *
 * @author Administrateur
 */
public class AffichageController implements Initializable {

    @FXML
    private GridPane grid;
LocalService ls=new LocalService();
 List<Local> personnes=new ArrayList();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
    /*    
        try {
            
            try {
                personnes = ls.recuperer();
            } catch (SQLException ex) {
                Logger.getLogger(AffichageController.class.getName()).log(Level.SEVERE, null, ex);
            }
        int column = 0;
        int row = 1;
       
            for (int i = 0; i < personnes.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/views/item.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                LocalController controller = fxmlLoader.getController();
                controller.setData(personnes.get(i));

                if (column == 3) {
                    column = 0;
                    row++;
                }

                grid.add(anchorPane, column++, row); //(child,column,row)
                //set grid width
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);

                //GridPane.setMargin(anchorPane, new Insets(10));
            }
        } 
     catch (IOException e) {
            e.printStackTrace();
        }
        
        
        
        
        // TODO
    }    
    
}
*/