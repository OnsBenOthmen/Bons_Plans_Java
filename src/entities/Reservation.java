/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Objects;
import techniques.DataSource;

/**
 *
 * @author HP
 */
public class Reservation {
    private int id;
    private int id_etablissement;
    private int id_user;
    private Date date;
    private Date Heure;
    private String nom;
    private String prenom;
    private String num_tel;
    private int nbr_personnes;
    private Date arrivee;
    private Date depart;
    private int nbr_chambres;
    private int nbr_adultes;
    private int nbr_enfants;

    private Etablissement etablissement;
    private User user;
    //Les attributs DB
    SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat formater1 = new SimpleDateFormat ("HH:mm:ss");
    Connection conn = DataSource.getInstance().getConnection();
    private ResultSet rs;
    private PreparedStatement ps;
    private Statement stmt;

    public Reservation(int id, int id_etablissement, int id_user, Date date, Date Heure, String nom, String prenom, String num_tel, int nbr_personnes, Date arrivee, Date depart, int nbr_chambres, int nbr_adultes, int nbr_enfants) {
        this.id = id;
        this.id_etablissement = id_etablissement;
        this.id_user = id_user;
        this.date = date;
        this.Heure = Heure;
        this.nom = nom;
        this.prenom = prenom;
        this.num_tel = num_tel;
        this.nbr_personnes = nbr_personnes;
        this.arrivee = arrivee;
        this.depart = depart;
        this.nbr_chambres = nbr_chambres;
        this.nbr_adultes = nbr_adultes;
        this.nbr_enfants = nbr_enfants;
        
    }

    public Reservation(int id_etablissement, int id_user, Date date, Date Heure, String nom, String prenom, String num_tel, int nbr_personnes, Date arrivee, Date depart, int nbr_chambres, int nbr_adultes, int nbr_enfants) {
        this.id_etablissement = id_etablissement;
        this.id_user = id_user;
        this.date = date;
        this.Heure = Heure;
        this.nom = nom;
        this.prenom = prenom;
        this.num_tel = num_tel;
        this.nbr_personnes = nbr_personnes;
        this.arrivee = arrivee;
        this.depart = depart;
        this.nbr_chambres = nbr_chambres;
        this.nbr_adultes = nbr_adultes;
        this.nbr_enfants = nbr_enfants;
    }
    
    
    public Reservation()
    {
        
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getHeure() {
        return Heure;
    }

    public void setHeure(Date Heure) {
        this.Heure = Heure;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNum_tel() {
        return num_tel;
    }

    public void setNum_tel(String num_tel) {
        this.num_tel = num_tel;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getNbr_personnes() {
        return nbr_personnes;
    }

    public void setNbr_personnes(int nbr_personnes) {
        this.nbr_personnes = nbr_personnes;
    }
    public void setEtablissement(Etablissement etablissement) {
		this.etablissement=etablissement;
	}
	public Etablissement getEtablissement() {
		return etablissement;
	}

    public Date getArrivee() {
        return arrivee;
    }

    public void setArrivee(Date arrivee) {
        this.arrivee = arrivee;
    }

    public Date getDepart() {
        return depart;
    }

    public void setDepart(Date depart) {
        this.depart = depart;
    }

    public int getNbr_chambres() {
        return nbr_chambres;
    }

    public void setNbr_chambres(int nbr_chambres) {
        this.nbr_chambres = nbr_chambres;
    }

    public int getNbr_adultes() {
        return nbr_adultes;
    }

    public void setNbr_adultes(int nbr_adultes) {
        this.nbr_adultes = nbr_adultes;
    }

    public int getNbr_enfants() {
        return nbr_enfants;
    }

    public void setNbr_enfants(int nbr_enfants) {
        this.nbr_enfants = nbr_enfants;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Reservation{" + "id=" + id + ", id_etablissement=" + id_etablissement + ", id_user=" + id_user + ", date=" + date + ", Heure=" + Heure + ", nom=" + nom + ", prenom=" + prenom + ", num_tel=" + num_tel + ", nbr_personnes=" + nbr_personnes + ", arrivee=" + arrivee + ", depart=" + depart + ", nbr_chambres=" + nbr_chambres + ", nbr_adultes=" + nbr_adultes + ", nbr_enfants=" + nbr_enfants + '}';
    }
    

    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.id);
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
        final Reservation other = (Reservation) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.id_etablissement != other.id_etablissement) {
            return false;
        }
        return true;
    }
    
    public int ajouterReservation() {
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
        String date = formater.format(this.date);
        String Heure = formater.format(this.Heure);
        String depart = formater.format(this.depart);
        String arrivee = formater.format(this.arrivee);
            
        String req = "INSERT INTO `reservation`(`id`, `id_etablissement`, `id_user`,"
                + " `date`, `Heure`,`nom`, "
                + "`prenom`, `num_tel`,`nbr_personnes`,`arrivee`,`depart`,`nbr_chambres`"
                + ",`nbr_adultes`,`nbr_enfants`)"
                + " VALUES (" + this.id + "," + this.id_etablissement + ",'" + this.id_user + "','" 
                + date + "','" + Heure + "','" + this.nom + "','" + this.prenom + "','" 
                + this.num_tel + "','" + this.nbr_personnes + "','" + arrivee + "','" 
                + depart + "','" + this.nbr_chambres + "','" + this.nbr_adultes + "',"
                + this.nbr_enfants + ")";
                System.out.println(req);
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
    
    public int modifierReservation() {
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
        String date = formater.format(this.date);
        String Heure = formater.format(this.Heure);
        String depart = formater.format(this.depart);
        String arrivee = formater.format(this.arrivee);
        
        String req = "UPDATE `reservation` SET `id_etablissement`=" + this.id_etablissement + ",`id_user`='" + this.id_user + "',`date`='" + date + "',`Heure`='" + Heure + "',`nom`='" + this.nom + "',`prenom`='" + this.prenom + "',`num_tel`='" + this.num_tel + "',`nbr_personnes`='" + this.nbr_personnes + "',`arrivee`='" + arrivee + "',`depart`='" + depart + "',`nbr_chambres`='" + this.nbr_chambres + "',`nbr_adultes`='" + this.nbr_adultes + "',`nbr_enfants`='" + this.nbr_enfants + "' WHERE `id`=" + this.id + ";";
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
    
    public int rechercheReservation(int id) {

        Reservation Res = new Reservation();

        String req = "Select * From reservation where id=?";
        try {
            ps = conn.prepareStatement(req);
            ps.setInt(1, this.id);
            rs = ps.executeQuery();
            if (rs.next()) {
                Res.id = rs.getInt(1);
                Res.id_etablissement = rs.getInt(2);
                Res.id_user = rs.getInt(3);
                Res.date = rs.getDate(4);
                Res.Heure = rs.getDate(5);
                Res.nom = rs.getString(6);
                Res.prenom = rs.getString(7);
                Res.num_tel = rs.getString(8);
                Res.nbr_personnes = rs.getInt(9);
                Res.arrivee = rs.getDate(10);
                Res.depart = rs.getDate(11);
                Res.nbr_chambres = rs.getInt(12);
                Res.nbr_enfants = rs.getInt(13);
                
            }
            return 1;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return 0;

    }
    
    public ArrayList<Reservation> displayReservation() {
        ArrayList<Reservation> reservations = new ArrayList<>();
        String req = "Select * From reservation  " ;/*+ where id_user =IHM_loginController.user.getId();*/
        try {
            ps = conn.prepareStatement(req);
            rs = ps.executeQuery();
            while (rs.next()) {
                Reservation Res = new Reservation();
                Res.id = rs.getInt("id");
                Res.id_etablissement = rs.getInt("id_etablissement");
                Res.id_user = rs.getInt("id_user");
                Res.date = rs.getDate("date");
                Res.Heure = rs.getDate("Heure");
                Res.nom = rs.getString("nom");
                Res.prenom = rs.getString("prenom");
                Res.num_tel = rs.getString("num_tel");
                Res.nbr_personnes = rs.getInt("nbr_personnes");
                Res.arrivee = rs.getDate("arrivee");
                Res.depart = rs.getDate("depart");
                Res.nbr_chambres = rs.getInt("nbr_chambres");
                Res.nbr_enfants = rs.getInt("nbr_enfants");
                reservations.add(Res);
            }
            return reservations;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Erreuuur d'execution req");
        }
        return reservations;

    }
    
    public int supprimerReservation() {
        try {
            String req = "DELETE FROM `reservation`"
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

    public Reservation getReservation(int id) {
            
     Reservation Res=new Reservation();
        String req = "Select * From reservation  where id=" + id + ";" ;/*+ where id_user =IHM_loginController.user.getId();*/
        System.out.println(req);
        try {
            ps = conn.prepareStatement(req);
            rs = ps.executeQuery();
            while (rs.next()) {
               
                Res.id = rs.getInt("id");
                Res.id_etablissement = rs.getInt("id_etablissement");
                Res.id_user = rs.getInt("id_user");
                Res.date = rs.getDate("date");
                Res.Heure = rs.getDate("Heure");
                Res.nom = rs.getString("nom");
                Res.prenom = rs.getString("prenom");
                Res.num_tel = rs.getString("num_tel");
                Res.nbr_personnes = rs.getInt("nbr_personnes");
                Res.arrivee = rs.getDate("arrivee");
                Res.depart = rs.getDate("depart");
                Res.nbr_chambres = rs.getInt("nbr_chambres");
                Res.nbr_enfants = rs.getInt("nbr_enfants");
               
            }
            return Res;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Erreuuur d'execution req");
        }
        return Res;
    }

    public void modifierTest(String nom, String prenom, int nbr_adultes) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
    
}
