/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package test;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainGraphic extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        
        try {
        // Load the ChoisirReclamation.fxml file
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/ChoisirReclamationType.fxml"));
        Parent root = loader.load();

        // Create a new Scene with the root node
        Scene scene = new Scene(root,800,600);
        
        primaryStage.setResizable(false);

        // Set the title of the stage
        primaryStage.setTitle("Touskieart");

        // Set the scene of the stage
        primaryStage.setScene(scene);

        // Show the stage
        primaryStage.show();
    }
        catch (IOException ex) {
            System.out.println("error" + ex.getMessage());
        }
    }
    

    public static void main(String[] args) {
        launch(args);
    }
}
