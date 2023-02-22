/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package services;

import entities.Event;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.MyDB;

/**
 *
 * @author Aymen
 */
public class EventService implements IService<Event>{
    Connection cnx;

    public EventService() {
        cnx = MyDB.getInstance().getCnx();
    }

    @Override
    public void ajouter(Event t) throws SQLException {
        String req = "INSERT INTO event(title,type,description,startDate,endDate,ticketCount,host_id,location_id,affiche,ticketPrice) VALUES (?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setString(1, t.getTitle());
        ps.setString(2, t.getType());
        ps.setString(3, t.getDescription());
        ps.setDate(4, t.getStartDate());
        ps.setDate(5, t.getEndDate());
        ps.setInt(6, t.getTicketCount());
        ps.setInt(7, t.getHost_id());
        ps.setInt(8, t.getLocation_id());
        ps.setBinaryStream(9, new ByteArrayInputStream(t.getAffiche()), (t.getAffiche()).length);
        ps.setFloat(10, t.getTicketPrice());
        ps.executeUpdate();
    }

    @Override
    public void modifier(Event t) throws SQLException {
        String req = "UPDATE event SET title = ?, type = ?, description = ?, startDate = ?, endDate = ?, ticketCount = ?, location_id = ?, affiche = ?, status = ?, ticketPrice = ? WHERE event_id = ?";
        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setString(1, t.getTitle());
        ps.setString(2, t.getType());
        ps.setString(3, t.getDescription());
        ps.setDate(4, t.getStartDate());
        ps.setDate(5, t.getEndDate());
        ps.setInt(6, t.getTicketCount());
        ps.setInt(7, t.getLocation_id());
        ps.setBinaryStream(8, new ByteArrayInputStream(t.getAffiche()), (t.getAffiche()).length);
        ps.setString(9, t.getStatus());
        ps.setFloat(10, t.getTicketPrice());
        ps.setInt(11, t.getEvent_id());
        ps.executeUpdate();
    }

    @Override
    public void supprimer(Event t) throws SQLException {
        String req = "DELETE FROM event WHERE event_id = ?";
        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setInt(1, t.getEvent_id());
        ps.executeUpdate();
    }

    @Override
    public List<Event> recuperer() throws SQLException {
        List<Event> events = new ArrayList<>();
        String s = "select * from event";
        Statement st = cnx.createStatement();
        ResultSet rs =  st.executeQuery(s);
        while(rs.next()){
            Event e = new Event();
            e.setEvent_id(rs.getInt("event_id"));
            e.setTitle(rs.getString("title"));
            e.setType(rs.getString("type"));
            e.setDescription(rs.getString("description"));
            e.setStartDate(rs.getDate("startDate"));
            e.setEndDate(rs.getDate("endDate"));
            e.setStatus(rs.getString("status"));
            e.setTicketCount(rs.getInt("ticketCount"));
            e.setHost_id(rs.getInt("host_id"));
            e.setLocation_id(rs.getInt("location_id"));
            e.setTicketPrice(rs.getFloat("ticketPrice"));
            
            //BLOB to byte[] array
            byte[] afficheBytes = rs.getBlob("affiche").getBytes(1l, (int)rs.getBlob("affiche").length());
            e.setAffiche(afficheBytes);
            
            events.add(e);
            
        }
        return events;
    }

}
