package ch.bbw.leandro.carvalho.autowerkstatt.verwaltung;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * Diese Klasse hier dient als Controller für die Verwaltung der Aufträge.
 *
 * @author Leandro Filipe Lourenço Carvalho
 * @version 1.0
 */
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

    public int getFieldPreis(){
        return Integer.parseInt(fieldPreis.getText());
    }

    /**
     * Diese Methode wird generell gebraucht um den Text eines MenuButtons zu ändern.
     * @param menuButton
     * @param menuItem Von hier wird der Text für das MenuButton hergeholt.
     */
    public void setTextDropdownMenu(MenuButton menuButton, MenuItem menuItem){
        Label label = (Label) menuItem.getGraphic();
        menuButton.setText(label.getText());
    }

    /**
     * Diese Methode wird gebraucht um ein zuständiger Mitarbeiter von einem Auftrag zu entfernen.
     * @param mitarbeiter Mitarbeiter, welcher entfernt werden soll.
     */
    public void removeMitarbeiter(Mitarbeiter mitarbeiter){
        auftrag.removeZustaendigeMitarbeiter(mitarbeiter);
    }

    /**
     * Wird gebraucht um ein Gebiet von einem Auftrag zu entfernen.
     * @param gebiet
     */
    public void removeGebiet(String gebiet){
        auftrag.removeGebietDesFahrzeuges(gebiet);
    }

    /**
     * Wird gebraucht um ein bestimmter Ersatzteil von einem Auftrag zu entfernen.
     * @param ersatzteil
     */
    public void removeErsatzteil(Ersatzteil ersatzteil){
        auftrag.removeErsatzteil(ersatzteil);
    }

    /**
     * Hiermit werden die Daten aus einem Auftrag eingelesen und in die entsprechenden Felder für dessen Verwaltung gesetzt.
     */
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

    /**
     * Hiermit werden die MenuItems der einzelnen DropdownMenus erstellt. Diese Methode wird vor allem zum Erstellen eines Auftrages gebraucht.
     */
    public void renderDropdowns(){
        this.autogarage = new Autogarage("Test");
        autogarage.getData();
        verantwortlichDropdown.setText("Verantwortlich: ");
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
        fahrzeugDropdown.setText("Fahrzeug: ");
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
    }

    /**
     * Hiermit wird der Auftrag für die Verwaltung gesetzt.
     * @param auftrag
     */
    public void setAuftrag(Auftrag auftrag){
        this.auftrag = auftrag;
    }

    /**
     * Hiermit werden die Daten für die Liste der Gebiete, inklusive einem Button für dessen Eliminierung erstellt und zur Liste hinzugefügt.
     */
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

    /**
     * Hiermit werden die Daten für die Liste der Mitarbeiter, inklusive einem Button für dessen Eliminierung erstellt und zur Liste hinzugefügt.
     */
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

    /**
     * Hiermit werden die Daten für die Liste der Ersatzteile, inklusive einem Button für dessen Eliminierung erstellt und zur Liste hinzugefügt.
     */
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

    /**
     * Hiermit wird ein neuer Mitarbeiter zur Liste der zuständigen Mitarbeiter eingefügt.
     * @param actionEvent
     */
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

    /**
     * Mit dieser Methode wird ein neuer Gebiet des Fahrzeuges in die respektive Liste eingefügt.
     * @param actionEvent
     */
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

    /**
     * Hiermit wird ein neues Ersatzteil der Liste der gebrauchten Ersatzteilen hinzugefügt.
     * @param actionEvent
     */
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

    /**
     * Mithilfe dieser Methode werden die neuen Daten für ein schon existierender Auftrag aktualisiert.
     * @param actionEvent
     */
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

    /**
     * Mithilfe dieser Methode werden die Daten für ein neuer Auftrag abgeholt und somit wird auch ein neuer Auftrag erstellt.
     */
    public void saveNewAuftrag(){
        String[] stringParts = fahrzeugDropdown.getText().split(": ");
        String vin = stringParts[1];
        String[] stringParts1 = verantwortlichDropdown.getText().split(": ");
        String benutzername = stringParts[1];
        Fahrzeug fahrzeugAuftrag = null;
        Mitarbeiter verantwortlich = null;

        for (Fahrzeug fahrzeug:autogarage.getFahrzeuge()) {
            if(fahrzeug.getVehicleIdentificationNumber().equals(vin)){
                fahrzeugAuftrag = fahrzeug;
            }
        }
        for (Person p: autogarage.getPersonen()) {
            if(p instanceof Mitarbeiter){
                Mitarbeiter mitarbeiter = (Mitarbeiter) p;
                if(mitarbeiter.getBenutzername().equals(benutzername)){
                    verantwortlich = mitarbeiter;
                }
            }
        }

        Auftrag newAuftrag = new Auftrag(autogarage, fahrzeugAuftrag, fieldArt.getText(), Integer.parseInt(fieldPreis.getText()), fieldStatus.getText(), dateZuErledigenBis.getValue(), verantwortlich);
        autogarage.getAuftraege().add(newAuftrag);
    }

    /**
     * Diese Methode wird gebraucht um ein schon existierender Auftrag zu löschen.
     * @param actionEvent
     */
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
