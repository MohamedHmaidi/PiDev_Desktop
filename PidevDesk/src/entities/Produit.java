/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author ashre
 */
public class Produit {
        private int id;
        private String CodeProduit;
        private String Designation;
        private int QteStock;
        private int QteMin;
        private int PrixUnitaire;
        private int idUnite;
        private String image;
        private int idcat ;

    @Override
    public String toString() {
        return "Produit{" + "id=" + id + ", CodeProduit=" + CodeProduit + ", Designation=" + Designation + ", QteStock=" + QteStock + ", QteMin=" + QteMin + ", PrixUnitaire=" + PrixUnitaire + ", idUnite=" + idUnite + ", image=" + image + ", idcat=" + idcat + '}';
    }

    public Produit( int id, String CodeProduit, String Designation, int QteStock, int QteMin, int PrixUnitaire, int idUnite, String image, int idcat) {
        this.id = id;
        this.CodeProduit = CodeProduit;
        this.Designation = Designation;
        this.QteStock = QteStock;
        this.QteMin = QteMin;
        this.PrixUnitaire = PrixUnitaire;
        this.idUnite = idUnite;
        this.image = image;
        this.idcat = idcat;
    }

    public Produit() {
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodeProduit() {
        return CodeProduit;
    }

    public void setCodeProduit(String CodeProduit) {
        this.CodeProduit = CodeProduit;
    }

    public String getDesignation() {
        return Designation;
    }

    public void setDesignation(String Designation) {
        this.Designation = Designation;
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

    public int getPrixUnitaire() {
        return PrixUnitaire;
    }

    public void setPrixUnitaire(int PrixUnitaire) {
        this.PrixUnitaire = PrixUnitaire;
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

    public int getIdcat() {
        return idcat;
    }

    public void setIdcat(int idcat) {
        this.idcat = idcat;
    }

    public void add(Produit produit) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
       
}
