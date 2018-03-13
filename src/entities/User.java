/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Logger;
import java.sql.Timestamp;
import java.util.Calendar;
import java.sql.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Ons Ben Othmen
 */
public class User implements Serializable{
    private int id ; 
    private String username ;
    private String nom ;
    private Date datedenaissance;
    private String Descrption;
    private String password;
    private int enabled;
    private String phone;
    private String email;
    private String URL;
    private String Sexe;
    private String roles;
    private String ville;
    private static int idofuserAlreadyloggedin;
    private static String myemail;

    public User() {
    }

    public User(int id, String username, String nom, Date datedenaissance, String password, String phone, String email, String URL, String Sexe, String ville) {
        this.id = id;
        this.username = username;
        this.nom = nom;
        this.datedenaissance = datedenaissance;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.URL = URL;
        this.Sexe = Sexe;
        this.ville = ville;
    }
    public User(int id, String username, String nom, Date datedenaissance, String phone, String email, String URL, String Sexe, String ville) {
        this.id = id;
        this.username = username;
        this.nom = nom;
        this.datedenaissance = datedenaissance;
        this.phone = phone;
        this.email = email;
        this.URL = URL;
        this.Sexe = Sexe;
        this.ville = ville;
    }

    public User(String username, String nom, String phone, String email) {
        this.username = username;
        this.nom = nom;
        this.phone = phone;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getDatedenaissance() {
        return datedenaissance;
    }

    public void setDatedenaissance(Date datedenaissance) {
        this.datedenaissance = datedenaissance;
    }

    public String getDescrption() {
        return Descrption;
    }

    public void setDescrption(String Descrption) {
        this.Descrption = Descrption;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getSexe() {
        return Sexe;
    }

    public void setSexe(String Sexe) {
        this.Sexe = Sexe;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", username=" + username + ", nom=" + nom + ", datedenaissance=" + datedenaissance + ", Descrption=" + Descrption + ", phone=" + phone + ", email=" + email + ", URL=" + URL + ", Sexe=" + Sexe + ", roles=" + roles + ", ville=" + ville + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + this.id;
        hash = 23 * hash + Objects.hashCode(this.email);
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
        final User other = (User) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.username != other.username) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        return true;
    }

    public static int getIdofuserAlreadyloggedin() {
        return idofuserAlreadyloggedin;
    }

    public static void setIdofuserAlreadyloggedin(int idofuserAlreadyloggedin) {
        User.idofuserAlreadyloggedin = idofuserAlreadyloggedin;
    }

    public static String getMyemail() {
        return myemail;
    }

    public static void setMyemail(String myemail) {
        User.myemail = myemail;
    }


    
  


   
  
}
