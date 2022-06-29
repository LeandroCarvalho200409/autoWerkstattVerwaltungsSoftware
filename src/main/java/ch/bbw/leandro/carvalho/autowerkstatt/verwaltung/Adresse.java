package ch.bbw.leandro.carvalho.autowerkstatt.verwaltung;

/**
 * Diese Klasse hier dient für die Verwaltung von Adressen.
 *
 * @author Leandro Filipe Lourenço Carvalho
 * @version 1.0
 */

public class Adresse {
    private String strasse;
    private int nummer;
    private String ort;
    private int plz;

    /**
     * Dies ist der Konstruktor für die Klasse Adresse.
     * @param strasse
     * @param nummer
     * @param ort
     * @param plz
     */
    public Adresse(String strasse, int nummer, String ort, int plz) {
        this.strasse = strasse;
        this.nummer = nummer;
        this.ort = ort;
        this.plz = plz;
    }

    /**
     * Hiermit wird die Strasse einer Adresse zurückgegeben.
     * @return Strasse der Adresse.
     */
    public String getStrasse() {
        return strasse;
    }

    /**
     * Hiermit wird die Strasse einer Adresse gesetzt.
     * @param strasse
     */
    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    /**
     * Hiermit wird die Nummer einer Adresse zurückgegeben.
     * @return Nummer der Adresse.
     */
    public int getNummer() {
        return nummer;
    }

    /**
     * Hiermit wird die Nummer einer Adresse gesetzt.
     * @param nummer
     */
    public void setNummer(int nummer) {
        this.nummer = nummer;
    }

    /**
     * Hiermit wird der Ort einer Adresse zurückgegeben.
     * @return Ort der Adresse.
     */
    public String getOrt() {
        return ort;
    }

    /**
     * Hiermit wird der Ort einer Adresse gesetzt.
     * @param ort
     */
    public void setOrt(String ort) {
        this.ort = ort;
    }

    /**
     * Hiermit wird die PLZ einer Adresse zurückgegeben.
     * @return PLZ der Adresse.
     */
    public int getPlz() {
        return plz;
    }

    /**
     * Hiermit wird die PLZ einer Adresse gesetzt.
     * @param plz
     */
    public void setPlz(int plz) {
        this.plz = plz;
    }
}
