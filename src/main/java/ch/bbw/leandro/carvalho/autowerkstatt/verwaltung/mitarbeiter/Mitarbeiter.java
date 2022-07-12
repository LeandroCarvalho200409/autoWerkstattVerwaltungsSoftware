package ch.bbw.leandro.carvalho.autowerkstatt.verwaltung.mitarbeiter;

import ch.bbw.leandro.carvalho.autowerkstatt.verwaltung.Adresse;
import ch.bbw.leandro.carvalho.autowerkstatt.verwaltung.Person;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;

/**
 * Diese Klasse hier dient für die Verwaltung von Mitarbeitern und ist Unterklasse der Klasse Person..
 *
 * @author Leandro Filipe Lourenço Carvalho
 * @version 1.0
 */

public class Mitarbeiter extends Person {
    private String benutzername;
    private String passwort;
    private LocalDate eintrittsDatum;
    private String funktion;
    private boolean geschaeftsfuehrer;
    private int anzStunden;
    private int ferienTage;

    /**
     * Konstruktor der Klasse Mitarbeiter.
     * @param name
     * @param vorname
     * @param geburtsDatum
     * @param adresse
     * @param email
     * @param telNummer
     * @param benutzername
     * @param passwort
     * @param eintrittsDatum
     * @param funktion
     * @param geschaeftsfuehrer
     * @param anzStunden
     * @param ferienTage
     */
    public Mitarbeiter(String name, String vorname, LocalDate geburtsDatum, Adresse adresse, String email, String telNummer, String benutzername, String passwort, LocalDate eintrittsDatum, String funktion, boolean geschaeftsfuehrer, int anzStunden, int ferienTage) {
        super(name, vorname, geburtsDatum, adresse, email, telNummer);
        this.benutzername = benutzername;
        this.passwort = passwort;
        this.eintrittsDatum = eintrittsDatum;
        this.funktion = funktion;
        this.geschaeftsfuehrer = geschaeftsfuehrer;
        this.anzStunden = anzStunden;
        this.ferienTage = ferienTage;
    }

    /**
     * Hiermit wird der Benutzername eines Mitarbeiters abgeholt.
     * @return Benutzername eines Mitarbeiters.
     */
    public String getBenutzername() {
        return benutzername;
    }

    /**
     * Hiermit wird der Benutzername eines Mitarbeiters gesetzt.
     * @param benutzername
     */
    public void setBenutzername(String benutzername) {
        this.benutzername = benutzername;
    }

    /**
     * Mithilfe dieser Methode kann das Passwort eines Mitarbeiters abgeholt werden.
     * @return Passwort des Mitarbeiters
     */
    public String getPasswort() {
        return passwort;
    }


    /**
     * Hiermit wird das Passwort eines Mitarbeiters gesetzt.
     * @param passwort
     */
    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }

    /**
     * Gibt das Eintrittsdatum eines Mitarbeiters zurück.
     * @return Eintrittsdatum.
     */
    public LocalDate getEintrittsDatum() {
        return eintrittsDatum;
    }

    /**
     * Setzt das Eintrittsdatum eines Mitarbeiter ein
     * @param eintrittsDatum
     */
    public void setEintrittsDatum(LocalDate eintrittsDatum) {
        this.eintrittsDatum = eintrittsDatum;
    }

    /**
     * Gibt die Funktion eines Mitarbeiters zurück
     * @return Funktion
     */
    public String getFunktion() {
        return funktion;
    }

    /**
     * Setzt die Funktion eines Mitarbeiters ein.
     * @param funktion
     */
    public void setFunktion(String funktion) {
        this.funktion = funktion;
    }

    /**
     * Gibt ein Boolean zurück, welcher besagt, ob ein Mitarbeiter der Geschäftsführer ist.
     * @return Boolean isGeschaeftsfuehrer
     */
    public boolean isGeschaeftsfuehrer() {
        return geschaeftsfuehrer;
    }

    /**
     * Setzt den Boolean des Mitarbeiters, welcher besagt, ob ein Mitarbeiter ein Geschäftsführer ist, ein.
     * @param geschaeftsfuehrer
     */
    public void setGeschaeftsfuehrer(boolean geschaeftsfuehrer) {
        this.geschaeftsfuehrer = geschaeftsfuehrer;
    }

    /**
     * Gibt die Anzahl Stunden eines Mitarbeiters zurück.
     * @return Anzahl Stunden.
     */
    public int getAnzStunden() {
        return anzStunden;
    }

    /**
     * Setzt die Anzahl Stunden eines Mitarbeiters ein.
     * @param anzStunden
     */
    public void setAnzStunden(int anzStunden) {
        this.anzStunden = anzStunden;
    }

    /**
     * Gibt die Anzahl Ferientage eines Mitarbeiters zurück.
     * @return Ferientage
     */
    public int getFerienTage() {
        return ferienTage;
    }

    /**
     * Setzt die Anzahl Ferientage eines Mitarbeiters ein.
     * @param ferienTage
     */
    public void setFerienTage(int ferienTage) {
        this.ferienTage = ferienTage;
    }

    /**
     * Diese Methode wird für die Anmeldungsfunktion eines Mitarbeiters gebraucht und schaut, ob ein Passwort gleich
     * wie der Passwort des Mitarbeiters.
     * @param passwort
     * @return Boolean, ob es gleich ist oder nicht.
     */
    public boolean anmelden(String passwort){
        if(passwort.equals(this.passwort)){
            return true;
        }else{
            return false;
        }
    }
}
