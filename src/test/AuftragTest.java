import ch.bbw.leandro.carvalho.autowerkstatt.verwaltung.Autogarage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AuftragTest {

    private Autogarage autogarage;

    @BeforeAll
    void setup(){
        autogarage = new Autogarage("Test");
        autogarage.getData();
    }

    @Test
    void getAuftragNr() {
        assertEquals(1, autogarage.getAuftraege().get(0));
    }

    @Test
    void setAuftragNr() {
        int index = autogarage.getAuftraege().size()-1;
        autogarage.getAuftraege().get(autogarage.getAuftraege().size()-1).setAuftragNr(autogarage);
        assertEquals(index+2, autogarage.getAuftraege().get(index).getAuftragNr());
    }
}