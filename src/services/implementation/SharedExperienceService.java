/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.implementation;

import entities.SharedExperience;
import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class SharedExperienceService {
    public int ajouterShEx(int id_etablissement, int id_user, String impression , java.sql.Date checkInDate, String photo) {
        SharedExperience SharedEx = new SharedExperience(id_etablissement, id_user, checkInDate, impression, photo);
        return SharedEx.ajouterShEx();    
    }
    public int modifierShEx(int id, int id_etablissement, int id_user, String impression , java.sql.Date checkInDate, String photo) {
        SharedExperience SharedEx = new SharedExperience(id, id_etablissement, id_user, checkInDate, impression, photo);
        return SharedEx.modifierShEx();    
    }
    public ArrayList AfficherShEx() {
        SharedExperience SharedEx = new SharedExperience();
        return SharedEx.displayShEx();
    }
    public int supprimmerShEx(SharedExperience SE) {
        SharedExperience SharedEx = new SharedExperience(SE.getId_etablissement(), SE.getId_user(), SE.getCheckInDate(), SE.getImpression(), 
        SE.getPhoto());
        return SharedEx.supprimerShEx();
    }
    
}
