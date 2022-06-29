package ch.bbw.leandro.carvalho.autowerkstatt.verwaltung;

import java.time.LocalDate;

/**
 * Mithilfe dieser Klasse können bei Verkaufsfahrzeuge, dessen Daten aufgenommen werden.
 *
 * @author Leandro Filipe Lourenço Carvalho
 * @version 1.0
 */

public class Verkaufsfahrzeug extends Fahrzeug{
    private double Preis;
    private boolean verkauft;
    private Kunde verkauftAn;
    private LocalDate gekauftDate;

    /**
     * Dies ist der Konstruktor der Klasse Verkaufsfahrzeug.
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
     * @param preis
     * @param verkauft
     * @param verkauftAn
     * @param gekauftDate
     */
    public Verkaufsfahrzeug(String marke, String modell, String baureihe, int ccm, int ps, int anzPlaetze, String aufbau, String farbe, String farbencode, String vehicleIdentificationNumber, LocalDate ersteInverkehrssetzung, double preis, boolean verkauft, Kunde verkauftAn, LocalDate gekauftDate) {
        super(marke, modell, baureihe, ccm, ps, anzPlaetze, aufbau, farbe, farbencode, vehicleIdentificationNumber, ersteInverkehrssetzung);
        Preis = preis;
        this.verkauft = verkauft;
        this.verkauftAn = verkauftAn;
        this.gekauftDate = gekauftDate;
    }

    /**
     * Diese Methode bewirkt, dass man den Preis eines Fahrzeuges abholen kann.
     * @return Preis eines Fahrzeuges
     */
    public double getPreis() {
        return Preis;
    }

    /**
     * Hiermit kann man den Preis eines Fahrzeuges ändern
     * @param preis
     */
    public void setPreis(double preis) {
        Preis = preis;
    }

    /**
     * Hiermit kann man schauen, ob ein Auto bereits verkauft wurde.
     * @return Boolean, welcher besagt, ob ein Auto schon verkauft wurde.
     */
    public boolean isVerkauft() {
        return verkauft;
    }

    /**
     * Hiermit kann man ein Auto als verkauft setzten oder nicht.
     * @param verkauft
     */
    public void setVerkauft(boolean verkauft) {
        this.verkauft = verkauft;
    }

    /**
     * Hiermit kann man die Person, an welche ein Auto verkauft wurde, abholen.
     * @return Person an welche ein Auto verkauft wurde.
     */
    public Kunde getVerkauftAn() {
        return verkauftAn;
    }

    /**
     * Hiermit kann man die Person setzten, an welche ein Auto verkauft wurde.
     * @param verkauftAn
     */
    public void setVerkauftAn(Kunde verkauftAn) {
        this.verkauftAn = verkauftAn;
    }

    /**
     * Mithilfe dieser Methode kann man das Datum holen, an welchem ein Auto gekauft wurde.
     * @return Datum, an welchem ein Auto gekauft wurde.
     */
    public LocalDate getGekauftDate() {
        return gekauftDate;
    }

    /**
     * Hiermit kann man das Datum, an welchem ein Auto verkauft wurde, setzen.
     * @param gekauftDate
     */
    public void setGekauftDate(LocalDate gekauftDate) {
        this.gekauftDate = gekauftDate;
    }
}
