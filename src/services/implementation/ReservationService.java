/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.implementation;

import entities.Reservation;
import java.util.ArrayList;


public class ReservationService {
   

     public int ajouterReservation(int id_etablissement, int id_user, java.sql.Date date, java.sql.Date Heure, String nom, String prenom, String num_tel, int nbr_personnes, java.sql.Date arrivee, java.sql.Date depart, int nbr_chambres, int nbr_adultes, int nbr_enfants) {
        Reservation reserv = new Reservation(id_etablissement, id_user , date 
                , Heure, nom, prenom , num_tel , nbr_personnes , arrivee , depart , nbr_chambres , nbr_adultes , nbr_enfants);
        return reserv.ajouterReservation();
        
    }
      public int modifierReservation(int id, int id_etablissement, int id_user, java.sql.Date date, java.sql.Date Heure, String nom, String prenom, String num_tel, int nbr_personnes, java.sql.Date arrivee, java.sql.Date depart, int nbr_chambres, int nbr_adultes, int nbr_enfants) {
        Reservation reserv = new Reservation(id, id_etablissement, id_user , date 
                , Heure, nom, prenom , num_tel , nbr_personnes , arrivee , depart , nbr_chambres , nbr_adultes , nbr_enfants);
        return reserv.modifierReservation();
    }
      public ArrayList AfficherReservation() {
        Reservation reserv = new Reservation();
        return reserv.displayReservation();
    }
       public int supprimmerReservation(Reservation rs) {
        Reservation reserv = new Reservation(rs.getId_etablissement(), rs.getId_user(), rs.getDate(), rs.getHeure(), 
        rs.getNom(), rs.getPrenom(), rs.getNum_tel(), rs.getNbr_personnes(),
                rs.getArrivee(), rs.getDepart(), rs.getNbr_chambres(), rs.getNbr_adultes(), rs.getNbr_enfants());
        return reserv.supprimerReservation();
    }
          
       
    
}

