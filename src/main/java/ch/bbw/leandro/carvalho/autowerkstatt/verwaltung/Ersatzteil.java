package ch.bbw.leandro.carvalho.autowerkstatt.verwaltung;

import java.util.ArrayList;

/**
 * Hiermit werden Objekte der Klasse Ersatzteil verwalten. Diese sind Ersatzteile für verschiedene Fahrzeuge.
 *
 * @author Leandro Filipe Lourenço Carvalho
 * @version 1.0
 */
public class Ersatzteil {
    private String name;
    private String produktNr;
    private String anwendung;
    private String marke;
    private ArrayList<String> geeignetFuerModelle;
    private int anzAufLager;
    private double preisProStueck;

    /**
     *
     * @param name Name des Ersatzteils
     * @param produktNr Produktnummer vom entsprechenden Hersteller
     * @param anwendung Wo es am Fahrzeug angewendet wird
     * @param marke Die Marke des Ersatzteils
     * @param anzAufLager Wie viele noch im internen Lager vorhanden sind
     * @param preisProStueck Wie viel eine Einheit eines Ersatzteils dem Kunden kostet
     */
    public Ersatzteil(String name, String produktNr, String anwendung, String marke, int anzAufLager, double preisProStueck) {
        this.name = name;
        this.produktNr = produktNr;
        this.anwendung = anwendung;
        this.marke = marke;
        this.anzAufLager = anzAufLager;
        this.preisProStueck = preisProStueck;
    }

    public ArrayList<String> getGeeignetFuerModelle() {
        return geeignetFuerModelle;
    }

    /**
     * Gibt den Namen des Ersatzteils zurück
     * @return Name des Ersatzteils
     */
    public String getName() {
        return name;
    }

    /**
     * Hiermit kann der Name des Ersatzteils geändert werden
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Hier wird die Produktnummer zurückgegeben
     * @return produktNr
     */
    public String getProduktNr() {
        return produktNr;
    }

    /**
     * Hiermit kann die Produktnummer verändert werden
     * @param produktNr
     */
    public void setProduktNr(String produktNr) {
        this.produktNr = produktNr;
    }

    public String getAnwendung() {
        return anwendung;
    }

    public void setAnwendung(String anwendung) {
        this.anwendung = anwendung;
    }

    public String getMarke() {
        return marke;
    }

    public void setMarke(String marke) {
        this.marke = marke;
    }

    public int getAnzAufLager() {
        return anzAufLager;
    }

    public void setAnzAufLager(int anzAufLager) {
        this.anzAufLager = anzAufLager;
    }

    public double getPreisProStueck() {
        return preisProStueck;
    }

    public void setPreisProStueck(double preisProStueck) {
        this.preisProStueck = preisProStueck;
    }


    /**
     * Hier kann ein neues passsendes Fahrzeug-Modell hinzugefügt werden
     * @param modell
     */
    public void addModell(String modell){
        boolean equalFound = false;
        for (String modellString:geeignetFuerModelle) {
            if(modell.equals(modellString)){
                equalFound = true;
            }
        }
        if(!equalFound){
            geeignetFuerModelle.add(modell);
        }
    }
}
