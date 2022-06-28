package ch.bbw.leandro.carvalho.autowerkstatt.verwaltung;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ErsatzteileController extends NavigationController {
    @FXML
    private VBox vBoxErsatzteile;
    private Autogarage autogarage;
    private HelloApplication helloApplication;

    private void ersatzteilVerwalten(Ersatzteil ersatzteil) {
    }

    public void renderErsatzteile() {
        Autogarage autogarage = new Autogarage("Test");
        autogarage.getData();
        for (Ersatzteil ersatzteil : autogarage.getErsatzteile()) {
            HBox hBox = new HBox();
            Label ersatzteilText = new Label("Ersatzteil: " + ersatzteil.getProduktNr() + " " + ersatzteil.getName());
            Label marke = new Label("Marke: " + ersatzteil.getMarke());
            Label anzAufLager = new Label("Anzahl auf Lager: " + ersatzteil.getAnzAufLager());
            Label anwendung = new Label("Anwendung: " + ersatzteil.getAnwendung());
            ersatzteilText.setPrefWidth(300);
            ersatzteilText.setPrefHeight(50);
            anwendung.setPrefWidth(300);
            anwendung.setPrefHeight(50);
            marke.setPrefWidth(150);
            marke.setPrefHeight(50);
            anzAufLager.setPrefWidth(100);
            anzAufLager.setPrefHeight(50);
            hBox.getChildren().add(ersatzteilText);
            hBox.getChildren().add(marke);
            hBox.getChildren().add(anzAufLager);
            hBox.getChildren().add(anwendung);

            Button verwalten = new Button(">");
            verwalten.getStyleClass().add("verwaltenButton");
            verwalten.setPrefHeight(50);
            verwalten.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    ersatzteilVerwalten(ersatzteil);
                }
            });
            hBox.getChildren().add(verwalten);
            hBox.setPrefWidth(vBoxErsatzteile.getPrefWidth());
            hBox.setPrefHeight(50);
            vBoxErsatzteile.getChildren().add(hBox);
        }
    }

    public void ersatzteilErfassen(ActionEvent actionEvent) {
    }
}
