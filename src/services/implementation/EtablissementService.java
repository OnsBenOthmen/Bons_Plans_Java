/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.implementation;
import entities.Etablissement;
import entities.LikedEtablissement;
import entities.User;
import entities.VisitedEtablissement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import techniques.DataSource;
/**
 *
 * @author Ons Ben Othmen
 */
public class EtablissementService {
     private Connection connection;

    public EtablissementService() {
        connection = DataSource.getInstance().getConnection();
    }
    public Etablissement findById(Integer id) {
        Etablissement etab = null;
        try {
            String req = "select * from etablissement where id =?";
            PreparedStatement ps = connection.prepareStatement(req);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                 etab = new Etablissement(rs.getInt(1));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return etab;  
    }
    public int countVisited(int etablissement){
        int res=0;
        try {
            String req = "select * from visited where favoris_id=?";
            PreparedStatement ps = connection.prepareStatement(req);
            ps.setInt(1, etablissement);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                 res++;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return res;
    }
        public int countLikes(int etablissement){
        int res=0;
        try {
            String req = "select * from wishliste where favoris_id=?";
            PreparedStatement ps = connection.prepareStatement(req);
            ps.setInt(1, etablissement);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                 res++;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return res;
    }
}
