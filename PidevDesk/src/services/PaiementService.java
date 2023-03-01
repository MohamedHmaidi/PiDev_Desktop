/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import java.util.regex.Pattern;
import java.util.regex.Pattern;

/**
 *
 * @author ashre
 */
public class PaiementService {

    public boolean processPayment(String cardNumber, String expDate, String cvv) {
        // Effectuer le paiement avec une bibliothèque de paiement tierce, telle que Stripe ou PayPal
        // Vérifier si la transaction a réussi ou a échoué
        return true; // ou false en fonction du résultat de la transaction
    }
    
    private static final String NAME_PATTERN = "^[a-zA-Z ]{2,30}$";
    private static final String CARD_NUMBER_PATTERN = "^\\d{16}$";
    private static final String EXPIRY_PATTERN = "^(0[1-9]|1[0-2])/\\d{2}$";
    private static final String CVC_PATTERN = "^\\d{3}$";

    public boolean validateName(String name) {
        return Pattern.matches(NAME_PATTERN, name);
    }

    public boolean validateCardNumber(String cardNumber) {
        return Pattern.matches(CARD_NUMBER_PATTERN, cardNumber);
    }

    public boolean validateExpiry(String expiry) {
        return Pattern.matches(EXPIRY_PATTERN, expiry);
    }

    public boolean validateCVC(String cvc) {
        return Pattern.matches(CVC_PATTERN, cvc);
    }
}



