/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import entities.User;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import services.UserService;
import utils.MyDB;

/**
 * FXML Controller class
 *
 * @author Mohamed
 */
public class StatUserController implements Initializable {

    @FXML
    private BarChart<String, Integer> bar;
    int compA=0;
    int compS=0;
    UserService us = new UserService();
    @FXML
    private Label userP;
    Connection cnx;
    /**
     * Initializes the controller class.
     */
    @Override
   public void initialize(URL url, ResourceBundle rb) {
    XYChart.Series<String, Integer> artisteSeries = new XYChart.Series<>();
    artisteSeries.setName("Artistes");
    
    XYChart.Series<String, Integer> simpleSeries = new XYChart.Series<>();
    simpleSeries.setName("Utilisateurs simple");
    
    try {
        List<User> users = us.recuperer();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getRole().equals("Artiste")) {
                compA=compA+1;
                artisteSeries.getData().add(new XYChart.Data<>("Artiste", compA));
            } else if (users.get(i).getRole().equals("simple utilisateur")) {
                compS=compS+1;
                simpleSeries.getData().add(new XYChart.Data<>("Utilisateurs simple", compS));
            }
        }
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
    
    bar.getData().addAll(artisteSeries, simpleSeries);
    
    
    
    try {
    Statement stmt = cnx.createStatement();
    String query = "SELECT u.nom, COUNT(*) AS ticket_count " +
                   "FROM ticket t " +
                   "JOIN user u ON t.user_id = u.id_user " +
                   "GROUP BY u.id_user " +
                   "ORDER BY ticket_count DESC " +
                   "LIMIT 1";
    ResultSet rs = stmt.executeQuery(query);
    if (rs.next()) {
        String username = rs.getString("nom");
        int ticketCount = rs.getInt("ticket_count");
        //System.out.println(username + " a " + ticketCount + " tickets");
        userP.setText(username +" avec "+ Integer.toString(ticketCount)+" tickets ");
        
    }
} catch (SQLException ex) {
    System.out.println(ex.getMessage());
}





    
    
    
    
    
}
        
        public StatUserController() {
        cnx = MyDB.getInstance().getCnx();
    }    
        
    }    
    

