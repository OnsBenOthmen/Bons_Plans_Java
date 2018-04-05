package GUI;

import com.jfoenix.controls.JFXDatePicker;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import entities.Etablissement;
import java.io.File;
import java.net.URL;
import java.time.LocalTime;
import java.util.ResourceBundle;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import services.implementation.EtablissementService;

public class EtablissementController implements Initializable 
{
    
    ObservableList<String> TypeItems = FXCollections.observableArrayList("Restaurants/Cafés","Boutiques","Hotels","Autres");
    ObservableList<String> Type1RItems = FXCollections.observableArrayList("Restaurant","Café","Fast-Food","Salon De Thé","Bar","Boite De Nuit","Glacier","Autre");
    ObservableList<String> Type1LItems = FXCollections.observableArrayList("Cinéma","Salle De Sport","Parc D'Attraction","Spa","Salon De Coiffure","Salle De Jeux","Autre");
    ObservableList<String> Type1BItems = FXCollections.observableArrayList("Grande Surface","Parfumerie","Parc D'Attraction","Boutique","Librairie","Fleuriste","Candy Shop","Autre");
    ObservableList<String> Type1HItems = FXCollections.observableArrayList("*","* *","* * *","* * * *","* * * * *");
    
    @FXML
    private ChoiceBox Type;
    @FXML
    private Button Image;
    @FXML
    private Label Path;
    @FXML
    private ChoiceBox Type1;
    @FXML
    private Button Submit;
    @FXML
    private TextField Nom;
    @FXML
    private TextField Adresse;
    @FXML
    private TextArea Description;
    @FXML
    private TextField Numero;
    @FXML
    private TextField SiteWeb;
    @FXML
    private TextField BudgetMoyen;
    @FXML
    private JFXDatePicker HoraireOuverture;
    @FXML
    private JFXDatePicker HoraireFermeture;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        Type.setItems(TypeItems);
    }

    @FXML
    private void ChoisirImage(ActionEvent event) 
    {
        final Stage stage = null;
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        File file = fileChooser.showOpenDialog(stage);
        if (file != null)
        {
            String path = file.getAbsolutePath();
            Path.setText(path);
        }
    }
    
    @FXML
    private void ChoisirType(ActionEvent event) 
    {
        String T = Type.getValue().toString();
        if (T == "Restaurants/Cafés")
        {
            Type1.setVisible(true);
            Type1.setItems(Type1RItems);
        }
        if (T == "Boutiques")
        {
            Type1.setVisible(true);
            Type1.setItems(Type1BItems);
        }
        if (T == "Hotels")
        {
            Type1.setVisible(true);
            Type1.setItems(Type1HItems);
        }
        if (T == "Autres")
        {
            Type1.setVisible(true);
            Type1.setItems(Type1LItems);
        }
    }

    @FXML
    private void Submit(ActionEvent event) 
    {
        EtablissementService ES = new EtablissementService();
        Integer N = Integer.parseInt(Numero.getText());
        Integer B = Integer.parseInt(BudgetMoyen.getText());
        ES.Ajout(
                Nom.getText(),
                Type.getValue().toString(),
                Adresse.getText(),
                Description.getText(),
                HoraireOuverture.getTime().toString(),
                HoraireFermeture.getTime().toString(),
                N,
                SiteWeb.getText(),
                B,
                Type1.getValue().toString(),
                Path.getText());
    }
    
    public void ModifEtablissement(int Id)
    {
        EtablissementService ES = new EtablissementService();
        Etablissement E = ES.findById(Id);
        Nom.setText(E.getNom());
        Type.setValue(E.getType());
        String S = E.getType();
        if (S.equals("Restaurants/Cafés"))
                {
                    Type1.setValue(E.getType_resto());
                }
        if (S.equals("Boutiques"))
                {
                    Type1.setValue(E.getType_shops());
                }
        if (S.equals("Hotels"))
                {
                    Type1.setValue(E.getNbrStars());
                }
        if (S.equals("Autres"))
                {
                    Type1.setValue(E.getType_loisirs());
                }
        Adresse.setText(E.getAdresse());
        Description.setText(E.getDescription());
        LocalTime LTO = LocalTime.parse(E.getHoraire_ouverture());
        LocalTime LTF = LocalTime.parse(E.getHoraire_fermeture());
        HoraireOuverture.setTime(LTO);
        HoraireFermeture.setTime(LTF);
        Numero.setText(Integer.toString(E.getNumtel()));
        SiteWeb.setText(E.getUrl());
        BudgetMoyen.setText(Integer.toString(E.getBudgetmoyen()));
        Path.setText(E.getImage());
        Submit.setText("Modifier Les Informations De " + E.getNom());
        Submit.setOnAction(new EventHandler<ActionEvent>() 
        {
        @Override 
        public void handle(ActionEvent e) 
        {
        EtablissementService ES = new EtablissementService();
        Integer N = Integer.parseInt(Numero.getText());
        Integer B = Integer.parseInt(BudgetMoyen.getText());
        ES.Modif(
                E.getId(),
                Nom.getText(),
                Type.getValue().toString(),
                Type1.getValue().toString(),
                Adresse.getText(),
                Description.getText(),
                HoraireOuverture.getTime().toString(),
                HoraireFermeture.getTime().toString(),
                N,
                SiteWeb.getText(),
                B,
                Path.getText());
        }
        });
    }
    
}
