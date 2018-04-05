
package Bons_Plans_Java;
import services.implementation.EtablissementService;
import services.implementation.EvenementService;
import services.implementation.GoingEventService;
import services.implementation.InterestedEventService;
import services.implementation.UserService;
import services.implementation.VisitedEtablissementService;
import services.implementation.LikedEtablissementService;
import services.implementation.OffreService;
import entities.Etablissement;
import entities.Evenement;
import entities.GoingEvent;
import entities.InterestedEvent;
import entities.LikedEtablissement;
import entities.Offre;
import entities.VisitedEtablissement;
import entities.User;
import java.util.List;
import services.implementation.TagService;
/**
 *
 * @author Ons Ben Othmen
 */
public class Bons_Plans_Java{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        EtablissementService ES = new EtablissementService();
        TagService TS = new TagService();
        //ES.Ajout("Omar","Jarrayy","Omar","Jarray","Omar","Jarray",20397487,"Jarray",45);
        ES.Affiche();
        //ES.Supp(1);
        //System.out.println("Effacé");
        //ES.Affiche();
        //TS.Modif(15,"P'tit Déj");
        //TS.Affiche();
    }
    
}
