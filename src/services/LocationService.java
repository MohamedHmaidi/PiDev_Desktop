/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package services;

import entities.Event;
import entities.Location;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utils.MyDB;

/**
 *
 * @author Aymen
 */
public class LocationService {
    Connection cnx;

    public LocationService() {
        cnx = MyDB.getInstance().getCnx();
    }
    
    public List<Location> recuperer() throws SQLException {
        List<Location> locations = new ArrayList<>();
        String s = "select * from location";
        Statement st = cnx.createStatement();
        ResultSet rs =  st.executeQuery(s);
        while(rs.next()){
            Location e = new Location();
            e.setId_loc(rs.getInt("id_loc"));
            e.setNb_pers_loc(rs.getInt("nb_pers_loc"));
            e.setSurface_loc(rs.getFloat("surface_loc"));
            e.setLieu_loc(rs.getString("lieu_loc"));
            e.setType_loc(rs.getString("type_loc"));
            locations.add(e);   
        }
        return locations;
    }
    
    public String getLieu(int id) throws SQLException {
      String req = "SELECT lieu_loc FROM location WHERE id_loc = ?";
      PreparedStatement st = cnx.prepareStatement(req);
      st.setInt(1, id);
      ResultSet rs = st.executeQuery();
      String lieu = "";
      if (rs.next()) {
        lieu = rs.getString("lieu_loc");
      }
      return lieu;
    }
}
