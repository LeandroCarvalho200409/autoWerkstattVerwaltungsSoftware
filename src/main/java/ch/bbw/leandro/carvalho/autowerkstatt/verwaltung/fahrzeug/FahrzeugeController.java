package ch.bbw.leandro.carvalho.autowerkstatt.verwaltung.fahrzeug;

import ch.bbw.leandro.carvalho.autowerkstatt.verwaltung.*;
import ch.bbw.leandro.carvalho.autowerkstatt.verwaltung.auftrag.AuftraegeVerwaltungController;
import ch.bbw.leandro.carvalho.autowerkstatt.verwaltung.auftrag.Auftrag;
import ch.bbw.leandro.carvalho.autowerkstatt.verwaltung.fahrzeug.kunde.Kundenfahrzeug;
import ch.bbw.leandro.carvalho.autowerkstatt.verwaltung.fahrzeug.verkauf.Verkaufsfahrzeug;
import ch.bbw.leandro.carvalho.autowerkstatt.verwaltung.fahrzeug.verkauf.VerkaufsfahrzeugVerwaltungController;
import ch.bbw.leandro.carvalho.autowerkstatt.verwaltung.mitarbeiter.Mitarbeiter;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.IOException;


/**
 * Diese Klasse dient als Controller für die Hauptseite der Fahrzeuge.
 *
 * @author Leandro Filipe Lourenço Carvalho
 * @version 1.0
 */

public class FahrzeugeController extends NavigationController {

    private MainApplication mainApplication;

    @FXML
    private VBox vBoxCarsPendent;

    @FXML
    private VBox vBoxCarsSold;

    @FXML
    private VBox vBoxCarsSalePendent;

    @FXML
    private VBox vBoxCarsKunden;

    /**
     * Beim aufruf dieser Methode wird die Seite zum Verwalten des Auftrages aufgerufen.
     * @param auftrag
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
            String css = this.getClass().getResource("/ch/bbw/leandro/carvalho/autowerkstatt/verwaltung/home.css").toExternalForm();
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
     * Mit dem Aufruf dieser Methode wird die Liste der pendenten Aufträge ausgefüllt.
     */
    public void renderCarsPendent(){
        Autogarage autogarage = new Autogarage("Test");
        autogarage.getData();
        for (Auftrag auftrag: autogarage.getAuftraege()) {
            if(!(auftrag.getStatus().equals("fertig"))){
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

    /**
     * Beim klicken des Buttons wird diese Methode aufgerufen, welche die Seite für die Verkaufsfahrzeuge öffnet.
     */
    public void openVerkauf(){
        try {
            Autogarage autogarage = new Autogarage("Test");
            autogarage.getData();
            Stage stage = mainApplication.getStage();
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("fahrzeug_verkauf.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            FahrzeugeController controller = fxmlLoader.getController();
            controller.renderCarSoldPendent();
            controller.renderCarsSold();
            String css = this.getClass().getResource("/ch/bbw/leandro/carvalho/autowerkstatt/verwaltung/home.css").toExternalForm();
            scene.getStylesheets().add(css);
            stage.setScene(scene);
            stage.setTitle("Fahrzeuge | Verkauf");
            stage.setResizable(false);
            stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Beim klicken des Buttons wird diese Methode aufgerufen, welche die Seite für die Kundenfahrzeuge öffnet.
     */
    public void openKundenFZ(){
        try {
            Autogarage autogarage = new Autogarage("Test");
            autogarage.getData();
            Stage stage = mainApplication.getStage();
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("fahrzeug_kunde.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            FahrzeugeController controller = fxmlLoader.getController();
            controller.renderCarsKunden();
            String css = this.getClass().getResource("/ch/bbw/leandro/carvalho/autowerkstatt/verwaltung/home.css").toExternalForm();
            scene.getStylesheets().add(css);
            stage.setScene(scene);
            stage.setTitle("Fahrzeuge | Kunden");
            stage.setResizable(false);
            stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Mit dieser Methode soll es möglich sein, ein neues Fahrzeug, nach dem Aufruf der entsprechenden Seite zu erfassen.
     * @param actionEvent
     */
    @FXML
    public void openFahrzeugErfassen(ActionEvent actionEvent) {
        try {
            Autogarage autogarage = new Autogarage("Test");
            autogarage.getData();
            Stage stage = mainApplication.getStage();
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("fahrzeug_verkauf_erfassen.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            VerkaufsfahrzeugVerwaltungController controller = fxmlLoader.getController();
            controller.renderKundeDropdown();
            String css = this.getClass().getResource("/ch/bbw/leandro/carvalho/autowerkstatt/verwaltung/home.css").toExternalForm();
            scene.getStylesheets().add(css);
            stage.setScene(scene);
            stage.setTitle("Fahrzeuge | Verkauf");
            stage.setResizable(false);
            stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Nach dem Aufrufen dieser Methode wird die Seite zum Verwalten der Verkaufsfahrzeuge geöffnet.
     * @param verkaufsfahrzeug
     */
    private void verkaufsfahrzeugVerwalten(Verkaufsfahrzeug verkaufsfahrzeug) {
        try {
            Autogarage autogarage = new Autogarage("Test");
            autogarage.getData();
            Stage stage = mainApplication.getStage();
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("fahrzeug_verkauf_verwaltung.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            VerkaufsfahrzeugVerwaltungController controller = fxmlLoader.getController();
            controller.setFahrzeug(verkaufsfahrzeug);
            controller.fillupData();
            String css = this.getClass().getResource("/ch/bbw/leandro/carvalho/autowerkstatt/verwaltung/home.css").toExternalForm();
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
     * Nach dem Aufrufen dieser Methode wird die Seite zum Verwalten der Kundenfahrzeuge geöffnet.
     * @param kundenFahrzeug
     */
    private void kundenFahrzeugVerwalten(Kundenfahrzeug kundenFahrzeug) {

    }

    /**
     * Beim Aufruf dieser Methode wird die Liste der noch nicht verkauften Autos gefüllt.
     */
    public void renderCarSoldPendent(){
        Autogarage autogarage = new Autogarage("Test");
        autogarage.getData();
        for (Fahrzeug fahrzeug:autogarage.getFahrzeuge()) {
            if(fahrzeug instanceof Verkaufsfahrzeug){
                Verkaufsfahrzeug verkaufsfahrzeug = (Verkaufsfahrzeug) fahrzeug;
                if(!(verkaufsfahrzeug.isVerkauft())){
                    HBox hBox = new HBox();
                    Label auto = new Label("Auto: "+verkaufsfahrzeug.getMarke()+" "+verkaufsfahrzeug.getModell());
                    Label jahrgang = new Label("Jahrgang: "+verkaufsfahrzeug.getErsteInverkehrssetzung().getYear());
                    Label preis = new Label("Verlangter Preis: CHF "+verkaufsfahrzeug.getPreis());
                    auto.setPrefWidth(300);
                    auto.setPrefHeight(50);
                    jahrgang.setPrefWidth(150);
                    jahrgang.setPrefHeight(50);
                    preis.setPrefWidth(150);
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
                    hBox.setPrefWidth(vBoxCarsSalePendent.getPrefWidth());
                    hBox.setPrefHeight(50);
                    vBoxCarsSalePendent.getChildren().add(hBox);
                }
            }
        }
    }

    /**
     * Mit dem Aufruf dieser Methode wird die Liste der bereits verkauften Autos gefüllt.
     */
    public void renderCarsSold(){
        Autogarage autogarage = new Autogarage("Test");
        autogarage.getData();
        for (Fahrzeug fahrzeug:autogarage.getFahrzeuge()) {
            if(fahrzeug instanceof Verkaufsfahrzeug){
                Verkaufsfahrzeug verkaufsfahrzeug = (Verkaufsfahrzeug) fahrzeug;
                if(verkaufsfahrzeug.isVerkauft()){
                    HBox hBox = new HBox();
                    Label auto = new Label("Auto: "+verkaufsfahrzeug.getMarke()+" "+verkaufsfahrzeug.getModell());
                    Label jahrgang = new Label("Jahrgang: "+verkaufsfahrzeug.getErsteInverkehrssetzung().getYear());
                    Label verkauft = new Label("Verkauft: "+verkaufsfahrzeug.getVerkauftAn().toString());
                    Label preis = new Label("Preis: CHF "+verkaufsfahrzeug.getPreis());
                    verkauft.setPrefWidth(300);
                    verkauft.setPrefHeight(50);
                    auto.setPrefWidth(300);
                    auto.setPrefHeight(50);
                    jahrgang.setPrefWidth(150);
                    jahrgang.setPrefHeight(50);
                    preis.setPrefWidth(100);
                    preis.setPrefHeight(50);
                    hBox.getChildren().add(auto);
                    hBox.getChildren().add(jahrgang);
                    hBox.getChildren().add(verkauft);
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
                    hBox.setPrefWidth(vBoxCarsSold.getPrefWidth());
                    hBox.setPrefHeight(50);
                    vBoxCarsSold.getChildren().add(hBox);
                }
            }
        }
    }

    /**
     * Beim Aufruf dieser Methode wird die Liste aller Fahrzeuge von den Kunden gefüllt.
     */
    public void renderCarsKunden(){
        Autogarage autogarage = new Autogarage("Test");
        autogarage.getData();
        for (Fahrzeug fahrzeug:autogarage.getFahrzeuge()) {
            if(fahrzeug instanceof Kundenfahrzeug){
                Kundenfahrzeug kundenFahrzeug = (Kundenfahrzeug) fahrzeug;
                HBox hBox = new HBox();
                Label auto = new Label("Auto: "+kundenFahrzeug.getMarke()+" "+kundenFahrzeug.getModell());
                Label jahrgang = new Label("Jahrgang: "+kundenFahrzeug.getErsteInverkehrssetzung().getYear());
                Label besitzer = new Label("Besitzer: "+kundenFahrzeug.getBesitzer().getVorname()+" "+kundenFahrzeug.getBesitzer().getName());
                besitzer.setPrefWidth(300);
                besitzer.setPrefHeight(50);
                auto.setPrefWidth(300);
                auto.setPrefHeight(50);
                jahrgang.setPrefWidth(150);
                jahrgang.setPrefHeight(50);
                hBox.getChildren().add(auto);
                hBox.getChildren().add(jahrgang);
                hBox.getChildren().add(besitzer);

                Button verwalten = new Button(">");
                verwalten.getStyleClass().add("verwaltenButton");
                verwalten.setPrefHeight(50);
                verwalten.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                            kundenFahrzeugVerwalten(kundenFahrzeug);
                        }
                });
                hBox.getChildren().add(verwalten);
                hBox.setPrefWidth(vBoxCarsKunden.getPrefWidth());
                hBox.setPrefHeight(50);
                vBoxCarsKunden.getChildren().add(hBox);
            }
        }
    }
}
