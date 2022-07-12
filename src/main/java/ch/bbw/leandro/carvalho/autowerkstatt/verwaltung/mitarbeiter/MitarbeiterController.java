package ch.bbw.leandro.carvalho.autowerkstatt.verwaltung.mitarbeiter;

import ch.bbw.leandro.carvalho.autowerkstatt.verwaltung.Autogarage;
import ch.bbw.leandro.carvalho.autowerkstatt.verwaltung.NavigationController;
import ch.bbw.leandro.carvalho.autowerkstatt.verwaltung.Person;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * Diese Klasse hier dient als Controller für die Seite der Mitarbeiter.
 *
 * @author Leandro Filipe Lourenço Carvalho
 * @version 1.0
 */

public class MitarbeiterController extends NavigationController {
    public VBox vBoxMitarbeiter;

    public Autogarage autogarage;

    /**
     * Diese Methode wird gebraucht um ein Mitarbeiter zu verwalten.
     * @param mitarbeiter
     */
    private void mitarbeiterVerwalten(Mitarbeiter mitarbeiter) {

    }

    /**
     * Diese Methode füllt die Liste aller Mitarbeiter aus.
     */
    public void renderMitarbeiter(){
        Autogarage autogarage = new Autogarage("Test");
        autogarage.getData();
        for (Person p: autogarage.getPersonen()) {
            if(p instanceof Mitarbeiter){
                Mitarbeiter mitarbeiter = (Mitarbeiter) p;
                HBox hBox = new HBox();
                Label person = new Label("Name: "+mitarbeiter.getVorname()+" "+mitarbeiter.getName());
                Label geburtsdatum = new Label("Geburtsdatum: "+mitarbeiter.getGeburtsDatum().toString());
                Label position = new Label("Position: "+mitarbeiter.getFunktion());
                Label ferienTage = new Label("Ferientage: "+mitarbeiter.getFerienTage());
                person.setPrefWidth(300);
                person.setPrefHeight(50);
                ferienTage.setPrefWidth(300);
                ferienTage.setPrefHeight(50);
                geburtsdatum.setPrefWidth(150);
                geburtsdatum.setPrefHeight(50);
                position.setPrefWidth(100);
                position.setPrefHeight(50);
                hBox.getChildren().add(person);
                hBox.getChildren().add(geburtsdatum);
                hBox.getChildren().add(position);
                hBox.getChildren().add(ferienTage);

                Button verwalten = new Button(">");
                verwalten.getStyleClass().add("verwaltenButton");
                verwalten.setPrefHeight(50);
                verwalten.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        mitarbeiterVerwalten(mitarbeiter);
                    }
                });
                hBox.getChildren().add(verwalten);
                hBox.setPrefWidth(vBoxMitarbeiter.getPrefWidth());
                hBox.setPrefHeight(50);
                vBoxMitarbeiter.getChildren().add(hBox);
            }
        }
    }

    /**
     * Diese Methode bewirkt, dass ein User ein neuer Mitarbeiter erfassen darf.
     * @param actionEvent
     */
    public void mitarbeiterErfassen(ActionEvent actionEvent) {

    }
}
