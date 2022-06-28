package ch.bbw.leandro.carvalho.autowerkstatt.verwaltung;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class AuftraegeVerwaltungController extends NavigationController{

    private Auftrag auftrag;

    private Autogarage autogarage;

    @FXML
    private MenuButton fahrzeugDropdown;

    @FXML
    private MenuButton ersatzteileDropdown;

    @FXML
    private MenuButton verantwortlichDropdown;

    @FXML
    private MenuButton mitarbeiterDropdown;

    @FXML
    private TextField fieldArt;

    @FXML
    private TextField fieldPreis;

    @FXML
    private TextField fieldStatus;

    @FXML
    private TextField fieldGebiet;

    @FXML
    private VBox ersatzteileList;

    @FXML
    private VBox gebieteList;

    @FXML
    private VBox mitarbeiterList;

    @FXML
    private DatePicker dateZuErledigenBis;

    public void setTextDropdownMenu(MenuButton menuButton, MenuItem menuItem){
        Label label = (Label) menuItem.getGraphic();
        menuButton.setText(label.getText());
    }

    public void removeMitarbeiter(Mitarbeiter mitarbeiter){
        auftrag.removeZustaendigeMitarbeiter(mitarbeiter);
    }

    public void removeGebiet(String gebiet){
        auftrag.removeGebietDesFahrzeuges(gebiet);
    }

    public void removeErsatzteil(Ersatzteil ersatzteil){
        auftrag.removeErsatzteil(ersatzteil);
    }

    public void fillupData(){
        this.autogarage = new Autogarage("Test");
        autogarage.getData();
        fahrzeugDropdown.setText("Fahrzeug: "+auftrag.getFahrzeug().getVehicleIdentificationNumber());
        for (Fahrzeug f:autogarage.getFahrzeuge()) {
            MenuItem menuItem = new MenuItem();
            Label menuItemText = new Label();
            menuItemText.setText("Fahrzeug: "+f.getVehicleIdentificationNumber());
            menuItemText.setPrefWidth(fahrzeugDropdown.getPrefWidth());
            menuItem.setGraphic(menuItemText);
            menuItem.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    setTextDropdownMenu(fahrzeugDropdown, menuItem);
                }
            });
            fahrzeugDropdown.getItems().add(menuItem);
        }
        fieldArt.setText(auftrag.getArt());
        fieldPreis.setText(""+auftrag.getPreis());
        for (Ersatzteil e:autogarage.getErsatzteile()) {
            MenuItem menuItem = new MenuItem();
            Label menuItemText = new Label();
            menuItemText.setText("Ersatzteil: "+e.getProduktNr());
            menuItemText.setPrefWidth(fahrzeugDropdown.getPrefWidth());
            menuItem.setGraphic(menuItemText);
            menuItem.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    setTextDropdownMenu(ersatzteileDropdown, menuItem);
                }
            });
            ersatzteileDropdown.getItems().add(menuItem);
        }
        for (Ersatzteil ersatzteil: auftrag.getErsatzteile()){
            HBox hBox = new HBox();
            hBox.setPrefWidth(ersatzteileList.getPrefWidth());
            hBox.setPrefHeight(40);
            Label text = new Label();
            text.setPrefHeight(hBox.getPrefHeight());
            text.setText(ersatzteil.getProduktNr());
            Button removeButton = new Button();
            removeButton.setPrefHeight(hBox.getPrefHeight());
            removeButton.setText("-");
            removeButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    removeErsatzteil(ersatzteil);
                }
            });
            hBox.getChildren().add(text);
            hBox.getChildren().add(removeButton);
            ersatzteileList.getChildren().add(hBox);
        }
        fieldStatus.setText(auftrag.getStatus());
        dateZuErledigenBis.setValue(auftrag.getZuErledigenBis());
        verantwortlichDropdown.setText("Verantwortlich: "+auftrag.getVerantwortlicheMitarbeiter().getBenutzername());
        for (Person person:autogarage.getPersonen()) {
            if(person instanceof Mitarbeiter){
                Mitarbeiter mitarbeiter = (Mitarbeiter) person;
                Label menuItemText = new Label();
                MenuItem menuItem = new MenuItem();
                menuItemText.setText("Mitarbeiter: "+mitarbeiter.getBenutzername());
                menuItemText.setPrefWidth(fahrzeugDropdown.getPrefWidth());
                menuItem.setGraphic(menuItemText);
                menuItem.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        setTextDropdownMenu(verantwortlichDropdown, menuItem);
                    }
                });
                verantwortlichDropdown.getItems().add(menuItem);
            }
        }
        for (Person person:autogarage.getPersonen()) {
            if(person instanceof Mitarbeiter){
                Mitarbeiter mitarbeiter = (Mitarbeiter) person;
                Label menuItemText = new Label();
                MenuItem menuItem = new MenuItem();
                menuItemText.setText("Mitarbeiter: "+mitarbeiter.getBenutzername());
                menuItemText.setPrefWidth(fahrzeugDropdown.getPrefWidth());
                menuItem.setGraphic(menuItemText);
                menuItem.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        setTextDropdownMenu(mitarbeiterDropdown, menuItem);
                    }
                });
                mitarbeiterDropdown.getItems().add(menuItem);
            }
        }
        for (Mitarbeiter mitarbeiter: auftrag.getZustaendigeMitarbeiter()){
            HBox hBox = new HBox();
            hBox.setPrefWidth(mitarbeiterList.getPrefWidth());
            hBox.setPrefHeight(40);
            Label text = new Label();
            text.setPrefHeight(hBox.getPrefHeight());
            text.setText(mitarbeiter.getBenutzername());
            Button removeButton = new Button();
            removeButton.setPrefHeight(hBox.getPrefHeight());
            removeButton.setText("-");
            removeButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    removeMitarbeiter(mitarbeiter);
                }
            });
            hBox.getChildren().add(text);
            hBox.getChildren().add(removeButton);
            mitarbeiterList.getChildren().add(hBox);
        }
        for (String gebiet: auftrag.getGebieteDesFahrzeuges()){
            HBox hBox = new HBox();
            hBox.setPrefWidth(gebieteList.getPrefWidth());
            hBox.setPrefHeight(40);
            Label text = new Label();
            text.setPrefHeight(hBox.getPrefHeight());
            text.setText(gebiet);
            Button removeButton = new Button();
            removeButton.setPrefHeight(hBox.getPrefHeight());
            removeButton.setText("-");
            removeButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    removeGebiet(gebiet);
                }
            });
            hBox.getChildren().add(text);
            hBox.getChildren().add(removeButton);
            gebieteList.getChildren().add(hBox);
        }
    }

    public void setAuftrag(Auftrag auftrag){
        this.auftrag = auftrag;
    }

    public void renderListGebiete(){
        autogarage.getData();
        for (String gebiet: auftrag.getGebieteDesFahrzeuges()){
            HBox hBox = new HBox();
            hBox.setPrefWidth(gebieteList.getPrefWidth());
            hBox.setPrefHeight(40);
            Label text = new Label();
            text.setPrefHeight(hBox.getPrefHeight());
            text.setText(gebiet);
            Button removeButton = new Button();
            removeButton.setPrefHeight(hBox.getPrefHeight());
            removeButton.setText("-");
            removeButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    removeGebiet(gebiet);
                }
            });
            hBox.getChildren().add(text);
            hBox.getChildren().add(removeButton);
            gebieteList.getChildren().add(hBox);
        }
    }

    public void renderListMitarbeiter(){
        autogarage.getData();
        for (Mitarbeiter mitarbeiter: auftrag.getZustaendigeMitarbeiter()){
            HBox hBox = new HBox();
            hBox.setPrefWidth(mitarbeiterList.getPrefWidth());
            hBox.setPrefHeight(40);
            Label text = new Label();
            text.setPrefHeight(hBox.getPrefHeight());
            text.setText(mitarbeiter.getBenutzername());
            Button removeButton = new Button();
            removeButton.setPrefHeight(hBox.getPrefHeight());
            removeButton.setText("-");
            removeButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    removeMitarbeiter(mitarbeiter);
                }
            });
            hBox.getChildren().add(text);
            hBox.getChildren().add(removeButton);
            mitarbeiterList.getChildren().add(hBox);
        }
    }

    public void renderListErsatzteile(){
        autogarage.getData();
        for (Ersatzteil ersatzteil: auftrag.getErsatzteile()){
            HBox hBox = new HBox();
            hBox.setPrefWidth(ersatzteileList.getPrefWidth());
            hBox.setPrefHeight(40);
            Label text = new Label();
            text.setPrefHeight(hBox.getPrefHeight());
            text.setText(ersatzteil.getProduktNr());
            Button removeButton = new Button();
            removeButton.setPrefHeight(hBox.getPrefHeight());
            removeButton.setText("-");
            removeButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    removeErsatzteil(ersatzteil);
                }
            });
            hBox.getChildren().add(text);
            hBox.getChildren().add(removeButton);
            ersatzteileList.getChildren().add(hBox);
        }
    }

    public void addMitarbeiter(ActionEvent actionEvent) {
        String[] stringParts = mitarbeiterDropdown.getText().split(": ");
        String benutzername = stringParts[1];
        int indexAuftrag = 0;
        for (Person p: autogarage.getPersonen()) {
            if(p instanceof Mitarbeiter){
                Mitarbeiter mitarbeiter = (Mitarbeiter) p;
                if(mitarbeiter.getBenutzername().equals(benutzername)){
                    for (int i=0; i<autogarage.getAuftraege().size(); i++) {
                        if(autogarage.getAuftraege().get(i).getAuftragNr() == auftrag.getAuftragNr()){
                            autogarage.getAuftraege().get(i).setZustaendigeMitarbeiter(mitarbeiter);
                            indexAuftrag = i;
                        }
                    }
                }
            }
            autogarage.saveData();
            auftrag = autogarage.getAuftraege().get(indexAuftrag);
            renderListMitarbeiter();
        }
    }

    public void addGebiet(ActionEvent actionEvent) {
        String gebiet = fieldGebiet.getText();
        int indexAuftrag = 0;
        for (int i = 0; i < autogarage.getAuftraege().size(); i++) {
            if (autogarage.getAuftraege().get(i).getAuftragNr() == auftrag.getAuftragNr()) {
                autogarage.getAuftraege().get(i).setGebietDesFahrzeuges(gebiet);
                indexAuftrag = i;
            }
        }
        autogarage.saveData();
        autogarage.getData();
        auftrag = autogarage.getAuftraege().get(indexAuftrag);
        renderListGebiete();
    }

    public void addErsatzteil(ActionEvent actionEvent) {
        String[] stringParts = ersatzteileDropdown.getText().split(": ");
        String produktNr = stringParts[1];
        int indexAuftrag = 0;
        for (Ersatzteil e: autogarage.getErsatzteile()) {
            if (e.getProduktNr().equals(produktNr)) {
                for (int i = 0; i < autogarage.getAuftraege().size(); i++) {
                    if (autogarage.getAuftraege().get(i).getAuftragNr() == auftrag.getAuftragNr()) {
                        autogarage.getAuftraege().get(i).setErsatzteil(e);
                        indexAuftrag = i;
                    }
                }
            }
        }
        autogarage.saveData();
        autogarage.getData();
        auftrag = autogarage.getAuftraege().get(indexAuftrag);
        renderListErsatzteile();
    }

    public void save(ActionEvent actionEvent) {
        int indexAuftrag = 0;
        for (int i = 0; i < autogarage.getAuftraege().size(); i++) {
            if (autogarage.getAuftraege().get(i).getAuftragNr() == auftrag.getAuftragNr()) {
                indexAuftrag = i;
            }
        }
        if(!auftrag.getArt().equals(fieldArt.getText())){
            autogarage.getAuftraege().get(indexAuftrag).setArt(fieldArt.getText());
        }
        if(!(auftrag.getPreis() == Integer.parseInt(fieldPreis.getText()))){
            autogarage.getAuftraege().get(indexAuftrag).setPreis(Integer.parseInt(fieldPreis.getText()));
        }
        if(!auftrag.getStatus().equals(fieldStatus.getText())){
            autogarage.getAuftraege().get(indexAuftrag).setStatus(fieldStatus.getText());
        }
        if(!(auftrag.getZuErledigenBis() == dateZuErledigenBis.getValue())){
            autogarage.getAuftraege().get(indexAuftrag).setZuErledigenBis(dateZuErledigenBis.getValue());
        }
        String[] stringParts = fahrzeugDropdown.getText().split(": ");
        String vin = stringParts[1];
        String[] stringParts1 = verantwortlichDropdown.getText().split(": ");
        String benutzername = stringParts[1];
        if(!(auftrag.getVerantwortlicheMitarbeiter().getBenutzername().equals(benutzername))){
            for (Person p: autogarage.getPersonen()) {
                if(p instanceof Mitarbeiter){
                    Mitarbeiter mitarbeiter = (Mitarbeiter) p;
                    if(mitarbeiter.getBenutzername().equals(benutzername)){
                        autogarage.getAuftraege().get(indexAuftrag).setVerantwortlicheMitarbeiter(mitarbeiter);
                    }
                }
            }
        }
        if(!(auftrag.getFahrzeug().getVehicleIdentificationNumber().equals(vin))){
            for (Fahrzeug fahrzeug:autogarage.getFahrzeuge()) {
                if(fahrzeug.getVehicleIdentificationNumber().equals(vin)){
                    autogarage.getAuftraege().get(indexAuftrag).setFahrzeug(fahrzeug);
                }
            }
        }
        autogarage.saveData();
        auftrag = autogarage.getAuftraege().get(indexAuftrag);
    }

    public void removeAuftrag(ActionEvent actionEvent) {
        int indexAuftrag = 0;
        for (int i = 0; i < autogarage.getAuftraege().size(); i++) {
            if (autogarage.getAuftraege().get(i).getAuftragNr() == auftrag.getAuftragNr()) {
                indexAuftrag = i;
            }
        }
        autogarage.getAuftraege().remove(indexAuftrag);
        autogarage.saveData();
    }
}
