package ch.bbw.leandro.carvalho.autowerkstatt.verwaltung;

import ch.bbw.leandro.carvalho.autowerkstatt.verwaltung.Autogarage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    private Autogarage autogarage;

    @BeforeAll
    void setup(){
        autogarage = new Autogarage("Test");
        autogarage.getData();
    }

    @Test
    void getName() {
        assertEquals("test", autogarage.getPersonen().get(1).getName());
    }

    @Test
    void setName() {
        autogarage.getPersonen().get(1).setName("TestPerson");
        assertEquals("TestPerson", autogarage.getPersonen().get(1).getName());
    }
}