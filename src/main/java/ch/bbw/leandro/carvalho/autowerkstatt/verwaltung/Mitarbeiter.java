package ch.bbw.leandro.carvalho.autowerkstatt.verwaltung;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;

public class Mitarbeiter extends Person{
    private String benutzername;
    private String passwort;
    private LocalDate eintrittsDatum;
    private String funktion;
    private boolean geschaeftsfuehrer;
    private int anzStunden;
    private int ferienTage;

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

    public String getBenutzername() {
        return benutzername;
    }

    public void setBenutzername(String benutzername) {
        this.benutzername = benutzername;
    }

    public String getPasswort() {
        return passwort;
    }


    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }

    public LocalDate getEintrittsDatum() {
        return eintrittsDatum;
    }

    public void setEintrittsDatum(LocalDate eintrittsDatum) {
        this.eintrittsDatum = eintrittsDatum;
    }

    public String getFunktion() {
        return funktion;
    }

    public void setFunktion(String funktion) {
        this.funktion = funktion;
    }

    public boolean isGeschaeftsfuehrer() {
        return geschaeftsfuehrer;
    }

    public void setGeschaeftsfuehrer(boolean geschaeftsfuehrer) {
        this.geschaeftsfuehrer = geschaeftsfuehrer;
    }

    public int getAnzStunden() {
        return anzStunden;
    }

    public void setAnzStunden(int anzStunden) {
        this.anzStunden = anzStunden;
    }

    public int getFerienTage() {
        return ferienTage;
    }

    public void setFerienTage(int ferienTage) {
        this.ferienTage = ferienTage;
    }

    public boolean anmelden(String passwort){
        if(passwort.equals(this.passwort)){
            return true;
        }else{
            return false;
        }
    }
}
