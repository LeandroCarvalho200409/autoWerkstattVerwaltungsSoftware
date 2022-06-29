package ch.bbw.leandro.carvalho.autowerkstatt.verwaltung;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * Diese Klasse dient als Controller für die GUIs der Kunden.
 *
 * @author Leandro Filipe Lourenço Carvalho
 * @version 1.0
 */

public class KundenController extends NavigationController{
    public VBox vBoxKunden;

    public Autogarage autogarage;

    /**
     * Hiermit wird die Seite zur Verwaltung eines Kunden aufgerufen.
     * @param kunde
     */
    private void kundeVerwalten(Kunde kunde) {

    }

    /**
     * Hiermit wird ein neuer Kunde erfasst.
     * @param actionEvent
     */
    private void kundeErfassen(ActionEvent actionEvent){

    }

    /**
     * Hiermit wird die Liste aller Kunden gefüllt
     */
    public void renderKunden(){
        Autogarage autogarage = new Autogarage("Test");
        autogarage.getData();
        for (Person p: autogarage.getPersonen()) {
            if(p instanceof Kunde){
                Kunde kunde = (Kunde) p;
                HBox hBox = new HBox();
                Label person = new Label("Name: "+kunde.getVorname()+" "+kunde.getName());
                Label geburtsdatum = new Label("Geburtsdatum: "+kunde.getGeburtsDatum().toString());
                Label email = new Label("E-Mail: "+kunde.getEmail());
                Label telefon = new Label("Telefon: "+kunde.getTelNummer());
                person.setPrefWidth(300);
                person.setPrefHeight(50);
                telefon.setPrefWidth(300);
                telefon.setPrefHeight(50);
                geburtsdatum.setPrefWidth(150);
                geburtsdatum.setPrefHeight(50);
                email.setPrefWidth(100);
                email.setPrefHeight(50);
                hBox.getChildren().add(person);
                hBox.getChildren().add(geburtsdatum);
                hBox.getChildren().add(email);
                hBox.getChildren().add(telefon);

                Button verwalten = new Button(">");
                verwalten.getStyleClass().add("verwaltenButton");
                verwalten.setPrefHeight(50);
                verwalten.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        kundeVerwalten(kunde);
                    }
                });
                hBox.getChildren().add(verwalten);
                hBox.setPrefWidth(vBoxKunden.getPrefWidth());
                hBox.setPrefHeight(50);
                vBoxKunden.getChildren().add(hBox);
            }
        }
    }
}
