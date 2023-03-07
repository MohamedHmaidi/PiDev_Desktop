/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;



/**
 *
 * @author Administrateur
 */

    
    
   
import java.util.Properties;
import javafx.scene.control.Alert;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
public class Mail {
    
     public static void send(String to, String sub,String msg, final String user, final String pass) 
    {
        Properties props = new Properties();

        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");	
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        
        Session session = Session.getDefaultInstance(props,new Authenticator() 
        {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() 
            {
                return new PasswordAuthentication(user, pass);
            }
        });

        try 
        {
            Message message = new MimeMessage(session);
            
            message.setFrom(new InternetAddress(user));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(sub);
            message.setText(msg);

            Transport.send(message);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
       
        alert.setContentText("Email envoyé");
       alert.setHeaderText(null);
    
       alert.show();
           
            
        } catch (MessagingException e) 
        {
            
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
       
         alert.setContentText("Email non existe");
       alert.setHeaderText(null);
    
       alert.show();
            throw new RuntimeException(e);
        }
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}