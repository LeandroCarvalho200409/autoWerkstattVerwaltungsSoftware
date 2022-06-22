package ch.bbw.leandro.carvalho.autowerkstatt.verwaltung;

import java.time.LocalDate;

public class Verkaufsfahrzeug extends Fahrzeug{
    private double Preis;
    private boolean verkauft;
    private Kunde verkauftAn;
    private LocalDate gekauftDate;

    public Verkaufsfahrzeug(String marke, String modell, String baureihe, int ccm, int ps, int anzPlaetze, String aufbau, String farbe, String farbencode, String vehicleIdentificationNumber, LocalDate ersteInverkehrssetzung, double preis, boolean verkauft, Kunde verkauftAn, LocalDate gekauftDate) {
        super(marke, modell, baureihe, ccm, ps, anzPlaetze, aufbau, farbe, farbencode, vehicleIdentificationNumber, ersteInverkehrssetzung);
        Preis = preis;
        this.verkauft = verkauft;
        this.verkauftAn = verkauftAn;
        this.gekauftDate = gekauftDate;
    }

    public double getPreis() {
        return Preis;
    }

    public void setPreis(double preis) {
        Preis = preis;
    }

    public boolean isVerkauft() {
        return verkauft;
    }

    public void setVerkauft(boolean verkauft) {
        this.verkauft = verkauft;
    }

    public Kunde getVerkauftAn() {
        return verkauftAn;
    }

    public void setVerkauftAn(Kunde verkauftAn) {
        this.verkauftAn = verkauftAn;
    }

    public LocalDate getGekauftDate() {
        return gekauftDate;
    }

    public void setGekauftDate(LocalDate gekauftDate) {
        this.gekauftDate = gekauftDate;
    }
}
