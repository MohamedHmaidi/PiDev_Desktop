package test;

import entities.Reclamation;
import java.sql.SQLException;
import java.util.List;
import services.ReclamationService;

public class Test {
    
    public static void main(String[] args) {
        ReclamationService rs = new ReclamationService();
        
        try {
            // create a new reclamation
            Reclamation r = new Reclamation(12, 10, "Probleme de paiment","Paiment","Probleme paiment quand je...", "Open");
            rs.ajouter(r);
            System.out.println("Reclamation ajoutée");
            
            // retrieve all the reclamations
            List<Reclamation> reclamations = rs.recuperer(new Reclamation());
            System.out.println("Liste des reclamations");
            for (Reclamation recl : reclamations) {
                System.out.println(recl.toString());
            }
            
            // update the status of a reclamation
            Reclamation rToUpdate = new Reclamation(12, 10, "Probleme de paiment","Paiment","Probleme paiment quand je...", "Closed");
            rs.modifier(rToUpdate);
            System.out.println("Reclamation mis a jour");
            

            
            
            // delete a reclamation
            rs.supprimer(rToUpdate);
            System.out.println("Reclamation supprimée");
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    
}
