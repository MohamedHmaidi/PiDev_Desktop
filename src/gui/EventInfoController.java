/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Customer;
import entities.Event;
import entities.EventReaction;
import entities.Ticket;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import services.EventReactionService;
import services.EventService;
import services.LocationService;
import services.TicketService;
import services.UserService;

/**
 * FXML Controller class
 *
 * @author WHITE SHARK
 */
public class EventInfoController implements Initializable {

    private Text eventIdText;
    
    private Event eventInfoStore;
    
    EventService es = new EventService();
    UserService us = new UserService();
    LocationService locS = new LocationService();
    TicketService ts = new TicketService();
    EventReactionService ers = new EventReactionService();
    
    @FXML
    private Text titleText;
    @FXML
    private Text startDateText;
    @FXML
    private Button deleteBtn;
    @FXML
    private Button updateBtn;
    @FXML
    private Button backBtn;
    @FXML
    private ImageView afficheIv;
    @FXML
    private Text typeText;
    @FXML
    private Text statusText;
    @FXML
    private Text endDateText;
    @FXML
    private Text locationAddressText;
    @FXML
    private Text descText;
    @FXML
    private Text hostNameText;
    @FXML
    private Text ticketCountText;
    @FXML
    private ScrollPane sPane;
    @FXML
    private Button buyBtn;
    @FXML
    private Button payPopBtn;
    @FXML
    private Button likeButton;
    @FXML
    private Button dislikeButton;
    @FXML
    private Button purchaseBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //TODO
    }    

    void sendEvent(Event eventInfo) {
        try {
            eventInfoStore = eventInfo;
            titleText.setText(eventInfo.getTitle());
            typeText.setText(eventInfo.getType());
            statusText.setText(eventInfo.getStatus());
            startDateText.setText(String.valueOf(eventInfo.getStartDate()));
            endDateText.setText(String.valueOf(eventInfo.getEndDate()));
            locationAddressText.setText(locS.getLieu(eventInfo.getLocation_id()));
            hostNameText.setText(us.getNom(eventInfo.getHost_id()));
            ticketCountText.setText(String.valueOf(eventInfo.getTicketCount()));
            descText.setText(eventInfo.getDescription());
            ByteArrayInputStream inputStream = new ByteArrayInputStream(eventInfo.getAffiche());
            Image image = new Image(inputStream);
            afficheIv.setImage(image);
            buyBtn.setText("Get your ticket! "+eventInfo.getTicketPrice()+" dt.");
            likeButton.setText("LIKE: "+ers.reactionCount(eventInfoStore.getEvent_id(), EventReaction.Reaction.like));
            dislikeButton.setText("DISLIKE: "+ers.reactionCount(eventInfoStore.getEvent_id(), EventReaction.Reaction.dislike));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void deleteEvent(ActionEvent event) {
        try {
            es.supprimer(eventInfoStore);
            //Redirect back to event list
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AfficherListeEvent.fxml"));
            Parent root = loader.load();
            MCCSaver.mcc.setContent(root);
        } catch (SQLException | IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void updateEvent(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifierEvent.fxml"));
            Parent root = loader.load();
            MCCSaver.mcc.setContent(root);
            ModifierEventController controller = loader.getController();
            controller.eventReceiver(eventInfoStore);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void goBackToList(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AfficherListeEvent.fxml"));
            Parent root = loader.load();
            MCCSaver.mcc.setContent(root);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void buyTicket(ActionEvent event) {
        try {
            String qrImgName = "";
            
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText("Are you sure you want to proceed?");
            alert.setContentText("Click OK to proceed or Cancel to cancel the action.");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK){
                Ticket t = new Ticket();
                t.setEvent_id(eventInfoStore.getEvent_id());
                t.setPrice(eventInfoStore.getTicketPrice());
                t.setUser_id(LoginController.UserConnected.getId());
                
                //QR Code Generator
                String str = "Ticket number: "+eventInfoStore.getTicketCount()+" | event: "+t.getEvent_id()+" | User: "+t.getUser_id();
                qrImgName = "t"+eventInfoStore.getTicketCount()+"e"+t.getEvent_id()+"u"+t.getUser_id();
                String path = "src/assets/images/"+qrImgName+".png";
                String charset = "UTF-8";
                Map<EncodeHintType, ErrorCorrectionLevel> hashMap = new HashMap<EncodeHintType, ErrorCorrectionLevel>();  
                hashMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
                generateQRcode(str, path, charset, hashMap, 200, 200);
                
                t.setQrCodeImg(path);
                ts.ajouter(t);
                //Update TicketCount
                int newTicketCount = (eventInfoStore.getTicketCount())-1;
                eventInfoStore.setTicketCount(newTicketCount);
                es.modifier(eventInfoStore);
                  
                //Extra: Refresh content pane
                FXMLLoader loader = new FXMLLoader(getClass().getResource("EventInfo.fxml"));
                Parent root = loader.load();
                MCCSaver.mcc.setContent(root);
                EventInfoController controller = loader.getController();
                controller.sendEvent(eventInfoStore);
                
                // Show QR code image
                Alert successAlert = new Alert(AlertType.INFORMATION);
                successAlert.setTitle("Congratulation!");
                successAlert.setHeaderText("Ticket was successfully bought!");
                successAlert.setContentText("Here's your Ticket QR Code, please scan it!");

                // Load the image from the saved file
                File imageFile = new File(t.getQrCodeImg());
                Image image = new Image(imageFile.toURI().toString());

                // Create an ImageView to display the image
                ImageView imageView = new ImageView(image);
                imageView.setFitWidth(200); // Set the width of the image view
                imageView.setFitHeight(200); // Set the height of the image view

                // Set the graphic of the alert to the image view
                successAlert.setGraphic(imageView);
                successAlert.showAndWait();

                
            } else {
                // User clicked Cancel, do not proceed with the action
            }
            
        } catch (SQLException | IOException | WriterException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    //ZXING QR Code Generator API
    public void generateQRcode(String data, String path, String charset, Map map, int h, int w) throws WriterException, IOException  
        {  
            BitMatrix matrix = new MultiFormatWriter().encode(new String(data.getBytes(charset), charset), BarcodeFormat.QR_CODE, w, h);  
            MatrixToImageWriter.writeToFile(matrix, path.substring(path.lastIndexOf('.') + 1), new File(path));  
        }  

    @FXML
    private void handlePopup(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("TicketPayment.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Buy a Ticket!");
            stage.setScene(new Scene(root1));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void likeEventHandler(ActionEvent event) {
        try {
            //Create reaction
            EventReaction er = new EventReaction();
            er.setEvent_id(eventInfoStore.getEvent_id());
            er.setUser_id(LoginController.UserConnected.getId());
            er.setReaction(EventReaction.Reaction.like);
            
            //check if user reacted
            boolean alreadyReacted = ers.alreadyReacted(eventInfoStore.getEvent_id(), LoginController.UserConnected.getId());
            if (alreadyReacted == true) {
                ers.modifier(er);
            } else {
                ers.ajouter(er);
            }
            likeButton.setText("LIKE: "+ers.reactionCount(eventInfoStore.getEvent_id(), EventReaction.Reaction.like));
            dislikeButton.setText("DISLIKE: "+ers.reactionCount(eventInfoStore.getEvent_id(), EventReaction.Reaction.dislike));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void dislikeEventHandler(ActionEvent event) {
        try {
            //Create reaction
            EventReaction er = new EventReaction();
            er.setEvent_id(eventInfoStore.getEvent_id());
            er.setUser_id(LoginController.UserConnected.getId());
            er.setReaction(EventReaction.Reaction.dislike);
            
            //check if user reacted
            boolean alreadyReacted = ers.alreadyReacted(eventInfoStore.getEvent_id(), LoginController.UserConnected.getId());
            if (alreadyReacted == true) {
                ers.modifier(er);
            } else {
                ers.ajouter(er);
            }
            likeButton.setText("LIKE: "+ers.reactionCount(eventInfoStore.getEvent_id(), EventReaction.Reaction.like));
            dislikeButton.setText("DISLIKE: "+ers.reactionCount(eventInfoStore.getEvent_id(), EventReaction.Reaction.dislike));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void purchaseAPIHandler(ActionEvent event) {
        try {
            Stripe.apiKey = "sk_test_51MgtelLLCNeC0hr0mCf88VawiUWkhHUT31HrUOJieGeZXcph8jTHoXYvULZB8micyWQVupMyHx5meCHom3D80TVA00roslqe44";
            System.out.println("API set");
            
            Customer a = Customer.retrieve("cus_NRnHlXgHLRwjAr");
            System.out.println("customer created");
        } catch (StripeException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    
    
}
