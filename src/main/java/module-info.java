module ch.bbw.leandro.carvalho.autowerkstattverwaltung.autowerkstattverwaltung {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.json;
    requires org.junit.jupiter.api;
    requires org.junit.platform.commons;


    opens ch.bbw.leandro.carvalho.autowerkstatt.verwaltung to javafx.fxml;
    exports ch.bbw.leandro.carvalho.autowerkstatt.verwaltung;
}