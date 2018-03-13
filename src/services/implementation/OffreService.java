/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.implementation;
import entities.Etablissement;
import entities.Offre;
import services.interfaces.IOffreService;
import entities.Evenement;
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
public class OffreService implements IOffreService{
     private Connection connection;

    public OffreService() {
        connection = DataSource.getInstance().getConnection();
    }
    @Override
        public void add(Offre offre) {
        try {
            String req = "insert into offre(id_etablissement,"
                    + "date_debut,"
                    + "date_fin,"
                    + "description,"
                    + "offre)"
                    + " values (?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(req);
            ps.setInt(1, offre.getId_etablissement());
            ps.setDate(2, offre.getDate_debut());
            ps.setDate(3, offre.getDate_fin());
            ps.setString(4,offre.getDescription());
            ps.setString(5,offre.getOffre());
            ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
         @Override
    public void update(Offre offre) {

        try {
            String req = "update offre set offre = ? , description = ?, date_debut = ? , date_fin = ? where id = ?";
            PreparedStatement ps = connection.prepareStatement(req);
            ps.setString(1, offre.getOffre());
            ps.setString(2, offre.getDescription());
            ps.setDate(3, offre.getDate_debut());
            ps.setDate(4, offre.getDate_fin());
            ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
        @Override
    public void delete(Offre offre) {
        
           try {
            String req = "delete from offre where id = ?";
            PreparedStatement ps = connection.prepareStatement(req);
            ps.setInt(1,offre.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
     @Override
        public List<Offre> getAll() {
        List<Offre> offres = new ArrayList<>();
        try {

            String req = "select * from offre";
            PreparedStatement ps = connection.prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Offre offer = new Offre( rs.getInt(1),rs.getInt(2), rs.getDate(5), rs.getDate(6),rs.getString(4), rs.getString(3));
                offres.add(offer);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return offres;
    }
        
    @Override
    public Offre findById(Integer id) {
        Offre offer = null;
        try {
            String req = "select * from offre where id =?";
            PreparedStatement ps = connection.prepareStatement(req);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                 offer = new Offre( rs.getInt(1),rs.getInt(2), rs.getDate(5), rs.getDate(6),rs.getString(4), rs.getString(3));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return offer;  
    }
}
