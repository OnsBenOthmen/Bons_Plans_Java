/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
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
public class ReservationIHMController implements Initializable {

    @FXML
    private Label Nom;
    @FXML
    private Label Prenom;
    @FXML
    private TextField nbrC;
    @FXML
    private TextField prenom;
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
    private Label NbrChambres;
    @FXML
    private Label NombreAdultes;
    @FXML
    private Label NombreEnfants;
    @FXML
    private Label NumTelephone;
    @FXML
    private DatePicker Heure;
    @FXML
    private TextField nbrA;
    @FXML
    private TextField NbrE;
    @FXML
    private TextField Num_tel;
    @FXML
    private TextField NbrP;
    @FXML
    private DatePicker DateA;
    @FXML
    private DatePicker DateReserv;
    @FXML
    private TextField nom;
    @FXML
    private Button ajouter;
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
    }    

    @FXML
    private void ajouterReserv(ActionEvent event) {
         SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//          SimpleDateFormat formater1 = new SimpleDateFormat ("HH:mm:ss");

          
            
        try {
           
            datedeb = format.parse(DateReserv.getValue().toString());
            heur = format.parse(Heure.getValue().toString());
            datearr = format.parse(DateA.getValue().toString());
            datde = format.parse(DateD.getValue().toString());
        } catch (ParseException ex) {

            System.out.println(ex.toString());}
        ReservationService rs=new ReservationService();
        rs.ajouterReservation(1, 1, datedeb, heur, nom.getText(), prenom.getText(), NumTelephone.getText(),  Integer.parseInt(NbrP.getText()), datearr, datearr, Integer.parseInt(nbrC.getText()), Integer.parseInt(nbrA.getText()), Integer.parseInt(NbrE.getText()));
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("fiche de reservation ajoutée");
            alert.showAndWait();
    }
//    @FXML
//    private void modi(ActionEvent event) throws ParseException {
//        int id = listeFicheDeDressage.getItems().get(listeFicheDeDressage.getSelectionModel().getSelectedIndex()).getId_f_Dressage();
//        int id_anim = ConsulterFicheDeDressageController.iddd;//listeFicheDeDressage.getItems().get(listeFicheDeDressage.getSelectionModel().getSelectedIndex()).getId_animal();
//        System.out.println(id);
//        System.out.println(id_anim);
//        if (verif()) {
//            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//            Date datedeb = format.parse(datedep.getValue().toString());
//            Date datFin = format.parse(datef.getValue().toString());
//            Float notet = Float.parseFloat(displinetext.getText()) + Float.parseFloat(obeissancetext.getText()) + Float.parseFloat(accompagnementtext.getText()) + Float.parseFloat(interceptiontext.getText()) / 4;
//            cfdd.modifierFicheDeDressage(id, 1, specialitetext.getText(), Float.parseFloat(displinetext.getText()), Float.parseFloat(obeissancetext.getText()), Float.parseFloat(accompagnementtext.getText()), Float.parseFloat(interceptiontext.getText()), notet, datedeb, datFin, id_anim, 1);
//            Alert alert = new Alert(Alert.AlertType.INFORMATION);
//            alert.setTitle("Information Dialog");
//            alert.setHeaderText(null);
//            alert.setContentText("fiche de dressage modifier");
//            alert.showAndWait();
//            ref();
//
//        }
//    }
    
}