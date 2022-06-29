package ch.bbw.leandro.carvalho.autowerkstatt.verwaltung;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;

/**
 * Diese Klasse hier dient als Controller für die Verwaltung von Verkaufsfahrzeuge.
 *
 * @author Leandro Filipe Lourenço Carvalho
 * @version 1.0
 */

public class VerkaufsfahrzeugVerwaltungController extends NavigationController{

    public TextField fieldMarke;
    public TextField fieldBaureihe;
    public TextField fieldFarbenCode;
    public DatePicker dateIVS;
    public MenuButton kundeDropdown;
    public TextField fieldModell;
    public TextField fieldCCM;
    public TextField fieldPS;
    public TextField fieldAnzPlaetze;
    public TextField fieldAufbau;
    public TextField fieldFarbe;
    public TextField fieldVIN;
    public TextField fieldPreis;
    public DatePicker dateGekauft;
    public CheckBox checkVerkauft;
    private Autogarage autogarage;
    private Verkaufsfahrzeug verkaufsfahrzeug;


    /**
     * Diese Methode setzt generell den Text eines MenuButtons neu.
     * @param menuButton
     * @param menuItem
     */
    public void setTextDropdownMenu(MenuButton menuButton, MenuItem menuItem){
        Label label = (Label) menuItem.getGraphic();
        menuButton.setText(label.getText());
    }

    /**
     * Diese Methode bewirkt, dass ein neuer Verkaufsfahrzeug eingesetzt wird.
     * @param verkaufsfahrzeug
     */
    public void setFahrzeug(Verkaufsfahrzeug verkaufsfahrzeug){
        this.verkaufsfahrzeug = verkaufsfahrzeug;
    }

    /**
     * Diese Methode speichert die Daten nach der Verwaltung eines Verkaufsfahrzeugs ein. Dabei werden die
     * neuen Daten mit den alten verglichen.
     */
    public void save(){
        int counter = 0;
        int index = 0;
        for (Fahrzeug f:autogarage.getFahrzeuge()) {
            if(f instanceof Verkaufsfahrzeug){
                Verkaufsfahrzeug verkaufsfahrzeug = (Verkaufsfahrzeug) f;
                if(verkaufsfahrzeug.getVehicleIdentificationNumber().equals(this.verkaufsfahrzeug.getVehicleIdentificationNumber())){
                    index=counter;
                }
            }
            counter++;
        }
        Verkaufsfahrzeug verkaufsfahrzeug = (Verkaufsfahrzeug) autogarage.getFahrzeuge().get(index);
        if(!(fieldVIN.getText().equals(verkaufsfahrzeug.getVehicleIdentificationNumber()))){
            autogarage.getFahrzeuge().get(index).setVehicleIdentificationNumber(fieldVIN.getText());
        }
        if(!(fieldPS.getText().equals(""+verkaufsfahrzeug.getPs()))){
            autogarage.getFahrzeuge().get(index).setPs(Integer.parseInt(fieldPS.getText()));
        }
        if(!(fieldCCM.getText().equals(""+verkaufsfahrzeug.getCcm()))){
            autogarage.getFahrzeuge().get(index).setCcm(Integer.parseInt(fieldCCM.getText()));
        }
        if(!(fieldModell.getText().equals(verkaufsfahrzeug.getModell()))){
            autogarage.getFahrzeuge().get(index).setModell(fieldModell.getText());
        }
        if(!(fieldMarke.getText().equals(verkaufsfahrzeug.getMarke()))){
            autogarage.getFahrzeuge().get(index).setMarke(fieldMarke.getText());
        }
        if(!(fieldBaureihe.getText().equals(verkaufsfahrzeug.getBaureihe()))){
            autogarage.getFahrzeuge().get(index).setBaureihe(fieldBaureihe.getText());
        }
        if(!(fieldPreis.getText().equals(""+verkaufsfahrzeug.getPreis()))){
            ((Verkaufsfahrzeug) autogarage.getFahrzeuge().get(index)).setPreis(Double.parseDouble(fieldPreis.getText()));
        }
        if(!(fieldFarbenCode.getText().equals(verkaufsfahrzeug.getFarbencode()))){
            autogarage.getFahrzeuge().get(index).setFarbencode(fieldFarbenCode.getText());
        }
        if(!(fieldFarbe.getText().equals(verkaufsfahrzeug.getFarbe()))){
            autogarage.getFahrzeuge().get(index).setFarbe(fieldFarbe.getText());
        }
        if(!(fieldAufbau.getText().equals(verkaufsfahrzeug.getAufbau()))){
            autogarage.getFahrzeuge().get(index).setAufbau(fieldAufbau.getText());
        }
        if(!(fieldAnzPlaetze.getText().equals(verkaufsfahrzeug.getAnzPlaetze()))){
            autogarage.getFahrzeuge().get(index).setAnzPlaetze(Integer.parseInt(fieldAnzPlaetze.getText()));
        }
        if(!(dateIVS.getValue() == verkaufsfahrzeug.getErsteInverkehrssetzung())){
            autogarage.getFahrzeuge().get(index).setErsteInverkehrssetzung(dateIVS.getValue());
        }
        if(!(dateGekauft.getValue() == verkaufsfahrzeug.getGekauftDate())){
            ((Verkaufsfahrzeug) autogarage.getFahrzeuge().get(index)).setGekauftDate(dateGekauft.getValue());
        }
        autogarage.saveData();
        autogarage.getData();
        this.verkaufsfahrzeug = (Verkaufsfahrzeug) autogarage.getFahrzeuge().get(index);
    }

    /**
     * Diese Methode bewirkt, dass ein Verkaufsfahrzeug entfernt wird.
     */
    public void removeFahrzeug(){
        int counter = 0;
        for (Fahrzeug f:autogarage.getFahrzeuge()) {
            if(f instanceof Verkaufsfahrzeug){
                Verkaufsfahrzeug verkaufsfahrzeug = (Verkaufsfahrzeug) f;
                if(verkaufsfahrzeug.getVehicleIdentificationNumber().equals(this.verkaufsfahrzeug.getVehicleIdentificationNumber())){
                    autogarage.getFahrzeuge().remove(counter);
                }
            }
            counter++;
        }
        autogarage.saveData();
        autogarage.getData();
    }

    /**
     * Mithilfe dieser Methode können die anfänglichen Werte eines Verkaufsfahrzeuges auf die entsprechenden Felder
     * der GUI gesetzt.
     */
    public void fillupData(){
        this.autogarage = new Autogarage("Test");
        autogarage.getData();
        for (Person person:autogarage.getPersonen()) {
            if(person instanceof Kunde){
                Kunde kunde = (Kunde) person;
                Label menuItemText = new Label();
                MenuItem menuItem = new MenuItem();
                menuItemText.setText("Kunde: "+kunde.getKundenNummer());
                menuItemText.setPrefWidth(kundeDropdown.getPrefWidth());
                menuItem.setGraphic(menuItemText);
                menuItem.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        setTextDropdownMenu(kundeDropdown, menuItem);
                    }
                });
                kundeDropdown.getItems().add(menuItem);
            }
        }
        fieldAnzPlaetze.setText(""+verkaufsfahrzeug.getAnzPlaetze());
        fieldAufbau.setText(verkaufsfahrzeug.getAufbau());
        fieldBaureihe.setText(verkaufsfahrzeug.getBaureihe());
        fieldCCM.setText(""+verkaufsfahrzeug.getCcm());
        fieldFarbe.setText(verkaufsfahrzeug.getFarbe());
        fieldFarbenCode.setText(verkaufsfahrzeug.getFarbencode());
        fieldMarke.setText(verkaufsfahrzeug.getMarke());
        fieldModell.setText(verkaufsfahrzeug.getModell());
        fieldPreis.setText(""+verkaufsfahrzeug.getPreis());
        fieldPS.setText(""+verkaufsfahrzeug.getPs());
        fieldVIN.setText(verkaufsfahrzeug.getVehicleIdentificationNumber());
        if(verkaufsfahrzeug.isVerkauft()){
            checkVerkauft.setSelected(true);
        }
        dateGekauft.setValue(verkaufsfahrzeug.getGekauftDate());
        dateIVS.setValue(verkaufsfahrzeug.getErsteInverkehrssetzung());
    }
}
