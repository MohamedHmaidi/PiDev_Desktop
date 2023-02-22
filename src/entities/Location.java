/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package entities;

/**
 *
 * @author Aymen
 */
public class Location {
    private int id_loc, nb_pers_loc;
    private float surface_loc;
    private String type_loc, lieu_loc;

    public Location() {
    }

    public Location(int nb_pers_loc, float surface_loc, String type_loc, String lieu_loc) {
        this.nb_pers_loc = nb_pers_loc;
        this.surface_loc = surface_loc;
        this.type_loc = type_loc;
        this.lieu_loc = lieu_loc;
    }

    public Location(int id_loc, int nb_pers_loc, float surface_loc, String type_loc, String lieu_loc) {
        this.id_loc = id_loc;
        this.nb_pers_loc = nb_pers_loc;
        this.surface_loc = surface_loc;
        this.type_loc = type_loc;
        this.lieu_loc = lieu_loc;
    }

    public int getId_loc() {
        return id_loc;
    }

    public void setId_loc(int id_loc) {
        this.id_loc = id_loc;
    }

    public int getNb_pers_loc() {
        return nb_pers_loc;
    }

    public void setNb_pers_loc(int nb_pers_loc) {
        this.nb_pers_loc = nb_pers_loc;
    }

    public float getSurface_loc() {
        return surface_loc;
    }

    public void setSurface_loc(float surface_loc) {
        this.surface_loc = surface_loc;
    }

    public String getType_loc() {
        return type_loc;
    }

    public void setType_loc(String type_loc) {
        this.type_loc = type_loc;
    }

    public String getLieu_loc() {
        return lieu_loc;
    }

    public void setLieu_loc(String lieu_loc) {
        this.lieu_loc = lieu_loc;
    }

    @Override
    public String toString() {
        return "Location{" + "id_loc=" + id_loc + ", nb_pers_loc=" + nb_pers_loc + ", surface_loc=" + surface_loc + ", type_loc=" + type_loc + ", lieu_loc=" + lieu_loc + '}';
    }
    
    
    
}
