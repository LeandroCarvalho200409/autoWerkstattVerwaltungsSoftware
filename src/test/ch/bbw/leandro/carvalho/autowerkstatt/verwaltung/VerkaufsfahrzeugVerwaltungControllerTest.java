package ch.bbw.leandro.carvalho.autowerkstatt.verwaltung;

import ch.bbw.leandro.carvalho.autowerkstatt.verwaltung.fahrzeug.verkauf.Verkaufsfahrzeug;
import ch.bbw.leandro.carvalho.autowerkstatt.verwaltung.fahrzeug.verkauf.VerkaufsfahrzeugVerwaltungController;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class VerkaufsfahrzeugVerwaltungControllerTest {
    private Verkaufsfahrzeug verkaufsfahrzeug;
    private Autogarage autogarage;
    @BeforeAll
    public void setUp(){
        autogarage = new Autogarage("Test");
        autogarage.getData();
        verkaufsfahrzeug = new Verkaufsfahrzeug("Opel", "Kadett 1.0", "Kadett D", 1000, 40, 5, "Coupé", "rot", "red_opel", "WD102234993", LocalDate.of(1982, 2, 14), 7000, false, LocalDate.of(2021, 2, 2));

    }

    @Test
    public void testFillUpData(){
        VerkaufsfahrzeugVerwaltungController controller = new VerkaufsfahrzeugVerwaltungController();
        controller.setFahrzeug(verkaufsfahrzeug);
        controller.fillupData();
        assertEquals(verkaufsfahrzeug.getVehicleIdentificationNumber(), controller.getFieldVINText());
    }
}