/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import java.net.URL;

import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author ashre
 */
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import services.PaiementService;


public class PaiementController {


    private PaiementService paiementService;




    
    @FXML
    private TextField nomTitulaireCarte;
    @FXML
    private TextField numeroCarteCredit;
    @FXML
    private TextField dateExpirationCarte;
    @FXML
    private TextField codeSecuriteCarte;
    @FXML
    private Button validerPaiement;

//    @FXML
//    private void processPayment() {
//        String name = nameField.getText();
//        String cardNumber = cardNumberField.getText();
//        String expiry = expiryField.getText();
//        String cvc = cvcField.getText();
//
//        if (!paiementService.validateName(name)) {
//            showAlert("Nom invalide", "Le nom doit contenir uniquement des lettres et des espaces, avoir une longueur entre 2 et 30 caractères.");
//        } else if (!paiementService.validateCardNumber(cardNumber)) {
//            showAlert("Numéro de carte invalide", "Le numéro de carte doit contenir exactement 16 chiffres.");
//        } else if (!paiementService.validateExpiry(expiry)) {
//            showAlert("Date d'expiration invalide", "La date d'expiration doit être sous la forme MM/YY.");
//        } else if (!paiementService.validateCVC(cvc)) {
//            showAlert("Code CVC invalide", "Le code CVC doit contenir exactement 3 chiffres.");
//        } else {
//            // Effectuer le paiement
//        }
//    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    
    
public void handleValiderPaiement(ActionEvent event) {
    String nom = nomTitulaireCarte.getText();
    String numeroCarte = numeroCarteCredit.getText();
    String dateExpiration = dateExpirationCarte.getText();
    String cvv = codeSecuriteCarte.getText();
//    double montant = Double.parseDouble(montantField.getText());

    PaiementService service = new PaiementService();
    boolean valid = true;
    String errorMessage = "";
    if (!service.validateName(nom)) {
        valid = false;
        errorMessage += "Nom invalide.\n";
    }
    if (!service.validateCardNumber(numeroCarte)) {
        valid = false;
        errorMessage += "Numéro de carte invalide.\n";
    }
    if (!service.validateExpiry(dateExpiration)) {
        valid = false;
        errorMessage += "Date d'expiration invalide.\n";
    }
    if (!service.validateCVC(cvv)) {
        valid = false;
        errorMessage += "CVV invalide.\n";
    }
//    if (montant <= 0) {
//        valid = false;
//        errorMessage += "Montant invalide.\n";
//    }

    if (valid) {
        boolean success = service.processPayment(numeroCarte, dateExpiration, cvv);
        if (success) {
            // afficher un message de réussite
            System.out.println("Paiement effectué avec succès!");
        } else {
            // afficher un message d'erreur
            System.out.println("Le paiement a échoué.");
        }
    } else {
        // afficher un message d'erreur détaillant les champs invalides
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur de paiement");
        alert.setHeaderText("Veuillez corriger les erreurs suivantes :");
        alert.setContentText(errorMessage);
        alert.showAndWait();
    }
}


    
}


