package ch.bbw.leandro.carvalho.autowerkstatt.verwaltung;

import java.time.LocalDate;

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

    public String getMarke() {
        return marke;
    }

    public void setMarke(String marke) {
        this.marke = marke;
    }

    public String getModell() {
        return modell;
    }

    public void setModell(String modell) {
        this.modell = modell;
    }

    public String getBaureihe() {
        return baureihe;
    }

    public void setBaureihe(String baureihe) {
        this.baureihe = baureihe;
    }

    public int getCcm() {
        return ccm;
    }

    public void setCcm(int ccm) {
        this.ccm = ccm;
    }

    public int getPs() {
        return ps;
    }

    public void setPs(int ps) {
        this.ps = ps;
    }

    public int getAnzPlaetze() {
        return anzPlaetze;
    }

    public void setAnzPlaetze(int anzPlaetze) {
        this.anzPlaetze = anzPlaetze;
    }

    public String getAufbau() {
        return aufbau;
    }

    public void setAufbau(String aufbau) {
        this.aufbau = aufbau;
    }

    public String getFarbe() {
        return farbe;
    }

    public void setFarbe(String farbe) {
        this.farbe = farbe;
    }

    public String getFarbencode() {
        return farbencode;
    }

    public void setFarbencode(String farbencode) {
        this.farbencode = farbencode;
    }

    public String getVehicleIdentificationNumber() {
        return vehicleIdentificationNumber;
    }

    public void setVehicleIdentificationNumber(String vehicleIdentificationNumber) {
        this.vehicleIdentificationNumber = vehicleIdentificationNumber;
    }

    public LocalDate getErsteInverkehrssetzung() {
        return ersteInverkehrssetzung;
    }

    public void setErsteInverkehrssetzung(LocalDate ersteInverkehrssetzung) {
        this.ersteInverkehrssetzung = ersteInverkehrssetzung;
    }
}
