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
 * @author Administrateur
 */
public class NewFXMain extends Application {
    
    @Override
    public void start(Stage primaryStage) {
         ////appel interface graphique
    //charger linteface de type parent classe mere de tous conteneurs
   // exxetion car on peut appeler fichier inexistant donc try catch */
   /* try parent root 
            scene scene =new Scene(root);//interface actuel
       
        */
   try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/interfaceU.fxml"));//appel interface graphique
            Parent root = loader.load(); //charger linteface de type parent classe mere de tous conteneurs
            Scene sc = new Scene(root,870,730);//interface actuel
        // sc.getStylesheets().add(getClass().getResource("../gui/interfusr.css").toExternalForm());
        
            primaryStage.setTitle("Dashbord");//nommer stage
            primaryStage.setScene(sc);//
            primaryStage.show();//afficher
        }
       catch (IOException ex) {
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
