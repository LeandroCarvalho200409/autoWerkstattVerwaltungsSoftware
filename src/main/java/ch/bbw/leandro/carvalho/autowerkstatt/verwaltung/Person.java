package ch.bbw.leandro.carvalho.autowerkstatt.verwaltung;

import java.time.LocalDate;

public abstract class Person {
    private String name;
    private String vorname;
    private LocalDate geburtsDatum;
    private Adresse adresse;
    private String email;
    private String telNummer;

    public Person(String name, String vorname, LocalDate geburtsDatum, Adresse adresse, String email, String telNummer) {
        this.name = name;
        this.vorname = vorname;
        this.geburtsDatum = geburtsDatum;
        this.adresse = adresse;
        this.email = email;
        this.telNummer = telNummer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public LocalDate getGeburtsDatum() {
        return geburtsDatum;
    }

    public void setGeburtsDatum(LocalDate geburtsDatum) {
        this.geburtsDatum = geburtsDatum;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelNummer() {
        return telNummer;
    }

    public void setTelNummer(String telNummer) {
        this.telNummer = telNummer;
    }
}
