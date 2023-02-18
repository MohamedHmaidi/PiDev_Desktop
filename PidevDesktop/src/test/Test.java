/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import entities.Commentaire;
import entities.User;
import java.sql.SQLException;
import services.CommentaireService;
import services.UserService;
import utils.MyDB;

/**
 *
 * @author Mohamed
 */
public class Test {
    
    
    public static void main(String[] args) {
        
        
  try {
          User p = new User(58229725,"hmaidi","mohamed","aaaa@gmail.com","aaaa","aaaa","aaaa");
//            User p2 = new User(2,777777788,"hmaidi","mohamed","aaaa@gmail.com","aaaa","aaaa","aaaa");
           UserService ps = new UserService();
//            ps.ajouter(p);
//            ps.modifier(p2);
//            ps.supprimer(p2);
//          System.out.println(ps.recuperer(p));
 //         Commentaire c = new Commentaire(1,2,"blablablablabla");
  //       CommentaireService cs= new CommentaireService();
//          cs.ajouter(c);
//          
//          Commentaire c2 = new Commentaire(1,2,"hhhhhhhhhhhhhhhhhhhhhhh");
//          cs.modifier(c2);
  //        cs.supprimer(c);
    ps.existemail(p.getEmail());
          
          
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    
}
