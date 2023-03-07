/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import entities.Commande;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.mysql.cj.xdevapi.Statement;
import java.awt.Desktop;
import java.awt.HeadlessException;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javax.swing.JOptionPane;
import org.controlsfx.control.Notifications;
import utils.MyDB;

/**
 * FXML Controller class
 *
 * @author ashre
 */
public class SousAdminCommandeController implements Initializable {

    private Label nom;
    @FXML
    private Label commande_id;
    @FXML
    private Label user_id;
    @FXML
    private Label commande_date;
    @FXML
    private Button imprimer;
    @FXML
    private Button suppcom;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    void SetCommande(Commande r) {
        
       user_id.setText(Integer.toString(r.getUser_id()) );
       commande_id.setText(Integer.toString(r.getCommande_id()));
       commande_date.setText(r.getDate_commande());
        
//     datec.setText(r.getDate_commande());
    }

    @FXML
    
        private void imprimerFacture(MouseEvent event) throws SQLException {
//    try {
//        Document doc = new Document();
//        PdfWriter.getInstance(doc, new FileOutputStream("C:\\Users\\wajdi\\Documents\\NetBeansProjects\\projet_pidev_3a6\\src\\gui\\images\\pdf.pdf"));
//        doc.open();
//
//        doc.add(new Paragraph(" "));
//        Font font = new Font(FontFamily.TIMES_ROMAN, 28, Font.UNDERLINE, BaseColor.BLACK);
//        Paragraph p = new Paragraph("Commande Informations", font);
//        p.setAlignment(Element.ALIGN_CENTER);
//        doc.add(p);
//        doc.add(new Paragraph(" "));
//        doc.add(new Paragraph(" "));
//
//        PdfPTable tabpdf = new PdfPTable(2);
//        tabpdf.setWidthPercentage(100);
//
//        PdfPCell cell;
//
//        cell = new PdfPCell(new Phrase("date_res", FontFactory.getFont("Times New Roman", 11)));
//        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//        cell.setBackgroundColor(BaseColor.WHITE);
//        tabpdf.addCell(cell);
//
//        cell = new PdfPCell(new Phrase("prix_res", FontFactory.getFont("Times New Roman", 11)));
//        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//        cell.setBackgroundColor(BaseColor.WHITE);
//        tabpdf.addCell(cell);
//
////        String req = "SELECT date_res,prix_res from reservations";
////        PreparedStatement pst = cnx.prepareStatement(req);
////        ResultSet rs = pst.executeQuery();
//
//java.sql.Connection con1 =  MyDB.getInstance().getCnx();
//       String req = "SELECT date_res,prix_res from reservations";
//        java.sql.Statement st = con1.createStatement();
//        ResultSet rs =  st.executeQuery(req);
//
//        while (rs.next()) {
//            System.out.println(rs.getString("date_res"));
//            cell = new PdfPCell(new Phrase(rs.getString("date_res"), FontFactory.getFont("Times New Roman", 11)));
//            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//            cell.setBackgroundColor(BaseColor.WHITE);
//            tabpdf.addCell(cell);
//
//            cell = new PdfPCell(new Phrase(rs.getString("prix_res"), FontFactory.getFont("Times New Roman", 11)));
//            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//            cell.setBackgroundColor(BaseColor.WHITE);
//            tabpdf.addCell(cell);
//        }
//
//        doc.add(tabpdf);
//        JOptionPane.showMessageDialog(null, "Success !!");
//        doc.close();
//        Desktop.getDesktop().open(new File("C:\\Users\\wajdi\\Documents\\NetBeansProjects\\projet_pidev_3a6\\src\\gui\\images\\pdf.pdf"));
//
//        Notifications notificationBuilder = Notifications.create()
//                .title("Succes").text("Your document has been saved as PDF !!").graphic(null).hideAfter(javafx.util.Duration.seconds(5))
//                .position(Pos.CENTER_LEFT)
//                .onAction(new EventHandler<ActionEvent>() {
//                    public void handle(ActionEvent event) {
//                        System.out.println("clicked ON ");
//                    }
//                });
//        notificationBuilder.darkStyle();
//        notificationBuilder.show();
//    } catch (DocumentException | HeadlessException | IOException e) {
//        System.out.println("ERROR PDF");
//        System.out.println(Arrays.toString(e.getStackTrace()));
//        System.out.println(e.getMessage());
//        }
    
    }

}
