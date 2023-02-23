/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.util.Date;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
/**
 *
 * @author ashre
 */
public class Panier {
    private int panier_id ; 
    private int produit_id ; 
    private int quantite ; 
    private String date ; 
    private int panier_ref;

    public Panier(int panier_id, int produit_id, int quantite, String date, int panier_ref) {
        this.panier_id = panier_id;
        this.produit_id = produit_id;
        this.quantite = quantite;
        this.date = date;
        this.panier_ref = panier_ref;
    }

    public int getPanier_ref() {
        return panier_ref;
    }

    public void setPanier_ref(int panier_ref) {
        this.panier_ref = panier_ref;
    }

    public Panier() {
    }

    public Panier(int quantite) {
        this.quantite = quantite;
    }
    
    public Panier(int panier_id, int produit_id) {
        this.panier_id = panier_id;
        this.produit_id = produit_id;
    }

    public Panier(int panier_id, int produit_id, int quantite) {
        this.panier_id = panier_id;
        this.produit_id = produit_id;
        this.quantite = quantite;
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        this.date = now.format(formatter);
    }

    public Panier(int panierId, int produitId, int quantite, String Date) {
       
    }

    public int getPanier_id() {
        return panier_id;
    }

    public void setPanier_id(int panier_id) {
        this.panier_id = panier_id;
    }

    public int getProduit_id() {
        return produit_id;
    }

    public void setProduit_id(int produit_id) {
        this.produit_id = produit_id;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

  
}
