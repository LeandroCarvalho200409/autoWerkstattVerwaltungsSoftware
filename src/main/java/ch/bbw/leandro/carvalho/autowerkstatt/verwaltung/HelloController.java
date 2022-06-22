package ch.bbw.leandro.carvalho.autowerkstatt.verwaltung;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private Label welcomeText;

    @FXML
    private VBox vBoxCarsPendent;

    public void initialize(URL url, ResourceBundle resourceBundle){
        renderCarsPendent();
    }

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public void auftragVerwalten(Auftrag auftrag){

    }

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
                verwalten.setPrefHeight(50);
                verwalten.setStyle("-fx-background-color:  #ffffffff; ");
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

    public void logout(){

    }

}