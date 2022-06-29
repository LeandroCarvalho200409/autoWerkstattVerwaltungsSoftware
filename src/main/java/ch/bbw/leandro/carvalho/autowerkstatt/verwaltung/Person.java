package ch.bbw.leandro.carvalho.autowerkstatt.verwaltung;

import java.time.LocalDate;

/**
 * Diese Klasse hier dient für die Verwaltung von allen Personen. Sie ist abstrakt und ist Oberklasse der Klassen
 * Mitarbeiter und Kunde.
 *
 * @author Leandro Filipe Lourenço Carvalho
 * @version 1.0
 */

public abstract class Person {
    private String name;
    private String vorname;
    private LocalDate geburtsDatum;
    private Adresse adresse;
    private String email;
    private String telNummer;

    /**
     * Dies ist der Konstruktor der Klasse Person.
     * @param name
     * @param vorname
     * @param geburtsDatum
     * @param adresse
     * @param email
     * @param telNummer
     */
    public Person(String name, String vorname, LocalDate geburtsDatum, Adresse adresse, String email, String telNummer) {
        this.name = name;
        this.vorname = vorname;
        this.geburtsDatum = geburtsDatum;
        this.adresse = adresse;
        this.email = email;
        this.telNummer = telNummer;
    }

    /**
     * Hiermit kann der Name(Nachname) einer Person abgeholt werden.
     * @return Name
     */
    public String getName() {
        return name;
    }

    /**
     * Mit dieser Methode wird der Name(Nachname) einer Person gesetzt.
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Hiermit wird der Vorname einer Person zurückgegeben.
     * @return Vorname
     */
    public String getVorname() {
        return vorname;
    }

    /**
     * Hiermit wird der Vorname einer Person gesetzt.
     * @param vorname
     */
    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    /**
     * Hiermit wird das Geburtsdatum einer Person zurückgegeben.
     * @return Geburtsdatum
     */
    public LocalDate getGeburtsDatum() {
        return geburtsDatum;
    }

    /**
     * Diese Methode setzt das Geburtsdatum einer Person.
     * @param geburtsDatum
     */
    public void setGeburtsDatum(LocalDate geburtsDatum) {
        this.geburtsDatum = geburtsDatum;
    }

    /**
     * Diese Methode gibt die Adresse einer Person zurück
     * @return Adresse
     */
    public Adresse getAdresse() {
        return adresse;
    }

    /**
     * Diese Methode setzt die Adresse einer Person neu.
     * @param adresse
     */
    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    /**
     * Hiermit kann man ein Email einer Person abfragen
     * @return Email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Mithilfe dieser Methode kann man die Mail-Adresse einer Person setzen.
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Hiermit kann man die Telefonnummer eines Mitarbeiters abholen.
     * @return Telefonnummer
     */
    public String getTelNummer() {
        return telNummer;
    }

    /**
     * Hiermit kann die Telefonnummer eines Mitarbeiters eingesetzt.
     * @param telNummer
     */
    public void setTelNummer(String telNummer) {
        this.telNummer = telNummer;
    }
}
