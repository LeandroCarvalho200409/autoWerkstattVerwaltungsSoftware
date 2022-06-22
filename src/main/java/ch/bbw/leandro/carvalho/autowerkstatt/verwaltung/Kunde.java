package ch.bbw.leandro.carvalho.autowerkstatt.verwaltung;

import java.time.LocalDate;
import java.util.Date;

public class Kunde extends Person{
    private String kundenNummer;
    private LocalDate kundeSeit;

    public Kunde(String name, String vorname, LocalDate geburtsDatum, Adresse adresse, String email, String telNummer, String kundenNummer, LocalDate kundeSeit) {
        super(name, vorname, geburtsDatum, adresse, email, telNummer);
        this.kundenNummer = kundenNummer;
        this.kundeSeit = kundeSeit;
    }

    public String getKundenNummer() {
        return kundenNummer;
    }

    public void setKundenNummer(String kundenNummer) {
        this.kundenNummer = kundenNummer;
    }

    public LocalDate getKundeSeit() {
        return kundeSeit;
    }

    public void setKundeSeit(LocalDate kundeSeit) {
        this.kundeSeit = kundeSeit;
    }
}
