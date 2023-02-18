/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import entities.Reclamation;
import entities.Reponses;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.MyDB;
/**
 *
 * @author Theto
 */
public class ReponsesService implements IRService<Reponses>{
    
    Connection cnx;
    PreparedStatement pst;
    
    public ReponsesService() {
        cnx = MyDB.getInstance().getCnx();
    }

    @Override
    public void ajouter(Reponses rep) throws SQLException {
        
          String query = "INSERT INTO reponses (rep_id, rec_id, user_id, rep_description, `date_rep`) VALUES (?, ?, ?, ?, ?)";
        pst = cnx.prepareStatement(query);
        pst.setInt(1, rep.getRep_id());
        pst.setInt(2, rep.getRec_id());
        pst.setInt(3, rep.getUser_id());
        pst.setString(4, rep.getRep_desc());
        pst.setDate(5, new java.sql.Date(rep.getDate_rep().getTime()));
        pst.executeUpdate();
        
    }
    
    
    @Override
    public List<Reponses> recuperer(Reponses t) throws SQLException {
        List<Reponses> reponsesList = new ArrayList<>();
        String query = "SELECT rep_description, date_rep FROM reponses WHERE user_id = ?";
        pst = cnx.prepareStatement(query);
        pst.setInt(1, t.getUser_id());
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            Reponses rep = new Reponses();
            rep.setRep_desc(rs.getString("rep_description"));
            rep.setDate_rep(rs.getDate("date_rep"));
            reponsesList.add(rep);
        }
        return reponsesList;
}



    
}
