/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Reservation;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import services.implementation.ReservationService;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class Reservation_AfficheController implements Initializable {

    @FXML
    private TableView<Reservation> listReservation;
    @FXML
    private TableColumn<Reservation, String> nomCol;
    @FXML
    private TableColumn<Reservation, String> prenCol;
    @FXML
    private TableColumn<Reservation, String> numtelCol;
    @FXML
    private TableColumn<Reservation, Integer> nbPersonCol;
    @FXML
    private TableColumn<Reservation, Date> arrivedaCol;
    public static int idZbotrech;
    
    ReservationService rs=new ReservationService();
     ArrayList<Reservation> listRes = rs.AfficherReservation();
    @FXML
    private Button modifierRes;
    @FXML
    private Button SuprrimerReser;
    public static int idRes;
    @FXML
    private TextField find;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
         nomCol.setCellValueFactory(new PropertyValueFactory("nom"));
         prenCol.setCellValueFactory(new PropertyValueFactory("prenom"));
         numtelCol.setCellValueFactory(new PropertyValueFactory("num_tel"));
         nbPersonCol.setCellValueFactory(new PropertyValueFactory("nbr_personnes"));
         arrivedaCol.setCellValueFactory(new PropertyValueFactory("arrivee"));
         for (Reservation li : listRes) {
             System.out.println(li);
        }
         listReservation.getItems().addAll(listRes);
         
    }    

    @FXML
    private void modifierReserv(ActionEvent event) {
        try {
            Reservation R =listReservation.getSelectionModel().getSelectedItem();
            
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("modifierReserv.fxml"));
            this.idZbotrech = R.getId();
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.setX(R.getId());
            stage.show();
            System.out.println(idZbotrech);
        } catch (IOException ex) {
            System.out.println(ex.toString());    
        }
    }
    
     public ArrayList<Reservation> recherche(String x) {
        return (ArrayList<Reservation>) listReservation.getItems().stream().filter(
        t -> t.getNom().startsWith(x)
        || t.getPrenom().startsWith(x)
        
                        || t.getNum_tel().startsWith(x)
                        
                       




      
        ).collect(Collectors.toList());

    }

    @FXML
    private void SuprrimerResera(ActionEvent event) {
    }

    @FXML
    private void findKey(KeyEvent event) {
         String mot = find.getText();
         if (mot.length() > 0) {
            List<Reservation> vet = recherche(mot);
            listReservation.getItems().clear();
            listReservation.getItems().addAll(vet);
        } else {
            listReservation.getItems().clear();
            listReservation.getItems().addAll(rs.AfficherReservation());
        }
    }
    
       
    
}
