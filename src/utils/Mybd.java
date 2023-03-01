/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Administrateur
 */
public class Mybd {
     //connection a la base
    //url usr mdp 
    
   private  String url= "jdbc:mysql://localhost:3306/touskieart";
    private String usr="root";
     private String mdp="";

    
    //variable de type connection 
    Connection cnx;
    private static Mybd instance;
    private Mybd() {
        try{
        
        cnx= DriverManager.getConnection(url,usr,mdp);
        System.out.println("connxion etablie");}
       
        catch (SQLException EX)
        {System.out.println(EX.getMessage());}
                
}

    public static Mybd getInstance() {
        if(instance==null){instance= new Mybd(); }
        return instance;
        
    }

    public static class getInstance extends Mybd {

        public getInstance() {
        }
    }
    
    
    public Connection getcnx() {
        return cnx;
    }

   
    
}
