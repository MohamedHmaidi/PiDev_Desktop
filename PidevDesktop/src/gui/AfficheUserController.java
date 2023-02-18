/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import entities.User;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import services.UserService;

/**
 * FXML Controller class
 *
 * @author Mohamed
 */
public class AfficheUserController implements Initializable {

    @FXML
    private GridPane grid;
    UserService us = new UserService();
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        try {
        
        List<User> users = us.recuperer();
        int row = 0;
        int column = 0;
        
        
        for (int i = 0; i < users.size(); i++){
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("user.fxml"));
                AnchorPane pane = loader.load();
        UserController controller = loader.getController();
        controller.setUser(users.get(i));
        
        
         grid.add(pane, column, row);
                column++;
                if (column > 2) {
                    column = 0;
                    row++;
        }
        
        }
        
        }
        
        catch (SQLException | IOException ex) {
            System.out.println(ex.getMessage());
        }
        
        
        // TODO
    }    
    
}
