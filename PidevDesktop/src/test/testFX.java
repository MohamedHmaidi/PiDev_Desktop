/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package test;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Mohamed
 */
public class testFX extends Application {
    
    @Override
    public void start(Stage primaryStage) {
      
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/Login.fxml"));
            Parent root = loader.load();
            Scene sc = new Scene(root);
            
            primaryStage.setTitle("Login");
            primaryStage.setScene(sc);
            primaryStage.sizeToScene();
            primaryStage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }
        
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
