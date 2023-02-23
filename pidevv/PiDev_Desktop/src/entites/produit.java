/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entites;

import java.util.Objects;

/**
 *
 * @author Monta
 */
public class produit {
    private int id ;
    private String CodeProduit;
    private String Desgination ;

    @Override
    public String toString() {
        return "produit{" + "id=" + id + ", CodeProduit=" + CodeProduit + ", Desgination=" + Desgination + ", QteStock=" + QteStock + ", QteMin=" + QteMin + ", PrixUnite=" + PrixUnite + ", idUnite=" + idUnite + ", image=" + image + ", idCat=" + idCat + '}';
    }
    private  int QteStock ;
    private int QteMin; 
    private float PrixUnite ;
    private int idUnite;
    private String image ; 
    private int idCat;

    public produit() {
    }

    public produit(int id, String CodeProduit, String Desgination, int QteStock, int QteMin, float PrixUnite, int idUnite, String image, int idCat) {
        this.id = id;
        this.CodeProduit = CodeProduit;
        this.Desgination = Desgination;
        this.QteStock = QteStock;
        this.QteMin = QteMin;
        this.PrixUnite = PrixUnite;
        this.idUnite = idUnite;
        this.image = image;
        this.idCat = idCat;
    }
      public produit(int id, String CodeProduit, String Desgination, String image, int QteStock, int QteMin, float PrixUnite, int idUnite, int idCat) {
        this.id = id;
        this.CodeProduit = CodeProduit;
        this.Desgination = Desgination;
        this.QteStock = QteStock;
        this.QteMin = QteMin;
        this.PrixUnite = PrixUnite;
        this.idUnite = idUnite;
        this.image = image;
        this.idCat = idCat;
    }


    public produit(int id) {
        this.id = id;
    }
    
    public produit( String CodeProduit, String Desgination, int QteStock, int QteMin, float PrixUnite, int idUnite, String image, int idCat) {
      
        this.CodeProduit = CodeProduit;
        this.Desgination = Desgination;
        this.QteStock = QteStock;
        this.QteMin = QteMin;
        this.PrixUnite = PrixUnite;
        this.idUnite = idUnite;
        this.image = image;
        this.idCat = idCat;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
//------------------ NEW CONSTRUCTOR ------------------------------------
    public produit(String CodeProduit, String Desgination, int QteStock, int QteMin, float PrixUnite, int idUnite, String image) {
        this.CodeProduit = CodeProduit;
        this.Desgination = Desgination;
        this.QteStock = QteStock;
        this.QteMin = QteMin;
        this.PrixUnite = PrixUnite;
        this.idUnite = idUnite;
        this.image = image;
    }

    public String getCodeProduit() {
        return CodeProduit;
    }

    public void setCodeProduit(String CodeProduit) {
        this.CodeProduit = CodeProduit;
    }

    public String getDesgination() {
        return Desgination;
    }

    public void setDesgination(String Desgination) {
        this.Desgination = Desgination;
    }

    public int getQteStock() {
        return QteStock;
    }

    public void setQteStock(int QteStock) {
        this.QteStock = QteStock;
    }

    public int getQteMin() {
        return QteMin;
    }

    public void setQteMin(int QteMin) {
        this.QteMin = QteMin;
    }

    public float getPrixUnite() {
        return PrixUnite;
    }

    public void setPrixUnite(float PrixUnite) {
        this.PrixUnite = PrixUnite;
    }

    public int getIdUnite() {
        return idUnite;
    }

    public void setIdUnite(int idUnite) {
        this.idUnite = idUnite;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getIdCat() {
        return idCat;
    }

    public void setIdCat(int idCat) {
        this.idCat = idCat;
    }

   
     
    
}
