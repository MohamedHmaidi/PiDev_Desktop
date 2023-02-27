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
import java.util.Map;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.animation.ScaleTransition;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
import services.ReclamationService;

/**
 * FXML Controller class
 *
 * @author Theto
 */
public class StatisticsAdminController implements Initializable {

    @FXML
    private ImageView GoBackBtn;
    @FXML
    private PieChart StatsChart;
    
    ReclamationService rs = new ReclamationService();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        displayStatistics();
    }    
    


    public void displayStatistics() {
    try {
        // Récupérer toutes les réclamations de la base de données
        List<Reclamation> reclamations = rs.recuperer();

        // Regrouper les réclamations par type
        Map<String, Long> reclamationsParType = reclamations.stream()
            .collect(Collectors.groupingBy(Reclamation::getType, Collectors.counting()));

        // conversion reclamationsParType map a une list de objects PieChart.Data
        List<PieChart.Data> pieChartData = reclamationsParType.entrySet().stream()
            .map(entry -> new PieChart.Data(entry.getKey(), entry.getValue()))
            .collect(Collectors.toList());

        // Définissez les éléments de données dans le PieChart
        StatsChart.setData(FXCollections.observableArrayList(pieChartData));

        // Configurer l'animation pour les données piechart
        StatsChart.getData().forEach(data ->
            data.getNode().addEventHandler(MouseEvent.MOUSE_ENTERED, event -> {
                ScaleTransition st = new ScaleTransition(Duration.millis(200), data.getNode());
                st.setToX(1.1);
                st.setToY(1.1);
                st.play();
            })
        );

        StatsChart.getData().forEach(data ->
            data.getNode().addEventHandler(MouseEvent.MOUSE_EXITED, event -> {
                ScaleTransition st = new ScaleTransition(Duration.millis(200), data.getNode());
                st.setToX(1.0);
                st.setToY(1.0);
                st.play();
            })
        );

        // Configurer l'interactivité pour les données piechart
        StatsChart.getData().forEach(data ->
            data.getNode().addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
                // Obtenir la valeur actuelle de l'élément data
                long currentValue = (long) data.getPieValue();

                // Afficher un message avec la valeur de data
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Statistique Reclamation(s)");
                alert.setHeaderText(data.getName());
                alert.setContentText("Nombre de réclamations : " + currentValue);
                alert.showAndWait();
            })
        );

    } catch (SQLException ex) {
        ex.printStackTrace();
    }
}




    @FXML
    private void GoBk(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminRecPanel.fxml"));
            Parent root = loader.load();

            // Set the root of the current scene to the new FXML file
            GoBackBtn.getScene().setRoot(root);
    }
    
}
