import ch.bbw.leandro.carvalho.autowerkstatt.verwaltung.Autogarage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FahrzeugTest {

    private Autogarage autogarage;

    @BeforeAll
    void setup(){
        autogarage = new Autogarage("Test");
        autogarage.getData();
    }

    @Test
    void getMarke() {
        assertEquals("Mercedes-Benz", autogarage.getFahrzeuge().get(0).getMarke());
    }

    @Test
    void setMarke() {
        autogarage.getFahrzeuge().get(0).setMarke("Mercedes");
        assertEquals("Mercedes", autogarage.getFahrzeuge().get(0).getMarke());
    }
}