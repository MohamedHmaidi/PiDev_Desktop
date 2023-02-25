package services;

import entities.Reclamation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.MyDB;

public class ReclamationService implements RecInterface<Reclamation> {
    
    Connection cnx;
    PreparedStatement pst;
    
    public ReclamationService() {
        cnx = MyDB.getInstance().getCnx();
    }
    
    @Override
    //ajouter reclamation
    public void ajouter(Reclamation r) throws SQLException {
        String query = "INSERT INTO reclamation (user_id, titre_rec, type, description, `date-creation`, status) VALUES (?, ?, ?, ?, ?, ?)";
        pst = cnx.prepareStatement(query);
        pst.setInt(1, r.getUser_id());
        pst.setString(2, r.getTitre_rec());
        pst.setString(3, r.getType());
        pst.setString(4, r.getDescription());
        pst.setDate(5, new java.sql.Date(r.getDate_creation().getTime()));
        pst.setString(6, r.getStatus());
        pst.executeUpdate();
    }

    @Override
    //modifer une reclamation, not used in our context
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
    //changer etat a ferme et inserer currdate dans date_fin reclamation
    public void ModifierEtat(int rec_id) throws SQLException {
    String query = "UPDATE reclamation SET status='Fermé', date_fin=CURDATE() WHERE rec_id=?";
    pst = cnx.prepareStatement(query);
    pst.setInt(1, rec_id);
    pst.executeUpdate();
}



    @Override
    //supprimer reclam standard
    public void supprimer(Reclamation r) throws SQLException {
        String query = "DELETE FROM reclamation WHERE rec_id=?";
        pst = cnx.prepareStatement(query);
        pst.setInt(1, r.getRec_id());
        pst.executeUpdate();
    }
    
    @Override
    //supprimer par id
    public void supprimerParRecId(int rec_id) throws SQLException {
        String query = "DELETE FROM reclamation WHERE rec_id=?";
        pst = cnx.prepareStatement(query);
        pst.setInt(1, rec_id);
        pst.executeUpdate();
}


    @Override
    //Recuperer tous les reclamation , methode ADMIN
    public List<Reclamation> recuperer() throws SQLException {
            List<Reclamation> reclamations = new ArrayList<>();
            String query = "SELECT * FROM reclamation";
            pst = cnx.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
            int rec_id = rs.getInt(1); // 1 represents the first column
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
    

    @Override
        //recuperer les reclamation d'un utilisateur specifique
        public List<Reclamation> recupererParUtilisateur(int userId) throws SQLException {
           List<Reclamation> reclamations = new ArrayList<>();
           String query = "SELECT * FROM reclamation WHERE user_id=?";
           pst = cnx.prepareStatement(query);
           pst.setInt(1, userId);
           ResultSet rs = pst.executeQuery();
           while (rs.next()) {
           int rec_id = rs.getInt(1); // 1 represents the first column
           String titre_rec = rs.getString("titre_rec");
           String type = rs.getString("type");
           String description = rs.getString("description");
           String status = rs.getString("status");
           Reclamation reclamation = new Reclamation(rec_id, userId, titre_rec, type, description, status);
           reclamations.add(reclamation);
            }
            return reclamations;
}
        

    @Override
    //recuperer une reclamation specifique par id reclamation
    public Reclamation recupererParId(int recId) throws SQLException {
            String query = "SELECT * FROM reclamation WHERE rec_id=?";
            pst = cnx.prepareStatement(query);
            pst.setInt(1, recId);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
            int userId = rs.getInt("user_id");
            String titre_rec = rs.getString("titre_rec");
            String type = rs.getString("type");
            String description = rs.getString("description");
            String status = rs.getString("status");
            return new Reclamation(recId, userId, titre_rec, type, description, status);
        } else {
            return null;
    }
            
}
            public List<Reclamation> recupererByStatus(String status) throws SQLException {
                List<Reclamation> reclamations = new ArrayList<>();
                String query = "SELECT * FROM reclamation WHERE status=?";
                pst = cnx.prepareStatement(query);
                pst.setString(1, status);
                ResultSet rs = pst.executeQuery();
                while (rs.next()) {
                    int rec_id = rs.getInt(1); // 1 represents the first column
                    int user_id = rs.getInt("user_id");
                    String titre_rec = rs.getString("titre_rec");
                    String type = rs.getString("type");
                    String description = rs.getString("description");
                    Reclamation reclamation = new Reclamation(rec_id, user_id, titre_rec, type, description, status);
                    reclamations.add(reclamation);
                }
                return reclamations;
            }




}
