package ch.bbw.leandro.carvalho.autowerkstatt.verwaltung.auftrag;

import ch.bbw.leandro.carvalho.autowerkstatt.verwaltung.*;
import ch.bbw.leandro.carvalho.autowerkstatt.verwaltung.ersatzteil.Ersatzteil;
import ch.bbw.leandro.carvalho.autowerkstatt.verwaltung.fahrzeug.Fahrzeug;
import ch.bbw.leandro.carvalho.autowerkstatt.verwaltung.mitarbeiter.Mitarbeiter;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Diese Klasse dient als Datencontainer für die Daten eines Auftrages.
 *
 * @author Leandro Filipe Lourenço Carvalho
 * @version 1.0
 */

public class Auftrag {
    private int auftragNr;
    private Fahrzeug fahrzeug;
    private ArrayList<Ersatzteil> ersatzteile;
    private String art;
    private int preis;
    private ArrayList<String> gebieteDesFahrzeuges;
    private String status;
    private LocalDate zuErledigenBis;
    private ArrayList<Mitarbeiter> zustaendigeMitarbeiter;
    private Mitarbeiter verantwortlicheMitarbeiter;

    /**
     * Dies ist der Constructor der Klasse Aufträge
     * @param autogarage
     * @param fahrzeug
     * @param art
     * @param preis
     * @param status
     * @param zuErledigenBis
     * @param verantwortlicheMitarbeiter
     */
    public Auftrag(Autogarage autogarage, Fahrzeug fahrzeug, String art, int preis, String status, LocalDate zuErledigenBis, Mitarbeiter verantwortlicheMitarbeiter) {
        this.auftragNr = 0;
        this.fahrzeug = fahrzeug;
        this.art = art;
        this.preis = preis;
        this.status = status;
        this.zuErledigenBis = zuErledigenBis;
        this.verantwortlicheMitarbeiter = verantwortlicheMitarbeiter;
        this.ersatzteile = new ArrayList<>();
        this.gebieteDesFahrzeuges = new ArrayList<>();
        this.zustaendigeMitarbeiter = new ArrayList<>();

        setAuftragNr(autogarage);
    }

    /**
     * Hiermit kann die Auftragsnummer eines Auftrages abgerufen werden.
     * @return Auftragsnummer
     */
    public int getAuftragNr() {
        return auftragNr;
    }

    /**
     * Hiermit kann die Auftragsnummer gesetzt werden. Diese wird jedoch automatisch gesetzt und ist immer um eins höher, wie der letzte Auftrag.
     * @param autogarage Autogarage, woher man die Anzahl Aufträge abholen soll.
     */
    public void setAuftragNr(Autogarage autogarage){
        if(autogarage.getAuftraege().size() > 0){
            Auftrag oldAuftrag = autogarage.getAuftraege().get(autogarage.getAuftraege().size()-1);
            auftragNr = oldAuftrag.getAuftragNr()+1;
        }else {
            auftragNr = 0;
        }
    }

    /**
     * Hiermit kann man das Fahrzeug eines Auftrages abrufen.
     * @return Fahrzeug
     */
    public Fahrzeug getFahrzeug() {
        return fahrzeug;
    }

    /**
     * Somit kann man das Fahrzeug eines Auftrages setzen oder ändern.
     * @param fahrzeug
     */
    public void setFahrzeug(Fahrzeug fahrzeug) {
        this.fahrzeug = fahrzeug;
    }

    /**
     * Hiermit kann man die Liste aller Ersatzteile eines Auftages holen.
     * @return ArrayList aller Ersatzteile
     */
    public ArrayList<Ersatzteil> getErsatzteile() {
        return ersatzteile;
    }

    /**
     * Hiermit kann man die Liste aller Ersatzteile eines Auftrages setzen.
     * @param ersatzteile
     */
    public void setErsatzteile(ArrayList<Ersatzteil> ersatzteile) {
        this.ersatzteile = ersatzteile;
    }

    /**
     * Mit dieser Methode kann man ein neues Ersatzteil in die entsprechende Liste einfügen. Hiermit wird geschaut, ob ein Ersatzteil schon existiert.
     * @param ersatzteil
     */
    public void setErsatzteil(Ersatzteil ersatzteil){
        boolean ersatzteilGleich = false;
        for (Ersatzteil e:ersatzteile) {
            if(e.getProduktNr() == ersatzteil.getProduktNr()){
                ersatzteilGleich = true;
            }
        }
        if(!ersatzteilGleich){
            this.ersatzteile.add(ersatzteil);
        }
    }

    /**
     * Diese Methode entfernt ein Ersatzteil aus der Liste der Ersatzteile
     * @param ersatzteil
     */
    public void removeErsatzteil(Ersatzteil ersatzteil){
        this.ersatzteile.remove(ersatzteil);
    }

    /**
     * Mit dieser Methode kann man die Art eines Auftrages abholen.
     * @return Art des Auftrages
     */
    public String getArt() {
        return art;
    }

    /**
     * Hiermit kann die Art eines Auftrages gesetzt werden.
     * @param art
     */
    public void setArt(String art) {
        this.art = art;
    }

    /**
     * Hiermit kann man den aktuellen Preis des Auftrages abholen.
     * @return Preis des Auftrages.
     */
    public int getPreis() {
        return preis;
    }

    /**
     * Hiermit kann man den Preis eines Auftrages setzen.
     * @param preis
     */
    public void setPreis(int preis) {
        this.preis = preis;
    }

    /**
     * Hiermit kann die ArrayList der Gebiete des Fahrzeuges abgeholt werden.
     * @return ArrayList der Gebiete
     */
    public ArrayList<String> getGebieteDesFahrzeuges() {
        return gebieteDesFahrzeuges;
    }

    /**
     * Mit dieser Methode kann ein Gebiet aus deren Liste entfernt werden.
     * @param gebiet
     */
    public void removeGebietDesFahrzeuges(String gebiet){
        this.ersatzteile.remove(gebiet);
    }

    /**
     * Mit dieser Methode ist es möglich die Liste der Gebiete des Fahrzeuges zu setzen.
     * @param gebieteDesFahrzeuges
     */
    public void setGebieteDesFahrzeuges(ArrayList<String> gebieteDesFahrzeuges) {
        this.gebieteDesFahrzeuges = gebieteDesFahrzeuges;
    }

    /**
     * Hiermit kann ein neuer Gebiet der Liste der Gebiete hinzugefügt werden. Dabei wird geprüft, ob nicht schon ein Duplikat in der Liste existiert.
     * @param gebiet
     */
    public void setGebietDesFahrzeuges(String gebiet){
        boolean gebietGleich = false;
        for (String g:gebieteDesFahrzeuges) {
            if(g.equals(gebiet)){
                gebietGleich = true;
            }
        }
        if(!gebietGleich){
            this.gebieteDesFahrzeuges.add(gebiet);
        }
    }

    /**
     * In dieser Methode wird der Status eines Auftrages abgeholt.
     * @return Status des Auftrages
     */
    public String getStatus() {
        return status;
    }

    /**
     * Hiermit wird der Status des Auftrages gesetzt
     * @param status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Hiermit wird das Datum bis wann ein Auftrag erledigt werden muss zurückgegeben.
     * @return Datum, bis wann es erledigt sein muss.
     */
    public LocalDate getZuErledigenBis() {
        return zuErledigenBis;
    }

    /**
     * Hiermit wird das Datum, bis wann es erledigt sein muss gesetzt.
     * @param zuErledigenBis
     */
    public void setZuErledigenBis(LocalDate zuErledigenBis) {
        this.zuErledigenBis = zuErledigenBis;
    }

    /**
     * Hiermit wird die Liste der zuständigen Mitarbeiter abgeholt.
     * @return Liste der zuständigen Mitarbeiter.
     */
    public ArrayList<Mitarbeiter> getZustaendigeMitarbeiter() {
        return zustaendigeMitarbeiter;
    }

    /**
     * Hiermit wird ein zuständiger Mitarbeiter aus der Liste entfernt.
     * @param mitarbeiter
     */
    public void removeZustaendigeMitarbeiter(Mitarbeiter mitarbeiter){
        this.zustaendigeMitarbeiter.remove(mitarbeiter);
    }

    /**
     * Hiermit wird ein zuständiger Mitarbeiter der Liste hinzugefügt.
     * @param mitarbeiter
     */
    public void setZustaendigeMitarbeiter(Mitarbeiter mitarbeiter) {
        boolean equalfound = false;
        for (Person p:zustaendigeMitarbeiter) {
            if(p instanceof Mitarbeiter){
                Mitarbeiter m = (Mitarbeiter) p;
                if(m.getBenutzername().equals(mitarbeiter.getBenutzername())){
                    equalfound = true;
                }
            }
        }
        if(!equalfound){
            this.zustaendigeMitarbeiter.add(mitarbeiter);
        }
    }

    /**
     * Hiermit wird der verantwortliche Mitarbeiter zurückgegeben.
     * @return verantwortlicher Mitarbeiter
     */
    public Mitarbeiter getVerantwortlicheMitarbeiter() {
        return verantwortlicheMitarbeiter;
    }

    /**
     * Mit dieser Methode wird der verantwortliche Mitarbeiter gesetzt.
     * @param verantwortlicheMitarbeiter
     */
    public void setVerantwortlicheMitarbeiter(Mitarbeiter verantwortlicheMitarbeiter) {
        this.verantwortlicheMitarbeiter = verantwortlicheMitarbeiter;
    }
}
