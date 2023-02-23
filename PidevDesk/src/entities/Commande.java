/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.util.Date;
/**
 *
 * @author ashre
 */
public class Commande {

    
    	private int commande_id ; 
        private int user_id ; 
        private String date_commande ;
        private double prix ; 
        private int produit_id ;
        private  String rue;
        private  String ville;
        private  String adresse;
        private  String code_postal;
        private  String tel;
        private String nom ; 
        private String prenom ; 
        private int quantite;

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Commande() {
    }

    public Commande( String rue, String ville, String adresse) {        
        this.rue = rue;
        this.ville = ville;
        this.adresse = adresse;
        
   
  
}

    public Commande(int commande_id, int user_id, String date_commande, double prix, int produit_id, String rue, String ville, String adresse, String code_postal, String tel) {
        this.commande_id = commande_id;
        this.user_id = user_id;
        this.date_commande = date_commande;
        this.prix = prix;
        this.produit_id = produit_id;
        this.rue = rue;
        this.ville = ville;
        this.adresse = adresse;
        this.code_postal = code_postal;
        this.tel = tel;
        this.quantite=quantite;
    }

    public int getCommande_id() {
        return commande_id;
    }

    public void setCommande_id(int commande_id) {
        this.commande_id = commande_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getDate_commande() {
        return date_commande;
    }

    public void setDate_commande(String date_commande) {
        this.date_commande = date_commande;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getProduit_id() {
        return produit_id;
    }

    public void setProduit_id(int produit_id) {
        this.produit_id = produit_id;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCode_postal() {
        return code_postal;
    }

    public void setCode_postal(String code_postal) {
        this.code_postal = code_postal;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
