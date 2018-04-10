package entities;

import java.util.List;

/**
 *
 * @author Ons Ben Othmen
 */

    

    

import java.util.ArrayList;
import java.util.List;

public class Etablissement 
{
    private int id;
    private String nom;
    private String type;
    private String adresse;
    private String description;
    private String horaire_ouverture;
    private String horaire_fermeture;
    private int numtel;
    private String url;
    private int budgetmoyen;
    private String image;
    private String type_resto;
    private String type_loisirs;
    private String type_shops;
    private String nbrStars;
    
    private List<Reservation> reservations;
    private List<SharedExperience> sh_Experiences;


    public Etablissement(int id,String nom, String type, String adresse, String description, String horaire_ouverture, String horaire_fermeture, int numtel, String url, int budgetmoyen, String image, String type_resto, String type_loisirs, String type_shops, String nbrStars) 
    {
        this.id = id;
        this.nom = nom;
        this.type = type;
        this.adresse = adresse;
        this.description = description;
        this.horaire_ouverture = horaire_ouverture;
        this.horaire_fermeture = horaire_fermeture;
        this.numtel = numtel;
        this.url = url;
        this.budgetmoyen = budgetmoyen;
        this.image = image;
        this.type_resto = type_resto;
        this.type_loisirs = type_loisirs;
        this.type_shops = type_shops;
        this.nbrStars = nbrStars;
    }

    public int getId() 
    {
        return id;
    }

    public void setId(int id) 
    {
        this.id = id;
    }

    public String getNom() 
    {
        return nom;
    }

    public void setNom(String nom) 
    {
        this.nom = nom;
    }

    public String getType() 
    {
        return type;
    }

    public void setType(String type) 
    {
        this.type = type;
    }

    public String getAdresse() 
    {
        return adresse;
    }

    public void setAdresse(String adresse) 
    {
        this.adresse = adresse;
    }

    public String getDescription() 
    {
        return description;
    }

    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getHoraire_ouverture() {
        return horaire_ouverture;
    }

    public void setHoraire_ouverture(String horaire_ouverture) {
        this.horaire_ouverture = horaire_ouverture;
    }

    public String getHoraire_fermeture() {
        return horaire_fermeture;
    }

    public void setHoraire_fermeture(String horaire_fermeture) {
        this.horaire_fermeture = horaire_fermeture;
    }

    public int getNumtel() 
    {
        return numtel;
    }

    public void setNumtel(int numtel) 
    {
        this.numtel = numtel;
    }

    public String getUrl() 
    {
        return url;
    }

    public void setUrl(String url) 
    {
        this.url = url;
    }

    public int getBudgetmoyen() 
    {
        return budgetmoyen;
    }

    public void setBudgetmoyen(int budgetmoyen) 
    {
        this.budgetmoyen = budgetmoyen;
    }

    public String getImage() 
    {
        return image;
    }

    public void setImage(String image) 
    {
        this.image = image;
    }

    public String getType_resto() 
    {
        return type_resto;
    }

    public void setType_resto(String type_resto) 
    {
        this.type_resto = type_resto;
    }

    public String getType_loisirs() 
    {
        return type_loisirs;
    }

    public void setType_loisirs(String type_loisirs) 
    {
        this.type_loisirs = type_loisirs;
    }

    public String getType_shops() 
    {
        return type_shops;
    }

    public void setType_shops(String type_shops) 
    {
        this.type_shops = type_shops;
    }

    public String getNbrStars() 
    {
        return nbrStars;
    }

    public void setNbrStars(String nbrStars) 
    {
        this.nbrStars = nbrStars;
    }
    
    @Override
    public int hashCode() 
    {
        int hash = 7;
        hash = 37 * hash + this.getId();
        return hash;
    }

    @Override
    public boolean equals(Object obj) 
    {
        if (this == obj) 
        {
            return true;
        }
        
        if (obj == null) 
        {
            return false;
        }
        
        if (getClass() != obj.getClass()) 
        {
            return false;
        }
        final Etablissement other = (Etablissement) obj;
        if (this.getId() != other.getId()) 
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Etablissement{" + "id=" + id + '}';
    }
    public void setReservations(List<Reservation> reservations) {
		this.reservations=reservations;
	}
    public List<Reservation> getReservations() {
		return reservations;
	}
    public void setSh_Experiences(List<SharedExperience> sh_Experiences) {
		this.sh_Experiences=sh_Experiences;
	}
    public List<SharedExperience> getSh_Experiences() {
		return sh_Experiences;
	}

    
  }
