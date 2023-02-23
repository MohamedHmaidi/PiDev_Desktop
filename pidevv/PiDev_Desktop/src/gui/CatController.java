/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import entites.Categorie;
import entites.produit;
import entites.unite;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import services.CategorieService;
import services.UniteService;

/**
 * FXML Controller class
 *
 * @author Monta
 */
public class CatController implements Initializable {

    @FXML
    private TextField NomCatFid;
    @FXML
    private TextField UniteCatFid;
    private TableView<Categorie > tab_cat_unite;
    @FXML
    private Button ajouter_cat_unite;
    @FXML
    private Button suprimerr_cat_unite;
    @FXML
    private Button modifier_cat_unite;
    CategorieService ps = new CategorieService();
    UniteService un = new UniteService();
    @FXML
    private TableView<?> tableunite;
    @FXML
    private TableColumn<Categorie, String> CatColun;
    private TableColumn<unite, String> unitecoll;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void AjouterCat(ActionEvent event) {
         Categorie p = new Categorie();
         unite u = new unite();
         
         p.setLibCat(NomCatFid.getText());
        u.setLibUntie(UniteCatFid.getText());
        
        try {
            ps.ajouterCat(p);
            un.ajouter(u);
         //   getEvents();
       // reset();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void SupprimerCat(ActionEvent event) {
    }

    @FXML
    private void ModiferCat(ActionEvent event) {
    }

    @FXML
    private void select_all(MouseEvent event) {
    }
       public void getEvents() {  

         try {
            // TODO
    
            List<Categorie> evenements = ps.recupererCat();
            ObservableList<Categorie> olp = FXCollections.observableArrayList(evenements);
          //  tableunite.setItems(olp);
            CatColun.setCellValueFactory(new PropertyValueFactory("libcategorie"));
            unitecoll.setCellValueFactory(new PropertyValueFactory("libUnite"));
           
                      

           // this.delete();
        } catch (SQLException ex) {
            System.out.println("error" + ex.getMessage());
        }

    }//
    
}
