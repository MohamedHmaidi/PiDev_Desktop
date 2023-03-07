package test;
import entities.Commentaire;
import entities.Like;
import entities.mail;
import java.sql.SQLException;
import java.util.Random;
import services.CommentaireService;
import services.LikeService;
import services.UserService;

///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package test;
//
//import entities.Commentaire;
//import entities.User;
//import java.sql.SQLException;
//import services.CommentaireService;
//import services.UserService;
//import utils.MyDB;
//
///**
// *
// * @author Mohamed
// */
public class Test {
//    
//    
  public static void main(String[] args) throws SQLException {
      //          User p = new User(14,58229725,"hmaidi","mohamed","aaaa@gmail.com","aaaa","aaaa","aaaa");
////            User p2 = new User(2,777777788,"hmaidi","mohamed","aaaa@gmail.com","aaaa","aaaa","aaaa");
// UserService ps = new UserService();
Like l=new Like();
l.setId_com(40);
l.setId_user(32);
LikeService ls = new LikeService();
//System.out.println(ls.verif_like(32, 40));
System.out.println(ls.affiche_like(l));
//  System.out.println(cs.recuperer_nom_role(4));
//           ps.supprimer(p);
////            ps.ajouter(p);
////            ps.modifier(p2);
////            ps.supprimer(p2);
////          System.out.println(ps.recuperer(p));
// //         Commentaire c = new Commentaire(1,2,"blablablablabla");
//  //       CommentaireService cs= new CommentaireService();
////          cs.ajouter(c);
////          
////          Commentaire c2 = new Commentaire(1,2,"hhhhhhhhhhhhhhhhhhhhhhh");
////          cs.modifier(c2);
//  //        cs.supprimer(c);
//  //  ps.existemail(p.getEmail());
//
//
   }
//    
//    
}
