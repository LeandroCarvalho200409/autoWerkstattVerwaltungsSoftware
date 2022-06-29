package ch.bbw.leandro.carvalho.autowerkstatt.verwaltung;

import java.time.LocalDate;

/**
 * Diese Klasse dient als Datencontainer für die Daten eines Fahrzeugs.
 *
 * @author Leandro Filipe Lourenço Carvalho
 * @version 1.0
 */

public abstract class Fahrzeug {
    private String marke;
    private String modell;
    private String baureihe;
    private int ccm;
    private int ps;
    private int anzPlaetze;
    private String aufbau;
    private String farbe;
    private String farbencode;
    private String vehicleIdentificationNumber;
    private LocalDate ersteInverkehrssetzung;

    /**
     * Diese Methode ist der Konstruktor der Klasse Fahrzeug
     * @param marke
     * @param modell
     * @param baureihe
     * @param ccm
     * @param ps
     * @param anzPlaetze
     * @param aufbau
     * @param farbe
     * @param farbencode
     * @param vehicleIdentificationNumber
     * @param ersteInverkehrssetzung
     */
    public Fahrzeug(String marke, String modell, String baureihe, int ccm, int ps, int anzPlaetze, String aufbau, String farbe, String farbencode, String vehicleIdentificationNumber, LocalDate ersteInverkehrssetzung) {
        this.marke = marke;
        this.modell = modell;
        this.baureihe = baureihe;
        this.ccm = ccm;
        this.ps = ps;
        this.anzPlaetze = anzPlaetze;
        this.aufbau = aufbau;
        this.farbe = farbe;
        this.farbencode = farbencode;
        this.vehicleIdentificationNumber = vehicleIdentificationNumber;
        this.ersteInverkehrssetzung = ersteInverkehrssetzung;
    }

    /**
     * Mit dieser Methode wird die Marke eines Fahrzeuges abgeholt.
     * @return Marke
     */
    public String getMarke() {
        return marke;
    }

    /**
     * Hiermit wird die Marke eines Fahrzeuges gesetzt
     * @param marke
     */
    public void setMarke(String marke) {
        this.marke = marke;
    }

    /**
     * Mit dieser Methode wird das Modell eines Fahrzeuges abgeholt.
     * @return Modell
     */
    public String getModell() {
        return modell;
    }

    /**
     * Hiermit wird das Modell eines Fahrzeuges gesetzt
     * @param modell
     */
    public void setModell(String modell) {
        this.modell = modell;
    }

    /**
     * Mit dieser Methode wird die Baureihe eines Fahrzeuges abgeholt.
     * @return Baureihe
     */
    public String getBaureihe() {
        return baureihe;
    }

    /**
     * Hiermit wird die Baureihe eines Fahrzeuges gesetzt
     * @param baureihe
     */
    public void setBaureihe(String baureihe) {
        this.baureihe = baureihe;
    }

    /**
     * Mit dieser Methode werden die CCM eines Fahrzeuges abgeholt.
     * @return CCM
     */
    public int getCcm() {
        return ccm;
    }

    /**
     * Hiermit wird die CCM eines Fahrzeuges gesetzt
     * @param ccm
     */
    public void setCcm(int ccm) {
        this.ccm = ccm;
    }

    /**
     * Mit dieser Methode werden die PS eines Fahrzeuges abgeholt.
     * @return PS
     */
    public int getPs() {
        return ps;
    }

    /**
     * Hiermit werden die PS eines Fahrzeuges gesetzt
     * @param ps
     */
    public void setPs(int ps) {
        this.ps = ps;
    }

    /**
     * Mit dieser Methode werden die Anzahl Plätze eines Fahrzeuges abgeholt.
     * @return Anzahl Plätze
     */
    public int getAnzPlaetze() {
        return anzPlaetze;
    }

    /**
     * Hiermit werden die Anzahl Plätze eines Fahrzeuges gesetzt
     * @param anzPlaetze
     */
    public void setAnzPlaetze(int anzPlaetze) {
        this.anzPlaetze = anzPlaetze;
    }

    /**
     * Mit dieser Methode wird der Aufbau eines Fahrzeuges abgeholt.
     * @return Aufbau
     */
    public String getAufbau() {
        return aufbau;
    }

    /**
     * Hiermit wird der Aufbau eines Fahrzeuges gesetzt
     * @param aufbau
     */
    public void setAufbau(String aufbau) {
        this.aufbau = aufbau;
    }

    /**
     * Mit dieser Methode wird die Farbe eines Fahrzeuges abgeholt.
     * @return Farbe
     */
    public String getFarbe() {
        return farbe;
    }

    /**
     * Hiermit wird die Farbe eines Fahrzeuges gesetzt
     * @param farbe
     */
    public void setFarbe(String farbe) {
        this.farbe = farbe;
    }

    /**
     * Mit dieser Methode wird der Farbencode eines Fahrzeuges abgeholt.
     * @return Farbencode
     */
    public String getFarbencode() {
        return farbencode;
    }

    /**
     * Hiermit wird der Farbencode eines Fahrzeuges gesetzt
     * @param farbencode
     */
    public void setFarbencode(String farbencode) {
        this.farbencode = farbencode;
    }

    /**
     * Mit dieser Methode wird die VIN eines Fahrzeuges abgeholt.
     * @return VIN
     */
    public String getVehicleIdentificationNumber() {
        return vehicleIdentificationNumber;
    }

    /**
     * Hiermit wird die VIN eines Fahrzeuges gesetzt
     * @param vehicleIdentificationNumber
     */
    public void setVehicleIdentificationNumber(String vehicleIdentificationNumber) {
        this.vehicleIdentificationNumber = vehicleIdentificationNumber;
    }

    /**
     * Mit dieser Methode wird die erste Inverkehrssetzung eines Fahrzeuges abgeholt.
     * @return 1. Inverkehrssetzung
     */
    public LocalDate getErsteInverkehrssetzung() {
        return ersteInverkehrssetzung;
    }

    /**
     * Hiermit wird die 1. Inverkehrssetzung eines Fahrzeuges gesetzt
     * @param ersteInverkehrssetzung
     */
    public void setErsteInverkehrssetzung(LocalDate ersteInverkehrssetzung) {
        this.ersteInverkehrssetzung = ersteInverkehrssetzung;
    }
}
