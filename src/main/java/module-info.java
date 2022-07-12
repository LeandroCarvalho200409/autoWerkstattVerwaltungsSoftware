module ch.bbw.leandro.carvalho.autowerkstattverwaltung.autowerkstattverwaltung {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.json;
    requires org.junit.jupiter.api;
    requires org.junit.platform.commons;


    opens ch.bbw.leandro.carvalho.autowerkstatt.verwaltung to javafx.fxml;
    exports ch.bbw.leandro.carvalho.autowerkstatt.verwaltung;
    opens ch.bbw.leandro.carvalho.autowerkstatt.verwaltung.auftrag to javafx.fxml;
    exports ch.bbw.leandro.carvalho.autowerkstatt.verwaltung.auftrag;
    exports ch.bbw.leandro.carvalho.autowerkstatt.verwaltung.ersatzteil;
    opens ch.bbw.leandro.carvalho.autowerkstatt.verwaltung.ersatzteil to javafx.fxml;
    exports ch.bbw.leandro.carvalho.autowerkstatt.verwaltung.login;
    opens ch.bbw.leandro.carvalho.autowerkstatt.verwaltung.login to javafx.fxml;
    exports ch.bbw.leandro.carvalho.autowerkstatt.verwaltung.fahrzeug;
    opens ch.bbw.leandro.carvalho.autowerkstatt.verwaltung.fahrzeug to javafx.fxml;
    opens ch.bbw.leandro.carvalho.autowerkstatt.verwaltung.kunde to javafx.fxml;
    exports ch.bbw.leandro.carvalho.autowerkstatt.verwaltung.kunde;
    exports ch.bbw.leandro.carvalho.autowerkstatt.verwaltung.mitarbeiter;
    opens ch.bbw.leandro.carvalho.autowerkstatt.verwaltung.mitarbeiter to javafx.fxml;
    opens ch.bbw.leandro.carvalho.autowerkstatt.verwaltung.fahrzeug.kunde to javafx.fxml;
    exports ch.bbw.leandro.carvalho.autowerkstatt.verwaltung.fahrzeug.kunde;
    opens ch.bbw.leandro.carvalho.autowerkstatt.verwaltung.fahrzeug.verkauf to javafx.fxml;
    exports ch.bbw.leandro.carvalho.autowerkstatt.verwaltung.fahrzeug.verkauf;
}