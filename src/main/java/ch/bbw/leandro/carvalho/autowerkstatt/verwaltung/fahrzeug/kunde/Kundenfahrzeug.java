package ch.bbw.leandro.carvalho.autowerkstatt.verwaltung.fahrzeug.kunde;

import ch.bbw.leandro.carvalho.autowerkstatt.verwaltung.fahrzeug.Fahrzeug;
import ch.bbw.leandro.carvalho.autowerkstatt.verwaltung.kunde.Kunde;

import java.time.LocalDate;

/**
 * Diese Klasse dient als Datencontainer für die Daten eines Kundenfahrzeuges.
 *
 * @author Leandro Filipe Lourenço Carvalho
 * @version 1.0
 */

public class Kundenfahrzeug extends Fahrzeug {
    private Kunde besitzer;

    /**
     * Dies hier ist der Konstruktor der Klasse Kundenfahrzeug
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
     * @param besitzer
     */
    public Kundenfahrzeug(String marke, String modell, String baureihe, int ccm, int ps, int anzPlaetze, String aufbau, String farbe, String farbencode, String vehicleIdentificationNumber, LocalDate ersteInverkehrssetzung, Kunde besitzer) {
        super(marke, modell, baureihe, ccm, ps, anzPlaetze, aufbau, farbe, farbencode, vehicleIdentificationNumber, ersteInverkehrssetzung);
        this.besitzer = besitzer;
    }

    /**
     * Hiermit kann der Besitzer eines Fahrzeuges abgeholt werden
     * @return Besitzer des Fahrzeuges
     */
    public Kunde getBesitzer() {
        return besitzer;
    }

    /**
     * Hiermit kann der Besitzer des Fahrzeuges gesetzt werden.
     * @param besitzer
     */
    public void setBesitzer(Kunde besitzer) {
        this.besitzer = besitzer;
    }
}
