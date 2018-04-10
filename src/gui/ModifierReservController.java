/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Reservation;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import services.implementation.ReservationService;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class ModifierReservController implements Initializable {

    @FXML
    private Label Nom;
    @FXML
    private Label Prenom;
    @FXML
    private TextField nbrC;
    @FXML
    private TextField prenom;
    @FXML
    private Label NbrChambres;
    @FXML
    private Label NombreAdultes;
    @FXML
    private Label NombreEnfants;
    @FXML
    private TextField nbrA;
    @FXML
    private TextField NbrE;
    @FXML
    private TextField nom;
    ReservationService rs=new ReservationService();
    @FXML
    private Button modifier;
    @FXML
    private Label Date_de_reservation;
    @FXML
    private DatePicker DateD;
    @FXML
    private Label heure;
    @FXML
    private Label NombrePersonnes;
    @FXML
    private Label DateArrivée;
    @FXML
    private Label DateDépart;
    @FXML
    private Label NumTelephone;
    @FXML
    private DatePicker Heure;
    @FXML
    private TextField Num_tel;
    @FXML
    private TextField NbrP;
    @FXML
    private DatePicker DateA;
    @FXML
    private DatePicker DateReserv;
     SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date datedeb;
            Date heur;
            Date datde;
            Date datearr;
     
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        System.out.println(Reservation_AfficheController.idZbotrech);
         Reservation m = rs.getReservation(Reservation_AfficheController.idZbotrech);
         System.out.println(m);
         nom.setText(m.getNom());
         prenom.setText(m.getPrenom());
         nbrA.setText(""+m.getNbr_adultes());
         LocalDate ld = LocalDate.parse(m.getArrivee().toString());
         LocalDate ld1 = LocalDate.parse(m.getDepart().toString());
                DateD.setValue(ld);
                DateA.setValue(ld1);
        NbrE.setText(""+m.getNbr_enfants());
  
         
    }    

    @FXML
    private void modi(ActionEvent event) {
        
        try {
            datedeb = format.parse(DateReserv.getValue().toString());
            heur = format.parse(Heure.getValue().toString());
            datearr = format.parse(DateA.getValue().toString());
            datde = format.parse(DateD.getValue().toString());
            
           
        } catch (ParseException ex) {
            System.out.println(ex.toString());
        }
//         rs.modifierReservation(nom.getText(),prenom.getText(),Integer.parseInt(nbrA.getText()));
         rs.modifierReservation(Reservation_AfficheController.idZbotrech,1,1, datedeb, heur, nom.getText(), prenom.getText(), NumTelephone.getText(), Integer.parseInt(NbrP.getText()),datearr,datde,  Integer.parseInt(nbrC.getText()), Integer.parseInt(nbrA.getText()), Integer.parseInt(NbrE.getText()));
    }
    
}
