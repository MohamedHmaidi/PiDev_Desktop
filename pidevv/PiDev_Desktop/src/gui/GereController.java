/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import entites.Categorie;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import services.ProduitService;
import entites.produit;
import java.sql.Connection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import services.CategorieService;
import entites.Categorie;
import entites.produit;
import entites.unite;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import services.UniteService;
import utils.MyDB;

/**yu
 * FXML Controller class
 *
 * @author Monta
 */
public class GereController implements Initializable {

    @FXML
    private TextField nompFid;
    @FXML
    private TextField QTFid;
    @FXML
    private TextField QTMFid;
    @FXML
    private TextArea DisFid;
    @FXML
    private TextField PrixFid;
    @FXML
    private ComboBox<Categorie> CatFid;
//    private void addcombox (ActionEvent event) throws SQLException {
//    Connection cnx = MyDB.getInstance().getCnx();
//    String  req = "select * from categorie";
//    Statement ps = cnx.createStatement();
//    ResultSet rs = ps.executeQuery(req);
//    ObservableList data = FXCollections.observableArrayList();
//    while(rs.next()){
//    
//    data.add(rs.getString("libCategorie"));
//    }
//    CatFid.setItems(data);
//    }
    
    
    @FXML
    private ComboBox<unite> UniteFid;
    @FXML
    private Button AjoutFid;
    @FXML
    private Button AfficherFid;
    produit prod =new produit();
    ProduitService ps = new ProduitService();
    CategorieService cs = new CategorieService();
    UniteService un = new UniteService();
    @FXML
    private TextField imageFid;
    @FXML
    private TextField tryIDunite;
    @FXML
    private TextField tryCat;
    @FXML
    private Button Modiferbtn;
    @FXML
    private Button supPrd;
    @FXML
    private TableView<produit> tableProduit;
    @FXML
    private TableColumn<produit, String> nomTV;
    @FXML
    private TableColumn<produit, Integer> QMaxTV;
    @FXML
    private TableColumn<produit, Integer> QMINTV;
    @FXML
    private TableColumn<produit, Float> prixTV;
    @FXML
    private TableColumn<produit, Integer> catTV;
    @FXML
    private TableColumn<produit, Integer> iduntitTV;
    @FXML
    private TableColumn<produit, String> descriptionTV;
    @FXML
    private TableColumn<produit, String> imageTV;
    @FXML
    private TextField idmodifierField;
    @FXML
    private ImageView imageview;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        getEvents();
       
        
         
        try {
            List<Categorie> categories = cs.recupererCat();
                         ObservableList<Categorie> olc = FXCollections.observableArrayList(categories);
                       CatFid.setItems(olc);
                    
                       
            List<unite> unite = un.recupererUnite();
                         ObservableList<unite> olc1 = FXCollections.observableArrayList(unite);
                       UniteFid.setItems(olc1);
        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }  
   
    @FXML
    private void ajouterProduit(ActionEvent event) throws SQLException {
           produit p = new produit();
           
           
               if ((QTFid.getText().length() == 0) || (nompFid.getText().length() == 0) || (QTMFid.getText().length() == 0) || (PrixFid.getText().length() == 0)|| (tryCat.getText().length() == 0)|| (tryIDunite.getText().length() == 0)) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error ");
            alert.setHeaderText("Error!");
            alert.setContentText("Fields cannot be empty");
            alert.showAndWait();
        }
               else {
        p.setQteStock(Integer.parseInt(QTFid.getText()));
        p.setCodeProduit(nompFid.getText());
         p.setQteMin(Integer.parseInt(QTMFid.getText()));
         p.setPrixUnite(Integer.parseInt(PrixFid.getText()));
        p.setIdCat(Integer.parseInt(tryCat.getText()));
         //  p.setIdCat(CatFid.setItems());
        p.setIdUnite(Integer.parseInt(tryIDunite.getText()));     
         p.setDesgination(DisFid.getText());
         p.setImage(imageFid.getText());
         
         p.setImage(imageFid.getText());

            //   addcombox((ActionEvent) CatFid.getItems());
         
          List<Categorie> Categorie  = cs.recupererCat();
             ObservableList<Categorie> 
            olc = FXCollections.observableArrayList(Categorie);
                       CatFid.setItems(olc);
        try {
            ps.ajouter(p);
            getEvents();
        reset();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        }
    }

    @FXML
    private void modifierProduit(ActionEvent event) throws SQLException {
        produit e = new produit();
        e.setId(Integer.valueOf(idmodifierField.getText()));
        e.setCodeProduit(nompFid.getText());
        e.setDesgination(descriptionTV.getText());
        e.setImage(imageFid.getText());
        e.setIdCat(Integer.valueOf(tryCat.getText()));
        e.setPrixUnite(Float.valueOf(PrixFid.getText()));
        //e.setIdUnite(Integer.valueOf(tryIDunite.getText()));
        e.setQteMin(Integer.valueOf(QTMFid.getText()));
        e.setQteStock(Integer.valueOf(QTFid.getText()));            
        ps.modifier(e);
        getEvents();
      
        
    }

    @FXML
    private void supProduit(ActionEvent event) {
        
        
           produit e = tableProduit.getItems().get(tableProduit.getSelectionModel().getSelectedIndex());
      
        try {
            ps.supprimer(e);
        } catch (SQLException ex) {
            Logger.getLogger(GereController.class.getName()).log(Level.SEVERE, null, ex);
        }   
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information ");
        alert.setHeaderText("Event delete");
        alert.setContentText("Event deleted successfully!");
        alert.showAndWait();
        getEvents();
        
    }

    @FXML
    private void afficherProduit(ActionEvent event) {
        
        
          try {
            //navigation
            Parent loader = FXMLLoader.load(getClass().getResource("afficherProduit.fxml"));
            nompFid.getScene().setRoot(loader);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
        
        
    }

    @FXML
    private void choisirProduit(MouseEvent event) {
        produit e = tableProduit.getItems().get(tableProduit.getSelectionModel().getSelectedIndex());
        idmodifierField.setText(String.valueOf(e.getId()));
        //idLabel.setText(String.valueOf(e.getId_event()));
        QTFid.setText(String.valueOf(e.getQteStock()));
        nompFid.setText(e.getCodeProduit());
        QTMFid.setText(String.valueOf(e.getQteMin()));
        PrixFid.setText(String.valueOf(e.getPrixUnite()));
        tryCat.setText(String.valueOf(e.getIdCat()));
        DisFid.setText(e.getDesgination());
       //dateEventField.setValue((e.getDate()));
      
                DisFid.setText((e.getDesgination()));
        imageFid.setText((e.getImage()));
        
        String path = e.getImage();
               File file=new File(path);
              Image img = new Image(file.toURI().toString());
                imageview.setImage(img);

 

    }
     
   public void getEvents() {  

         try {
            // TODO
    
            List<produit> evenements = ps.recuperer();
            ObservableList<produit> olp = FXCollections.observableArrayList(evenements);
            tableProduit.setItems(olp);
            nomTV.setCellValueFactory(new PropertyValueFactory("CodeProduit"));
            QMaxTV.setCellValueFactory(new PropertyValueFactory("QteStock"));
            QMINTV.setCellValueFactory(new PropertyValueFactory("QteMin"));
            prixTV.setCellValueFactory(new PropertyValueFactory("PrixUnitaire"));
            catTV.setCellValueFactory(new PropertyValueFactory("idCat"));
            iduntitTV.setCellValueFactory(new PropertyValueFactory("idUnite"));
            descriptionTV.setCellValueFactory(new PropertyValueFactory("Designation"));
                        imageTV.setCellValueFactory(new PropertyValueFactory("image"));
                       // descriptionTV.setCellValueFactory(new PropertyValueFactory("Designation"));

           // this.delete();
        } catch (SQLException ex) {
            System.out.println("error" + ex.getMessage());
        }

    }//get events

    @FXML
    private void uploadImage(ActionEvent event)throws FileNotFoundException, IOException  {
        
        
        
        
               Random rand = new Random();
        int x = rand.nextInt(1000);
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Upload File Path");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));
        File file = fileChooser.showOpenDialog(null);
        String DBPath = "C:\\\\xampp\\\\htdocs\\\\imageP\\\\"  + x + ".jpg";
        if (file != null) {
            FileInputStream Fsource = new FileInputStream(file.getAbsolutePath());
            FileOutputStream Fdestination = new FileOutputStream(DBPath);
            BufferedInputStream bin = new BufferedInputStream(Fsource);
            BufferedOutputStream bou = new BufferedOutputStream(Fdestination);
            System.out.println(file.getAbsoluteFile());
            String path=file.getAbsolutePath();
            Image img = new Image(file.toURI().toString());
            imageview.setImage(img);
           /* File File1 = new File(DBPath);
            Image img = new Image(File1.getAbsolutePath());
            image_event.setImage(img);*/
            imageFid.setText(DBPath);
            int b = 0;
            while (b != -1) {
                b = bin.read();
                bou.write(b);
            }
            bin.close();
            bou.close();
            
        } else {
            System.out.println("error");

        }
    }
        
    
   
private void reset() {
        QTFid.setText("");
        QTMFid.setText("");
        DisFid.setText("");
        nompFid.setText("");
        PrixFid.setText("");
         tryCat.setText("");
    

    }

    @FXML
    private void switchToCategorie(ActionEvent event) {
        
     

        try {
          Parent root = FXMLLoader.load(getClass().getResource("Cat.fxml"));
                    Scene sence = new Scene(root);
                    Stage stage = new Stage();
                    stage.setScene(sence);
                    stage.show();
            
        } catch (IOException ex) {
            System.out.println("error" + ex.getMessage());
        }
        
    }

}
   
    
   

