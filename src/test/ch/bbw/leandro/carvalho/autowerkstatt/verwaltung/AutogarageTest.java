package ch.bbw.leandro.carvalho.autowerkstatt.verwaltung;

import ch.bbw.leandro.carvalho.autowerkstatt.verwaltung.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class AutogarageTest {

    private Autogarage autogarage;
    private Mitarbeiter mitarbeiter;
    private Auftrag auftrag;

    @BeforeAll
    public void setAutogarage(){
        autogarage = new Autogarage("Test");
        autogarage.getData();
    }

    @Test
    void addPerson() {
        mitarbeiter = new Mitarbeiter("Meier", "Hans", LocalDate.of(2000, 12, 12),
                new Adresse("Test", 12, "Winterthur", 8400), "hans.peter@gmail.com", "0777777777", "hanpet", "1234",
                LocalDate.of(2022, 1, 23), "Geschäftsführer", true, 20, 10);
        autogarage.addPerson(mitarbeiter);

        int index = autogarage.getPersonen().indexOf(mitarbeiter);
        assertEquals(mitarbeiter, autogarage.getPersonen().get(index));
    }

    @Test
    void addAuftrag() {
        auftrag = new Auftrag(autogarage, null, "Sevice", 1200, "pendent",
                LocalDate.of(2022, 7, 12), mitarbeiter);
        autogarage.addAuftrag(auftrag);

        int index = autogarage.getAuftraege().indexOf(auftrag);
        assertEquals(auftrag, autogarage.getAuftraege().get(index));
    }

    @Test
    void removePerson() {
        autogarage.removePerson(mitarbeiter);
    }

    @Test
    void removeAuftrag() {
        autogarage.removeAuftrag(auftrag);
    }

    @Test
    void getPersonByKundenNummer() {
        Kunde kunde = new Kunde("Müller", "Peter", LocalDate.of(1999, 12, 2),
                new Adresse("test", 1, "Zürich", 8000), "mail", "1234",
                "kunde2", LocalDate.of(2022, 8, 20));
        autogarage.addPerson(kunde);

        assertEquals(kunde, autogarage.getPersonByKundenNummer("kunde2"));
    }

    @Test
    void getData() {
        autogarage.getData();
        assertEquals("test", autogarage.getPersonByKundenNummer("kunde1").getEmail());
    }

    @Test
    void anmelden() {
        autogarage.getData();
        assertTrue(autogarage.anmelden("test", "12345"));
    }
}