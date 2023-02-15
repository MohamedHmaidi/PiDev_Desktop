package services;

import entities.Reclamation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.MyDB;

public class ReclamationService implements IService<Reclamation> {
    
    Connection cnx;
    PreparedStatement pst;
    
    public ReclamationService() {
        cnx = MyDB.getInstance().getCnx();
    }
    
    @Override
    public void ajouter(Reclamation r) throws SQLException {
        String query = "INSERT INTO reclamation (rec_id, user_id, titre_rec, type, description, `date-creation`, status) VALUES (?, ?, ?, ?, ?, ?, ?)";
        pst = cnx.prepareStatement(query);
        pst.setInt(1, r.getRec_id());
        pst.setInt(2, r.getUser_id());
        pst.setString(3, r.getTitre_rec());
        pst.setString(4, r.getType());
        pst.setString(5, r.getDescription());
        pst.setDate(6, new java.sql.Date(r.getDate_creation().getTime()));
        pst.setString(7, r.getStatus());
        pst.executeUpdate();
    }

    @Override
    public void modifier(Reclamation r) throws SQLException {
        String query = "UPDATE reclamation SET user_id=?, titre_rec=?, type=?, description=?, `date-creation`=?, status=? WHERE rec_id=?";
        pst = cnx.prepareStatement(query);
        pst.setInt(1, r.getUser_id());
        pst.setString(2, r.getTitre_rec());
        pst.setString(3, r.getType());
        pst.setString(4, r.getDescription());
        pst.setDate(5, new java.sql.Date(r.getDate_creation().getTime()));
        pst.setString(6, r.getStatus());
        pst.setInt(7, r.getRec_id());
        pst.executeUpdate();
    }

    @Override
    public void supprimer(Reclamation r) throws SQLException {
        String query = "DELETE FROM reclamation WHERE rec_id=?";
        pst = cnx.prepareStatement(query);
        pst.setInt(1, r.getRec_id());
        pst.executeUpdate();
    }

    @Override
    public List<Reclamation> recuperer(Reclamation r) throws SQLException {
        List<Reclamation> reclamations = new ArrayList<>();
        String query = "SELECT * FROM reclamation";
        pst = cnx.prepareStatement(query);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            int rec_id = rs.getInt("rec_id");
            int user_id = rs.getInt("user_id");
            String titre_rec = rs.getString("titre_rec");
            String type = rs.getString("type");
            String description = rs.getString("description");
            String status = rs.getString("status");
            Reclamation reclamation = new Reclamation(rec_id, user_id, titre_rec, type, description, status);
            reclamations.add(reclamation);
        }
        return reclamations;
    }
}