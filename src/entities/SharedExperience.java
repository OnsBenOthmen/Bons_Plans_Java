/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import techniques.DataSource;

/**
 *
 * @author HP
 */
public class SharedExperience {
    private int id;
    private int id_etablissement;
    private int id_user;
    private Date checkInDate;
    private String impression;
    private String photo;
    
    private Etablissement etablissement;
    private User user;
    //Les attributs DB
    SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat formater1 = new SimpleDateFormat ("HH:mm:ss");
    Connection conn = DataSource.getInstance().getConnection();
    private ResultSet rs;
    private PreparedStatement ps;
    private Statement stmt;

    public SharedExperience(int id, int id_etablissement, int id_user, Date checkInDate, String impression, String photo) {
        this.id = id;
        this.id_etablissement = id_etablissement;
        this.id_user = id_user;
        this.checkInDate = checkInDate;
        this.impression = impression;
        this.photo = photo;
    }

    public SharedExperience(int id_etablissement, int id_user, Date checkInDate, String impression, String photo) {
        this.id_etablissement = id_etablissement;
        this.id_user = id_user;
        this.checkInDate = checkInDate;
        this.impression = impression;
        this.photo = photo;
    }

    public SharedExperience() {
        
    }

    

    @Override
    public String toString() {
        return "SharedExperience{" + "id=" + id + ", id_etablissement=" 
                + id_etablissement + ", id_user=" + id_user + ", checkInDate=" + checkInDate + 
                ", impression=" + impression + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SharedExperience other = (SharedExperience) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.id_etablissement != other.id_etablissement) {
            return false;
        }
        return true;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_etablissement() {
        return id_etablissement;
    }

    public void setId_etablissement(int id_etablissement) {
        this.id_etablissement = id_etablissement;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public String getImpression() {
        return impression;
    }

    public void setImpression(String impression) {
        this.impression = impression;
    }
public int ajouterShEx() {
        /**
         * Creation de Statement**
         */
        try {

            stmt = conn.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        /**
         * Creation de la Requete**
         *
         */
        String date = formater.format(this.checkInDate);
        
            
        String req = "INSERT INTO `shared_experience`(`id`, `id_etablissement`, `id_user`,"
                + " `checkInDate`, `impression`,`photo`, "
                + " VALUES (" + this.id + "," + this.id_etablissement + ",'" + this.id_user + "','" 
                + date + "','" +this.impression + "','" + this.photo +")";
        try {
            /**
             * execution de la requette**
             */
            stmt.executeUpdate(req);
            return 1;
        } catch (SQLException ex) {

            System.out.println(ex.getMessage());
        }
        return 0;

    }
 public int modifierShEx() {
        /**
         * Creation de Statement**
         */
        try {

            stmt = conn.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        /**
         * Creation de la Requette**
         */
        String date = formater.format(this.checkInDate);
       
        String req = "UPDATE `shared_experience` SET `id_etablissement`=" + this.id_etablissement + ",`id_user`='" + this.id_user + "',`date`='" + date + "',`impression`='" + this.impression + "',`photo`='" + this.photo + "' WHERE `id`=" + this.id + ";";
        System.out.println(req);
        try {
            /*
             * execution de la requette**
             */
            stmt.executeUpdate(req);
            System.out.println("Updaaaaate jawou behi");
            return 1;
        } catch (SQLException ex) {

            System.out.println(ex.getMessage());
            System.out.println("Irèère");
        }
        return 0;

    }
 public ArrayList<SharedExperience> displayShEx() {
        ArrayList<SharedExperience> SharedExs = new ArrayList<>();
        String req = "Select * From shared_experience where id_user = " ;/*+ IHM_loginController.user.getId();*/
        try {
            ps = conn.prepareStatement(req);
            rs = ps.executeQuery();
            while (rs.next()) {
                SharedExperience ShEx = new SharedExperience();
                ShEx.id = rs.getInt("id");
                ShEx.id_etablissement = rs.getInt("id_etablissement");
                ShEx.id_user = rs.getInt("id_user");
                ShEx.checkInDate = rs.getDate("checkInDate");
                ShEx.impression = rs.getString("impression");
                ShEx.photo = rs.getString("photo");
                
                SharedExs.add(ShEx);
            }
            return SharedExs;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Erreuuur d'execution req");
        }
        return SharedExs;

    }
    public int supprimerShEx() {
        try {
            String req = "DELETE FROM `shared_experience`"
                + " WHERE id = " + this.id
                + ";";
            ps = conn.prepareStatement(req);
            ps.setInt(1, this.id);
            ps.execute();

            return 1;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return 0;

    }
    public int rechercheShEx(int id) {

        SharedExperience ShEx = new SharedExperience();

        String req = "Select * From shared_experience where id=?";
        try {
            ps = conn.prepareStatement(req);
            ps.setInt(1, this.id);
            rs = ps.executeQuery();
            if (rs.next()) {
                ShEx.id = rs.getInt(1);
                ShEx.id_etablissement = rs.getInt(2);
                ShEx.id_user = rs.getInt(3);
                ShEx.impression = rs.getString(4);
                ShEx.checkInDate = rs.getDate(5);
                ShEx.photo = rs.getString(6);
                
                
            }
            return 1;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return 0;

    }

    
    
}
