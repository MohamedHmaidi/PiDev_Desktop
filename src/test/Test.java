/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import Entities.CategorieLocal;
import Entities.Local;
import Entities.Mail;
import java.sql.SQLException;
import services.CategorieLocalService;
import services.LocalService;
import utils.Mybd;

/**
 *
 * @author Administrateur
 */
public class Test {

    Mybd db = new Mybd.getInstance();

    public static void main(String[] args) throws SQLException {
        Mybd db = new Mybd.getInstance();
        Mail m=new Mail();
        m.send("saws55457@gmail.com","helooo","xxxx","saws55457@gmail.com","dptkvofegptwzirs");

     //   System.out.println("db");*/

        //2conx pour meme base 
        //connecter une seule fois a la base  ---une seule instance db 
        
        
       /* try{
           Local l =new Local(888881,"aa","eee",52.1f,15,999);
            LocalService loc = new LocalService();
           loc.ajouter(l);
            loc.recuperer();
           /// loc.modifier(l);
      // loc.supprimer(l);
       
       
      CategorieLocal c=new CategorieLocal(9999,"ttt");
       
      // CategorieLocalService locc = new CategorieLocalService();
    //locc.ajouter(c);
       //locc.recuperer();
         // locc.supprimer(c);
          
            //  System.out.println(loc.recuperer(l));
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
      
 
        
    }*/
}
}