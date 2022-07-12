package ch.bbw.leandro.carvalho.autowerkstatt.verwaltung.auftrag;

import ch.bbw.leandro.carvalho.autowerkstatt.verwaltung.*;
import ch.bbw.leandro.carvalho.autowerkstatt.verwaltung.fahrzeug.kunde.Kundenfahrzeug;
import ch.bbw.leandro.carvalho.autowerkstatt.verwaltung.mitarbeiter.Mitarbeiter;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Diese Klasse hier dient als Controller für die Hauptseite der Aufträge.
 *
 * @author Leandro Filipe Lourenço Carvalho
 * @version 1.0
 */

public class AuftraegeController extends NavigationController {

    @FXML
    private VBox vBoxAuftraegePendent;
    @FXML
    private VBox vBoxAuftraegeErledigt;
    private MainApplication mainApplication;

    /**
     * Falls der Button zum Verwalten eines Auftrages gedrückt wird, wird diese Methode aufgerufen, welche das Verwaltungsfenster für diesen Auftrag aufruft.
     * @param auftrag Auftrag, welches verwaltet werden soll.
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
     * Hiermit soll die Liste aller pendenten Aufträge erstellt werden.
     */
    public void renderAuftraegePendent(){
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
                hBox.setPrefWidth(vBoxAuftraegePendent.getPrefWidth());
                hBox.setPrefHeight(50);
                vBoxAuftraegePendent.getChildren().add(hBox);
            }
        }
    }

    /**
     * Hiermit soll die Liste aller schon erledigten Aufträge erstellt werden.
     */
    public void renderAuftraegeErledigt(){
        Autogarage autogarage = new Autogarage("Test");
        autogarage.getData();
        for (Auftrag auftrag: autogarage.getAuftraege()) {
            if(auftrag.getStatus().equals("erledigt")){
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
                hBox.setPrefWidth(vBoxAuftraegeErledigt.getPrefWidth());
                hBox.setPrefHeight(50);
                vBoxAuftraegeErledigt.getChildren().add(hBox);
            }
        }
    }

    /**
     * Falls der Button zum Erfassen eines neuen Auftrages aufgerufen wird, wird das entsprechende Fenster in dieser Methode aufgerufen.
     * @param actionEvent
     */
    public void auftragErfassen(ActionEvent actionEvent) {
        try {
            Autogarage autogarage = new Autogarage("Test");
            autogarage.getData();
            Stage stage = mainApplication.getStage();
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("auftraege_erfassen.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            AuftraegeVerwaltungController controller = fxmlLoader.getController();
            controller.renderDropdowns();
            String css = this.getClass().getResource("/ch/bbw/leandro/carvalho/autowerkstatt/verwaltung/home.css").toExternalForm();
            scene.getStylesheets().add(css);
            stage.close();
            stage.setScene(scene);
            stage.setTitle("Aufträge | Erfassen");
            stage.setResizable(false);
            stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
