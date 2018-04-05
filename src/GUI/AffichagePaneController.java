package GUI;

import entities.Etablissement;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import org.controlsfx.control.RangeSlider;
import services.implementation.EtablissementService;

public class AffichagePaneController implements Initializable {

    @FXML
    private GridPane Grid;
    @FXML
    private Pane Pane;
    @FXML
    private TextField RechNom;
    @FXML
    private Button Rechercher;
    @FXML
    private RangeSlider BMSlider;
    @FXML
    private Label MinValue;
    @FXML
    private Label MaxValue;
    @FXML
    private RadioButton HOASC;
    @FXML
    private RadioButton HFDESC;
    @FXML
    private Button Confirmer;
    @FXML
    private RadioButton BMASC;
    @FXML
    private RadioButton BMDESC;
    
    private final ToggleGroup TG = new ToggleGroup();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        EtablissementService ES = new EtablissementService();
        ArrayList<Etablissement> ESL = ES.Affiche();
        int i = -1;
        int j = 0;
        for (Etablissement E : ESL)
        {
            i++;
            VBox VB = new VBox();
            VB.setPadding(new Insets(0,10,0,10));
            File F = new File(E.getImage());
            Image I = new Image(F.toURI().toString());
            ImageView IV = new ImageView();
            IV.setImage(I);
            IV.setFitHeight(150);
            IV.setFitWidth(150);
            Hyperlink Nom1 = new Hyperlink(E.getNom());
            Nom1.setOnAction(new EventHandler<ActionEvent>() 
            {
            @Override
            public void handle(ActionEvent e)
            {
                try 
                {
                    int Id = E.getId();
                    FXMLLoader FL = new FXMLLoader(getClass().getResource("EtablissementVBox.fxml"));
                    Parent root = (Parent) FL.load();
                    EtablissementVBoxController EVC = FL.getController();
                    EVC.ShowEtablissement(Id);
                    Pane.getChildren().setAll(root);
                } 
                catch (IOException ex) 
                {
                    Logger.getLogger(AffichagePaneController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            });
            Nom1.setFont(Font.font("Verdana",FontWeight.BOLD,16));
            VB.setAlignment(Pos.BASELINE_CENTER);
            VB.getChildren().addAll(IV,Nom1);
            if (i == 4)
            {
                j++;
                i = 0;
            }
            Grid.add(VB, i, j);
        }
        BMSlider.highValueProperty().addListener(new ChangeListener<Number>()
                {
                    @Override
                    public void changed(ObservableValue<? extends Number> ov,
                    Number old_val, Number new_val) 
                    {
                        String T = Integer.toString(new_val.intValue());
                        MaxValue.setText(T + " DT");
                    }
                });
        BMSlider.lowValueProperty().addListener(new ChangeListener<Number>()
                {
                    @Override
                    public void changed(ObservableValue<? extends Number> ov,
                    Number old_val, Number new_val) 
                    {
                        String T = Integer.toString(new_val.intValue());
                        MinValue.setText(T + " DT");
                    }
                });
        HOASC.setUserData("HOASC");
        HFDESC.setUserData("HFDESC");
        BMASC.setUserData("BMASC");
        BMDESC.setUserData("BMDESC");
        HOASC.setToggleGroup(TG);
        HFDESC.setToggleGroup(TG);
        BMASC.setToggleGroup(TG);
        BMDESC.setToggleGroup(TG);
    }    

    @FXML
    private void RechercherParNom(ActionEvent event) 
    {
        String S = RechNom.getText();
        Button B = new Button("Button");
        EtablissementService ES = new EtablissementService();
        ArrayList<Etablissement> ESL = ES.FindByName(S);
        Grid.getChildren().clear();
        int i = -1;
        int j = 0;
        for (Etablissement E : ESL)
        {
            i++;
            VBox VB = new VBox();
            VB.setPadding(new Insets(10,10,10,10));
            File F = new File(E.getImage());
            Image I = new Image(F.toURI().toString());
            ImageView IV = new ImageView();
            IV.setImage(I);
            IV.setFitHeight(150);
            IV.setFitWidth(150);
            Hyperlink Nom1 = new Hyperlink(E.getNom());
            Nom1.setOnAction(new EventHandler<ActionEvent>() 
            {
            @Override
            public void handle(ActionEvent e)
            {
                try 
                {
                    int Id = E.getId();
                    FXMLLoader FL = new FXMLLoader(getClass().getResource("EtablissementVBox.fxml"));
                    Parent root = (Parent) FL.load();
                    EtablissementVBoxController EVC = FL.getController();
                    EVC.ShowEtablissement(Id);
                    Pane.getChildren().setAll(root);
                } 
                catch (IOException ex) 
                {
                    Logger.getLogger(AffichagePaneController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            });
            Nom1.setFont(Font.font("Verdana",FontWeight.BOLD,16));
            VB.setAlignment(Pos.BASELINE_CENTER);
            VB.getChildren().addAll(IV,Nom1);
            if (i == 4)
            {
                j++;
                i = 0;
            }
            Grid.add(VB, i, j);
        }
    }

    @FXML
    private void RPN(KeyEvent event) 
    {
        String S = RechNom.getText();
        Button B = new Button("Button");
        EtablissementService ES = new EtablissementService();
        ArrayList<Etablissement> ESL = ES.FindByName(S);
        Grid.getChildren().clear();
        int i = -1;
        int j = 0;
        for (Etablissement E : ESL)
        {
            i++;
            VBox VB = new VBox();
            VB.setPadding(new Insets(10,10,10,10));
            File F = new File(E.getImage());
            Image I = new Image(F.toURI().toString());
            ImageView IV = new ImageView();
            IV.setImage(I);
            IV.setFitHeight(150);
            IV.setFitWidth(150);
            Hyperlink Nom1 = new Hyperlink(E.getNom());
            Nom1.setOnAction(new EventHandler<ActionEvent>() 
            {
            @Override
            public void handle(ActionEvent e)
            {
                try 
                {
                    int Id = E.getId();
                    FXMLLoader FL = new FXMLLoader(getClass().getResource("EtablissementVBox.fxml"));
                    Parent root = (Parent) FL.load();
                    EtablissementVBoxController EVC = FL.getController();
                    EVC.ShowEtablissement(Id);
                    Pane.getChildren().setAll(root);
                } 
                catch (IOException ex) 
                {
                    Logger.getLogger(AffichagePaneController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            });
            Nom1.setFont(Font.font("Verdana",FontWeight.BOLD,16));
            VB.setAlignment(Pos.BASELINE_CENTER);
            VB.getChildren().addAll(IV,Nom1);
            if (i == 4)
            {
                j++;
                i = 0;
            }
            Grid.add(VB, i, j);
        }
    }

    @FXML
    private void RechercherParPara(ActionEvent event) 
    {
        int MaV = 100;
        int MiV = 0;
        String S = " ";
        if (BMSlider.highValueProperty().intValue()!=1)
        {
            MaV = BMSlider.highValueProperty().intValue();
            MiV = BMSlider.lowValueProperty().intValue();
        }
        if (TG.getSelectedToggle() != null )
        {
        S = TG.getSelectedToggle().getUserData().toString();
        }
        EtablissementService ES = new EtablissementService();
        ArrayList<Etablissement> ESL = ES.FindByParameters(S, MaV, MiV);
        Grid.getChildren().clear();
        int i = -1;
        int j = 0;
        for (Etablissement E : ESL)
        {
            i++;
            VBox VB = new VBox();
            VB.setPadding(new Insets(10,10,10,10));
            File F = new File(E.getImage());
            Image I = new Image(F.toURI().toString());
            ImageView IV = new ImageView();
            IV.setImage(I);
            IV.setFitHeight(150);
            IV.setFitWidth(150);
            Hyperlink Nom1 = new Hyperlink(E.getNom());
            Nom1.setOnAction(new EventHandler<ActionEvent>() 
            {
            @Override
            public void handle(ActionEvent e)
            {
                try 
                {
                    int Id = E.getId();
                    FXMLLoader FL = new FXMLLoader(getClass().getResource("EtablissementVBox.fxml"));
                    Parent root = (Parent) FL.load();
                    EtablissementVBoxController EVC = FL.getController();
                    EVC.ShowEtablissement(Id);
                    Pane.getChildren().setAll(root);
                } 
                catch (IOException ex) 
                {
                    Logger.getLogger(AffichagePaneController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            });
            Nom1.setFont(Font.font("Verdana",FontWeight.BOLD,16));
            VB.setAlignment(Pos.BASELINE_CENTER);
            VB.getChildren().addAll(IV,Nom1);
            if (i == 4)
            {
                j++;
                i = 0;
            }
            Grid.add(VB, i, j);
        }
    }
    
    
}
