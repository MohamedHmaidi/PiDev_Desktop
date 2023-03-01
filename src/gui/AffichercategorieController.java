/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import Entities.CategorieLocal;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import services.CategorieLocalService;

/**
 * FXML Controller class
 *
 * @author Administrateur
 */
public class AffichercategorieController implements Initializable {

    @FXML
    private AnchorPane pan;
    @FXML
    private VBox vb;
    
     CategorieLocalService ls = new CategorieLocalService();
CategorieLocalService cs =new CategorieLocalService();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
         try {
            // TODO

            /*   
            String req="SELECT * FROM categorie_loc";
            Statement stmt = cnx.createStatement();
            ResultSet rs = stmt.executeQuery(req);
            
            // Parcourir les résultats de la requête et ajouter les données à la VBox
            while (rs.next()) {
                String code = rs.getString("codeC_loc");
                String libelle = rs.getString("libelleC_loc");
             */
            List<CategorieLocal> personnes = ls.recuperer();

            for (int i = 0; i < personnes.size(); i++) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Categorie.fxml"));
                AnchorPane pane=loader.load();

                

                //passage de parametres
                CategorieController controller = loader.getController();
                controller.setData(personnes.get(i));

                vb.getChildren().add(pane);

                
            
                
                
                
               // Button btnSupprimer = new Button("Supprimer");
                // vb.getChildren().add(btnSupprimer);
    controller.no.setOnAction(event -> {
        // Récupération de l'élément à supprimer
        VBox parent = (VBox) controller.no.getParent().getParent();
        int index = parent.getChildren().indexOf(controller.no.getParent());
        CategorieLocal categorie = personnes.get(index);

                 
                    try {
                        // Suppression de l'élément de la base de données
                        if ( cs.supprimer(categorie))
                            parent.getChildren().remove(index);
                        
                        
                        // Suppression de l'élément de la VBox
                    } catch (SQLException ex) {
                        Logger.getLogger(AffichercategorieController.class.getName()).log(Level.SEVERE, null, ex);
                    }
     
    });
                
                
                
                
                
                
                
             /*   Label premierLabel = (Label) vb.getChildren().get(0);
String valeurPremierLabel = premierLabel.
                
            Button b = new Button("delete");
                vb.getChildren().add(b);
                     b.setOnAction((event) -> {
                            try {
                           
                              
                    if (cs.supprimer(valeurPremierLabel)){
                                    
                                    vb.getChildren().remove();
                                    
                                    //locTv.getItems().remove(getIndex());
                                   vb.getChildren();

                                }
                            }
                             catch (SQLException ex) {
                                System.out.println("erreor:" + ex.getMessage());

                            }

                        });
                
                
                
                     
                
                
                
                */
                
                
                
                
            }

        } catch (SQLException ex) {
            Logger.getLogger(AffichercategorieController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AffichercategorieController.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        // TODO
    }    

    @FXML
    private void retour(MouseEvent event) {
        
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("gerercategories.fxml"));
            Parent root = loader.load();
       
            pan.getScene().setRoot(root);
           

        } catch (IOException ex) {
            System.out.println("error" + ex.getMessage());
        }
        
        
        
        
    }
    
}
