package ch.bbw.leandro.carvalho.autowerkstatt.verwaltung;

import ch.bbw.leandro.carvalho.autowerkstatt.verwaltung.auftrag.AuftraegeVerwaltungController;
import ch.bbw.leandro.carvalho.autowerkstatt.verwaltung.auftrag.Auftrag;
import ch.bbw.leandro.carvalho.autowerkstatt.verwaltung.fahrzeug.Fahrzeug;
import ch.bbw.leandro.carvalho.autowerkstatt.verwaltung.fahrzeug.kunde.Kundenfahrzeug;
import ch.bbw.leandro.carvalho.autowerkstatt.verwaltung.fahrzeug.verkauf.Verkaufsfahrzeug;
import ch.bbw.leandro.carvalho.autowerkstatt.verwaltung.fahrzeug.verkauf.VerkaufsfahrzeugVerwaltungController;
import ch.bbw.leandro.carvalho.autowerkstatt.verwaltung.mitarbeiter.Mitarbeiter;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Diese Klasse hier dient als Controller für die Homepage.
 *
 * @author Leandro Filipe Lourenço Carvalho
 * @version 1.0
 */
public class MainController extends NavigationController implements Initializable {
    @FXML
    private VBox vBoxCarsPendent;

    @FXML
    private VBox vBoxCarsOnSale;

    private MainApplication mainApplication;

    /**
     * Beim Aufstarten dieses Controllers wird als erstes die initialize Methode aufgerufen, welche aus der Interface Initializable stammt.
     * @param url
     * @param resourceBundle
     */
    public void initialize(URL url, ResourceBundle resourceBundle){
        renderCarsPendent();
        renderCarsOnSale();
    }

    /**
     * Falls ein Button für die Verwaltung eines Auftrages geklickt wird, wird diese Methode aufgerufen, welche das Verwaltungsfenster aufruft.
     * @param auftrag Dies ist der Auftrag, welcher verwaltet werden soll.
     */
    public void auftragVerwalten(Auftrag auftrag){
        try {
            Autogarage autogarage = new Autogarage("Test");
            autogarage.getData();
            Stage stage = mainApplication.getStage();
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("auftraege_verwaltung.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            AuftraegeVerwaltungController controller = fxmlLoader.getController();
            controller.setAuftrag(auftrag);
            controller.fillupData();
            String css = this.getClass().getResource("home.css").toExternalForm();
            scene.getStylesheets().add(css);
            stage.close();
            stage.setScene(scene);
            stage.setTitle("Aufträge | Verwaltung");
            stage.setResizable(false);
            stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Diese Methode wird aufgerufen um ein Verkaufsfahrzeug zu verwalten. Diese Methode ruft das Verwaltungsfenster des entsprechenden Objektes auf.
     * @param verkaufsfahrzeug Dies ist der Fahrzeug, welcher verwaltet werden soll.
     */
    public void verkaufsfahrzeugVerwalten(Verkaufsfahrzeug verkaufsfahrzeug){
        try {
            Autogarage autogarage = new Autogarage("Test");
            autogarage.getData();
            Stage stage = mainApplication.getStage();
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("fahrzeug_verkauf_verwaltung.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            VerkaufsfahrzeugVerwaltungController controller = fxmlLoader.getController();
            controller.setFahrzeug(verkaufsfahrzeug);
            controller.fillupData();
            String css = this.getClass().getResource("home.css").toExternalForm();
            scene.getStylesheets().add(css);
            stage.close();
            stage.setScene(scene);
            stage.setTitle("Verkaufsfahrzeug | Verwaltung");
            stage.setResizable(false);
            stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Diese Methode erstellt die Liste aller Verkaufsfahrzeuge, welche noch nicht verkauft wurden.
     */
    public void renderCarsOnSale(){
        Autogarage autogarage = new Autogarage("Test");
        autogarage.getData();
        for(Fahrzeug f:autogarage.getFahrzeuge()){
            if(f instanceof Verkaufsfahrzeug){
                Verkaufsfahrzeug verkaufsfahrzeug = (Verkaufsfahrzeug) f;
                if(verkaufsfahrzeug.isVerkauft() == false){
                    HBox hBox = new HBox();
                    Label auto = new Label("Auto: "+verkaufsfahrzeug.getMarke()+" "+verkaufsfahrzeug.getModell());
                    Label jahrgang = new Label("Jahrgang: "+verkaufsfahrzeug.getErsteInverkehrssetzung().getYear());
                    Label preis = new Label("Verlangter Preis: CHF "+verkaufsfahrzeug.getPreis());
                    auto.setPrefWidth(300);
                    auto.setPrefHeight(50);
                    jahrgang.setPrefWidth(150);
                    jahrgang.setPrefHeight(50);
                    preis.setPrefWidth(100);
                    preis.setPrefHeight(50);
                    hBox.getChildren().add(auto);
                    hBox.getChildren().add(jahrgang);
                    hBox.getChildren().add(preis);

                    Button verwalten = new Button(">");
                    verwalten.getStyleClass().add("verwaltenButton");
                    verwalten.setPrefHeight(50);
                    verwalten.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            verkaufsfahrzeugVerwalten(verkaufsfahrzeug);
                        }
                    });
                    hBox.getChildren().add(verwalten);
                    hBox.setPrefWidth(vBoxCarsPendent.getPrefWidth());
                    hBox.setPrefHeight(50);
                    vBoxCarsOnSale.getChildren().add(hBox);
                }
            }
        }
    }

    /**
     * Diese Methode erstellt die Liste aller Aufträge, welche noch nicht abgeschlossen wurden.
     */
    public void renderCarsPendent(){
        Autogarage autogarage = new Autogarage("Test");
        autogarage.getData();
        for (Auftrag auftrag: autogarage.getAuftraege()) {
            if(!(auftrag.getStatus().equals("erledigt"))){
                Person auftraggeber = null;
                if(auftrag.getFahrzeug() instanceof Kundenfahrzeug){
                    Kundenfahrzeug kundenfahrzeug = (Kundenfahrzeug) auftrag.getFahrzeug();
                    auftraggeber = kundenfahrzeug.getBesitzer();
                }else{
                    for (Person person: autogarage.getPersonen()) {
                        if(person instanceof Mitarbeiter){
                            if (((Mitarbeiter) person).isGeschaeftsfuehrer()){
                                auftraggeber = person;
                            }
                        }
                    }
                }
                HBox hBox = new HBox();
                Label auto = new Label("Auto: "+auftrag.getFahrzeug().getMarke()+" "+auftrag.getFahrzeug().getModell());
                Label kunde = new Label("Kunde: "+auftraggeber.getVorname()+" "+auftraggeber.getName());
                Label status = new Label("Status: "+auftrag.getStatus());
                auto.setPrefWidth(300);
                auto.setPrefHeight(50);
                kunde.setPrefWidth(150);
                kunde.setPrefHeight(50);
                status.setPrefWidth(100);
                status.setPrefHeight(50);
                hBox.getChildren().add(auto);
                hBox.getChildren().add(kunde);
                hBox.getChildren().add(status);

                Button verwalten = new Button(">");
                verwalten.getStyleClass().add("verwaltenButton");
                verwalten.setPrefHeight(50);
                verwalten.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        auftragVerwalten(auftrag);
                    }
                });
                hBox.getChildren().add(verwalten);
                hBox.setPrefWidth(vBoxCarsPendent.getPrefWidth());
                hBox.setPrefHeight(50);
                vBoxCarsPendent.getChildren().add(hBox);
            }
        }
    }
}