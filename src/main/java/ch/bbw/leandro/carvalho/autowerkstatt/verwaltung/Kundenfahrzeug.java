package ch.bbw.leandro.carvalho.autowerkstatt.verwaltung;

import java.time.LocalDate;

public class Kundenfahrzeug extends Fahrzeug{
    private Kunde besitzer;

    public Kundenfahrzeug(String marke, String modell, String baureihe, int ccm, int ps, int anzPlaetze, String aufbau, String farbe, String farbencode, String vehicleIdentificationNumber, LocalDate ersteInverkehrssetzung, Kunde besitzer) {
        super(marke, modell, baureihe, ccm, ps, anzPlaetze, aufbau, farbe, farbencode, vehicleIdentificationNumber, ersteInverkehrssetzung);
        this.besitzer = besitzer;
    }

    public Kunde getBesitzer() {
        return besitzer;
    }

    public void setBesitzer(Kunde besitzer) {
        this.besitzer = besitzer;
    }
}
