package ch.bbw.leandro.carvalho.autowerkstatt.verwaltung;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;


public class AuftraegeVerwaltungControllerTest {
    private Auftrag auftrag;
    private Autogarage autogarage;

    @BeforeAll
    public void setUp(){
        autogarage = new Autogarage("Test");
        autogarage.getData();
        Mitarbeiter mitarbeiter = null;
        for (Person person:autogarage.getPersonen()) {
            if(person instanceof Mitarbeiter){
                mitarbeiter = (Mitarbeiter) person;
            }
        }
        auftrag = new Auftrag(autogarage, autogarage.getFahrzeuge().get(1), "Service", 200, "pendent", LocalDate.of(2022, 12, 2), mitarbeiter);
        autogarage.getAuftraege().add(auftrag);
        autogarage.saveData();
    }

    @Test
    public void testFillupData(){
        AuftraegeVerwaltungController controller = new AuftraegeVerwaltungController();
        controller.setAuftrag(auftrag);
        controller.fillupData();
        assertEquals(auftrag.getPreis(), controller.getFieldPreis());
    }
}