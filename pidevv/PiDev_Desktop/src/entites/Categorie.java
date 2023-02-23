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
public class Categorie {
    private int id ;
    private String libCat;

    public Categorie(int id, String libCat) {
        this.id = id;
        this.libCat = libCat;
    }

    public Categorie() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibCat() {
        return libCat;
    }

    public void setLibCat(String libCat) {
        this.libCat = libCat;
    }

    @Override
    public String toString() {
        return libCat ;
    }
    
}
