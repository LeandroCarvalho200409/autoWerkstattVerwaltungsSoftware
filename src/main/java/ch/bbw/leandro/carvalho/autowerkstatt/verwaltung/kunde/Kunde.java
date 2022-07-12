package ch.bbw.leandro.carvalho.autowerkstatt.verwaltung.kunde;

import ch.bbw.leandro.carvalho.autowerkstatt.verwaltung.Adresse;
import ch.bbw.leandro.carvalho.autowerkstatt.verwaltung.Person;

import java.time.LocalDate;
import java.util.Date;

/**
 * Diese Klasse dient als Datencontainer für die Daten eines Kunden.
 *
 * @author Leandro Filipe Lourenço Carvalho
 * @version 1.0
 */

public class Kunde extends Person {
    private String kundenNummer;
    private LocalDate kundeSeit;

    /**
     * Dies ist der Konstruktor der Klasse Kunde
     * @param name
     * @param vorname
     * @param geburtsDatum
     * @param adresse
     * @param email
     * @param telNummer
     * @param kundenNummer
     * @param kundeSeit
     */
    public Kunde(String name, String vorname, LocalDate geburtsDatum, Adresse adresse, String email, String telNummer, String kundenNummer, LocalDate kundeSeit) {
        super(name, vorname, geburtsDatum, adresse, email, telNummer);
        this.kundenNummer = kundenNummer;
        this.kundeSeit = kundeSeit;
    }

    /**
     * Hiermit wird die Kundennummer zurückgegeben.
     * @return Kundennummer
     */
    public String getKundenNummer() {
        return kundenNummer;
    }

    /**
     * Hiermit wird die Kundennummer gesetzt
     * @param kundenNummer
     */
    public void setKundenNummer(String kundenNummer) {
        this.kundenNummer = kundenNummer;
    }

    /**
     * Hiermit wird das Datum, seit wenn der Kunde, Kunde ist geholt.
     * @return kundeSeit
     */
    public LocalDate getKundeSeit() {
        return kundeSeit;
    }

    /**
     * Hiermit wird das Datum, seit wann der Kunde Kunde ist gesetzt
     * @param kundeSeit
     */
    public void setKundeSeit(LocalDate kundeSeit) {
        this.kundeSeit = kundeSeit;
    }
}
