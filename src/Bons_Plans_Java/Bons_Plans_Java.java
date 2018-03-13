
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
/**
 *
 * @author Ons Ben Othmen
 */
public class Bons_Plans_Java{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        UserService userService=new UserService();
        User user=userService.getUserbyId(1);
        System.out.println(user.toString());
        EtablissementService service1=new EtablissementService();
        Etablissement etab=service1.findById(17);
        System.out.println(etab.toString()+" California gym");
        System.out.println(service1.countLikes(17)+"  Likes");
        System.out.println(service1.countVisited(17)+" Visites");
        EvenementService service2=new EvenementService();
        Evenement e1=service2.findById(19);
        System.out.println("Evenement Cagy : "+e1.toString());
        System.out.println("Liste des évenements: ");
        List<Evenement>liste=service2.getAll();
        for (int i=0 ; i<liste.size();i++){
        System.out.println(liste.get(i).toString());
        }
        GoingEventService service3=new GoingEventService();
        if (service3.count(1, 19)==1)
        {
            System.out.println("Ons is going to "+e1.getNom());
        }
        else {
            System.out.println("Ons is not going to "+e1.getNom());
        }
        InterestedEventService service4= new InterestedEventService();
        if (service4.count(1, 19)==1)
        {
            System.out.println("Ons is interested in "+e1.getNom());
        }
        else {
            System.out.println("Ons is not interested in "+e1.getNom());
        }
        
        VisitedEtablissementService service5=new VisitedEtablissementService();
        if (service5.count(1, 19)==1)
        {
            System.out.println("Ons a visité California");
        }
        else {
            System.out.println("Ons n'a pas visité California");
        }
        LikedEtablissementService service6=new LikedEtablissementService();
        
        if (service5.count(1, 19)==1)
        {
            System.out.println("Ons aime California");
        }
        else {
            System.out.println("Ons n'aime pas  California");
        }
        
        OffreService service7=new OffreService();
        Offre offre=service7.findById(1);
        System.out.println(offre.toString());
        service3.add(1, 19);
        if (service3.count(1, 19)==1)
        {
            System.out.println("Ons is going to "+e1.getNom());
        }
        else {
            System.out.println("Ons is not going to "+e1.getNom());
        }
        
        if (service4.count(1, 19)==1)
        {
            System.out.println("Ons is interested in "+e1.getNom());
        }
        else {
            System.out.println("Ons is not interested in "+e1.getNom());
        }
        
    }
    
}
