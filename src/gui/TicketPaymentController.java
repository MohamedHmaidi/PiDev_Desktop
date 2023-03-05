/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;


//import com.google.gson.Gson;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.model.Customer;
import com.stripe.model.Token;
import com.stripe.param.ChargeCreateParams;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author WHITE SHARK
 */
public class TicketPaymentController implements Initializable {

    @FXML
    private TextField cardNumberField;
    @FXML
    private TextField cvvField;
    @FXML
    private Button PurchaseBtn;
    @FXML
    private Label statusLabel;
    @FXML
    private TextField exprMonthField;
    @FXML
    private TextField exprYearField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Stripe.apiKey = "sk_test_51MgtelLLCNeC0hr0mCf88VawiUWkhHUT31HrUOJieGeZXcph8jTHoXYvULZB8micyWQVupMyHx5meCHom3D80TVA00roslqe44";
    }    
    
    
    @FXML
    private void handlePayment(ActionEvent event) {
        
        String cardNumber = cardNumberField.getText();
        String expMonth = exprMonthField.getText();
        String expYear = exprYearField.getText();
        String cvv = cvvField.getText();
            
        if (cardNumber.isEmpty() || expMonth.isEmpty() || expYear.isEmpty() || cvv.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Please fill in all fields.");
            alert.showAndWait();
            return;
        }
        
        // create a Stripe Charge object with the card info and total price
        Map<String, Object> chargeParams = new HashMap<>();
        chargeParams.put("amount", (int) (15 * 100)); // convert to cents
        chargeParams.put("currency", "usd");
        chargeParams.put("description", "Food purchase");
        System.out.println("Creating card token");
        chargeParams.put("source", createCardToken(cardNumber, expMonth, expYear, cvv));
        System.out.println("Charge about to be created");
        Charge charge;
        System.out.println("Charge Created");
        try {
            System.out.println("Testing Charge");
            charge = Charge.create(chargeParams);
        } catch (StripeException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Error processing payment.");
            alert.showAndWait();
            return;
        }

        // show confirmation message
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Payment successful! Charge ID: " + charge.getId());
        alert.showAndWait();
        
    }
    
    private String createCardToken(String cardNumber, String expMonth, String expYear, String cvv) {
        Map<String, Object> cardParams = new HashMap<>();
        cardParams.put("number", cardNumber);
        cardParams.put("exp_month", expMonth);
        cardParams.put("exp_year", expYear);
        cardParams.put("cvc", cvv);

        try {
            Map<String, Object> tokenParams = new HashMap<>();
            tokenParams.put("card", cardParams);
            System.out.println("Using the Token feature");
            return Token.create(tokenParams).getId();
        } catch (StripeException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Error creating card token.");
            alert.showAndWait();
            return null;
        }
    }
    
}
